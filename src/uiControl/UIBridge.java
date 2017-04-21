package uiControl;

import java.io.File;

import ui.MainFrame;

public class UIBridge {

	static public void setFileInputResultText(MainFrame mainFrame, String text)
	{
		mainFrame.getFileInputResultText().setText(text);
	}
	static public void setSearchPathResultText(MainFrame mainFrame, String text) {
		mainFrame.getSearchPathResultText().setText(text);
	}
	static public File getInputFile(MainFrame mainFrame)
	{
		return mainFrame.getSelectedFile();
	}
}
