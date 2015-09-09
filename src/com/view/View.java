package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.lexico.Analizador_Lexico;
import com.lexico.Read_Text;
import com.lexico.Simbolo;
import com.lexico.Tabla_de_simbolos;
import com.sintactico.Parser;

public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea jTextAreaErrores;
	private static JTextArea jTextArea;
	// Para explorar directorios para abrir y guardar archivos
	//String NameFileFocus = new String("ok");
	JFileChooser fileChooser = null;
	// Para escribir texto
	//JEditorPane editPane;
	JTextArea editPane;
	JTextArea lineNumArea;
	// Scroll del lado derecho
	JScrollPane scrollPaneRight;

	// Panel izquierdo donde va la lista de archivo abiertos
	JPanel leftPanel;
	// La barra del Menu
	JMenuBar menuBar;
	// El menu
	JMenu fileMenu;
	// Los items del menu
	JMenuItem newMenu;
	JMenuItem openMenu;
	JMenuItem saveMenu;
	JMenuItem exitMenu;
	JMenuItem aboutMenu;
	// Contenedor con divisio izquierda derecha
	JSplitPane splitPane;
	// El panel del estado y sus mensajes
	JPanel statusPanel;
	JLabel statusMsg1;
	JLabel statusMsg2;
	// Tool bar
	JToolBar toolBar;
	// Todos los botones
	JButton openButton;
	JButton lexicoButton;
	JButton openSelectedButton;
	String fileName;
	boolean isSaved = false;
	private JTable table_symbol;
	private JTable table_errores;
	
	private JPanel jOutContentPane;
	private JScrollPane pScroll;
	private JScrollPane pScrollTabla;
	private JScrollPane pScrollErrores;
	private JPanel jPane;
	private JDialog aboutDialog;
	private JPanel aboutContentPane;

	ActionListener eventHandler = new EventHandler();
	private JPanel editor;
	private JScrollPane scrollHorizonalEditPane;
	
	class EventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exitMenu) {
				System.exit(0);
			}
			if (e.getSource() == openMenu || e.getSource() == openButton) {
				openFile();

			}
			if (e.getSource() == aboutMenu) {
				JDialog aboutDialog = getAboutDialog();
				aboutDialog.setVisible(true);
			}
			if (e.getSource() == lexicoButton) {
				Analizar();

			}
			 
		}

	};
	
	
	public View(String title) {
		super(title);
	}

	public void initialize() {

		this.getContentPane().setLayout(new BorderLayout());

		/** ***JMenuBar**** */
		CreateJMenuBar();
		this.setJMenuBar(menuBar);

		/** ***JToolBar**** */
		CreateJToolBar();
		this.getContentPane().add(toolBar, BorderLayout.NORTH);

		/** ***Status bar**** */
		statusPanel = new JPanel();
		statusPanel.setLayout(new BorderLayout());
		statusMsg1 = new JLabel("Estado: ");
		statusMsg2 = new JLabel();
		statusPanel.add(statusMsg1, BorderLayout.WEST);
		statusPanel.add(statusMsg2, BorderLayout.CENTER);
		// Agrega el panel de satus al sur del contenedor
		this.getContentPane().add(statusPanel, BorderLayout.SOUTH);

		/***********************************************************************
		 * 
		 * jOutContentPane es el panel donde van ha salir las salidas, una vez
		 * que se compile, en primera instancia mostraria los errores, y algo
		 * mas.
		 * 
		 * Text Editor
		 **********************************************************************/

		editor = new JPanel(new BorderLayout());
		
		editPane = new JTextArea();
		editPane.setText("");
		editPane.setEnabled(true);
		editPane.setEditable(true);
		editPane.setBackground(SystemColor.control);
		
		
		editPane.setLayout(new BorderLayout());
		
		scrollHorizonalEditPane = new JScrollPane(editPane);
		TextLineNumber tln = new TextLineNumber(editPane);
		scrollHorizonalEditPane.setRowHeaderView(tln);
		editor.add(scrollHorizonalEditPane,BorderLayout.CENTER);
		scrollPaneRight = new JScrollPane(editor);
		scrollPaneRight = new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jOutContentPane = this.getJContentPane();
		this.getContentPane().add(jOutContentPane, BorderLayout.CENTER);
	}
	
	// Suscribe los objetos al manejador de eventos eventHandler
	public void initConnections() {

		openMenu.addActionListener(eventHandler);
		exitMenu.addActionListener(eventHandler);
		openButton.addActionListener(eventHandler);
		lexicoButton.addActionListener(eventHandler);
		aboutMenu.addActionListener(eventHandler);

		editPane.setText("");
		editPane.setEditable(true);
		editPane.setBackground(Color.white);
		
	}
	

	// Para abrir un achivo existente
	public void openFile() {
		// Si no existe el file chooser, crea uno
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		// Valor que retorna al elegir una opcion en el file chooser
		int retVal = fileChooser.showOpenDialog(this);
		// Si se escogio Ok, (o abrir)
		if (retVal == JFileChooser.APPROVE_OPTION) {
			// El path absoluto del archivo elegido
			fileName = fileChooser.getSelectedFile().getAbsolutePath();
			try {
							
				editPane.setText("");
				lineNumArea.setText("");
				loadEditPane(fileName);				
				
				editPane.setEditable(true);
				editPane.setBackground(Color.white);				
				isSaved = false;
			} catch (Exception ioe) {
				statusMsg2.setText(ioe.getMessage());
			}
		}
	}
	
	private void loadEditPane(String path) {
		try {
			String linea = "";			
			int line = 1;
			boolean exit = false;
			while (!exit) {
				linea = archivo.readLine();
				if (linea == null)
					exit = true;
				else {
					editPane.append("\t" + linea + "\n");
					lineNumArea.append(String.valueOf(line) + "\n");					
					line++;
				}
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private JPanel getJContentPane() {
		if (jOutContentPane == null) {

			jPane = new JPanel(new GridLayout(2, 1));
			jPane.add(getJScrollPane());
			jPane.add(getJScrollPaneTabla());

			
			jOutContentPane = new JPanel(new GridLayout(1, 2));
			jOutContentPane.add(scrollPaneRight);
			jOutContentPane.add(jPane);
			jOutContentPane.add(getJScrollPaneErrores());

		}
		return jOutContentPane;
	}

	DefaultTableModel TablaSimbolosModel = new DefaultTableModel();
 
	private JScrollPane getJScrollPaneTabla() {
		if (pScrollTabla == null) {
			TablaSimbolosModel.addColumn("Token");
			TablaSimbolosModel.addColumn("Lexema");
			table_symbol = new JTable(TablaSimbolosModel);
			pScrollTabla = new JScrollPane(table_symbol,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pScrollTabla.setBorder(BorderFactory.createTitledBorder(null,
					"Tabla de Símbolos", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return pScrollTabla;
	}

	private JScrollPane getJScrollPane() {
		if (pScroll == null) {
			pScroll = new JScrollPane(getJTextArea(),
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pScroll.setBorder(BorderFactory.createTitledBorder(null,
					"Informacion", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));

		}
		return pScroll;
	}

	DefaultTableModel ErroresModel = new DefaultTableModel();
	private JScrollPane getJScrollPaneErrores() {
		if (pScrollErrores == null) {
			ErroresModel.addColumn("Linea");
			ErroresModel.addColumn("Error");
			table_errores = new JTable(ErroresModel);
			pScrollErrores = new JScrollPane(table_errores,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			pScrollErrores.setBorder(BorderFactory.createTitledBorder(null,
					"Errores - Advertencias", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
		}
		
		return pScrollErrores;
	}

	public static JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

	public static JTextArea getJTextAreaErrores() {
		if (jTextAreaErrores == null) {
			jTextAreaErrores = new JTextArea();
			jTextAreaErrores.setEditable(false);
		}
		return jTextAreaErrores;
	}

	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(this, true);
			aboutDialog.setTitle("Acerca de...");
			aboutDialog.setSize(new Dimension(300, 300));
			aboutDialog.setLocation(new Point(50, 50));
			aboutDialog.setVisible(false);
			aboutDialog.setResizable(false);
			aboutDialog.setPreferredSize(new Dimension(300, 300));
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {

			JLabel jLabelTitulo = new JLabel();
			jLabelTitulo.setBounds(new Rectangle(15, 20, 259, 20));
			jLabelTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelTitulo.setText("Diseño de Compiladores 2015");

			JLabel jLabelTitulo2 = new JLabel();
			jLabelTitulo2.setBounds(new Rectangle(15, 40, 259, 20));
			jLabelTitulo2.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelTitulo2.setText("Analizador Léxico / Sintactico");

			JLabel jLabelGrupo = new JLabel();
			jLabelGrupo.setBounds(new Rectangle(15, 70, 61, 16));
			jLabelGrupo.setText("Grupo -");

			JLabel jLabelIntegrantes = new JLabel();
			jLabelIntegrantes.setBounds(new Rectangle(15, 90, 83, 18));
			jLabelIntegrantes.setText("Integrantes:");

			Font items = new Font("Dialog", Font.PLAIN, 12);

			JLabel jELabel1 = new JLabel();
			jELabel1.setBounds(new Rectangle(25, 120, 260, 16));
			jELabel1.setFont(items);
			jELabel1.setText("Garcia Vandenbosch, Leandro <lgarciavandenbosch@gmail.com>");

			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(null);
			aboutContentPane.setBackground(SystemColor.control);
			aboutContentPane.add(jELabel1, null);
			aboutContentPane.add(jLabelTitulo, null);
			aboutContentPane.add(jLabelTitulo2, null);
			aboutContentPane.add(jLabelIntegrantes, null);
			aboutContentPane.add(jLabelGrupo, null);
		}
		return aboutContentPane;
	}
	
	private void CreateJMenuBar() {
		menuBar = new JMenuBar();
		aboutMenu = new JMenuItem("Acerca...");
		fileMenu = new JMenu("Archivo");
		newMenu = new JMenuItem("Nuevo");
		openMenu = new JMenuItem("Abrir");
		saveMenu = new JMenuItem("Guardar");
		exitMenu = new JMenuItem("Salir");
		// Agrega los items al menu
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.addSeparator();
		fileMenu.add(aboutMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitMenu);
		// Agrega el menu a la barra de menu
		menuBar.add(fileMenu);

	}

	public void CreateJToolBar() {

		System.out.println(getClass().getResource(""));
		toolBar = new JToolBar();
		openButton = new JButton();
		openButton.setToolTipText("Abrir Archivo");
		openButton.setIcon(new ImageIcon(getClass().getResource("../resources/folder-open.png")));
		openButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(openButton);


		toolBar.addSeparator();

		lexicoButton = new JButton();
		lexicoButton.setToolTipText("Ejecutar Analizador Sintactico");
		lexicoButton.setIcon(new ImageIcon(getClass().getResource("../resources/cog.png")));
		lexicoButton.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(lexicoButton);

	}
	
	
	private void cleanAllPane() {

		if (TablaSimbolosModel.getRowCount() > 0) {
		    for (int i = TablaSimbolosModel.getRowCount() - 1; i > -1; i--) {
		    	TablaSimbolosModel.removeRow(i);
		    }
		}
		
		if (ErroresModel.getRowCount() > 0) {
		    for (int i = ErroresModel.getRowCount() - 1; i > -1; i--) {
		    	ErroresModel.removeRow(i);
		    }
		}
	};
	
	static String path="";
	private static DefaultTableModel model = null;
	private static DefaultTableModel modelerror = null;
	private static BufferedReader archivo;
	
	public void Analizar(){
		
		cleanAllPane();
		lineNumArea = new JTextArea();
		model = new DefaultTableModel();
		modelerror = new DefaultTableModel();
		Analizador_Lexico al = new Analizador_Lexico(new Tabla_de_simbolos(model), new Read_Text(editPane.getText()), modelerror, jTextArea);
		Parser parser = new Parser(al,model,true);
		parser.run();

		//Cargar Tabla de Simbolos
		Enumeration<String> enumKey = al.getTabladeSimbolos().getTablaDeSimbolos().keys();
		while(enumKey.hasMoreElements()) {
		    Simbolo simbolo = al.getTabladeSimbolos().getSimbolo(enumKey.nextElement());
		    TablaSimbolosModel.addRow(new Object[]{simbolo.getToken(), simbolo.getLexema()});
		}
		
		//Print Errores Lexicos
		Vector data = al.getErroresLexico().getDataVector();
		for (int i = 0; i < data.size(); i++)
		{
			Vector error = (Vector) data.get(i);
			ErroresModel.addRow(new Object[]{error.get(0), error.get(1)});
		}
		
		//jTextArea.setText("leandro \n");
		//jTextArea.setText( jTextArea.getText() + "leandro \n");
		
		
	}
}
