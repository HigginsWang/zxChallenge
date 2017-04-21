package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;


public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -17597276056775284L;
	private int width = 500;
	private int height = 500;
	private String title = "中兴挑战赛";
	private boolean visible = true;
	private Color backgroundColor = new Color(255,255,255);
	private Color fileInputResultBackgroundColro = new Color(200,200,200);
	
	private JPanel mainPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JPanel checkBoxPanel = new JPanel();
	
	private LayoutManager checkBoxLayout = new GridLayout(5, 1);
	
	private JButton startSolveButton = new JButton("开始求解路径");
	private JTextArea fileInputResultText = new JTextArea();
	private JTextArea searchPathResultText = new JTextArea();
	private JFileChooser fileChooser = new JFileChooser();
	
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("文件");
	private JMenuItem menuItem = new JMenuItem("选择要测试的输入文件");
	
	private File selectedFile = null;
	
	private String shortComsumptionText = "最短路径约束";
	private String maxPastNodeNumLimitationText = "经过节点数量约束";
	private String mustPastNodeLimitationText = "必须经过一些节点约束";
	private String mustPastEdgeLimitationText = "必须经过一些边约束";
	private String mustNotPastEdgeLimitationText = "必须不经过一些边约束";

	private JCheckBox shortConsumeLimitationCheckBox = new JCheckBox(shortComsumptionText);
	private JCheckBox maxPastNodeNumLimitationCheckBox = new JCheckBox(maxPastNodeNumLimitationText);
	private JCheckBox mustPastNodeLimitationCheckBox = new JCheckBox(mustPastNodeLimitationText);
	private JCheckBox mustPastEdgeLimitationCheckBox = new JCheckBox(mustPastEdgeLimitationText);
	private JCheckBox mustNotPastEdgeLimitationCheckBox = new JCheckBox(mustNotPastEdgeLimitationText);
	
	private ActionListener openFileChooserListener = new OpenFileChooserListener(fileChooser);
	
	private WindowListener mainFrameListener = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		};
	};
	private void InitMainFrame()
	{
		this.setSize(width,height);
		this.setVisible(visible);
		this.setTitle(title);
		this.setBackground(backgroundColor);
		this.addWindowListener(mainFrameListener);
		this.add(mainPanel);
		InitMainPanel();
		InitMenu();
	}
	
	private void InitCheckBoxPanel()
	{
		shortConsumeLimitationCheckBox.setSelected(true);
		shortConsumeLimitationCheckBox.setEnabled(false);
		checkBoxPanel.add(shortConsumeLimitationCheckBox);
		checkBoxPanel.add(maxPastNodeNumLimitationCheckBox);
		checkBoxPanel.add(mustPastNodeLimitationCheckBox);
		checkBoxPanel.add(mustPastEdgeLimitationCheckBox);
		checkBoxPanel.add(mustNotPastEdgeLimitationCheckBox);
		checkBoxPanel.setLayout(checkBoxLayout);
	}
	private void InitResultPanel()
	{
		resultPanel.setLayout(new GridLayout(3, 1));
		resultPanel.add(startSolveButton);
		resultPanel.add(fileInputResultText);
		fileInputResultText.setEditable(false);
		fileInputResultText.setBackground(fileInputResultBackgroundColro);
		
		resultPanel.add(searchPathResultText);
		searchPathResultText.setEditable(false);
	}
	private void InitMenu()
	{
		this.setJMenuBar(menubar);
		menubar.add(menu);
		menu.add(menuItem);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		menuItem.addActionListener(openFileChooserListener);
	}
	private void InitMainPanel()
	{
		InitCheckBoxPanel();
		InitResultPanel();
		mainPanel.add(checkBoxPanel);
		mainPanel.add(resultPanel);
	}
	public MainFrame() {InitMainFrame();}
	class OpenFileChooserListener implements ActionListener
	{
		private JFileChooser jFileChooser;
		private String labelText = "选择文件";
		public OpenFileChooserListener(JFileChooser jFileChooser_){this.jFileChooser = jFileChooser_;}
		@Override
		public void actionPerformed(ActionEvent e) {
			int value = jFileChooser.showDialog(new JLabel(),labelText);
			if(value==JFileChooser.CANCEL_OPTION){return;}
			selectedFile = jFileChooser.getSelectedFile();
//			
//			//测试代码
//			//System.out.println(selectedFile.getName());
//			FileProcess fp = new FileProcess(selectedFile);
//			ReadFileResultData rfrd = fp.ReadFile();
//			rfrd.printf();
		}
	}
	
	public JTextArea getFileInputResultText() {
		return fileInputResultText;
	}
	public JTextArea getSearchPathResultText() {
		return searchPathResultText;
	}
	public File getSelectedFile() {
		return selectedFile;
	}
}


