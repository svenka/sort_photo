package photo_sort;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Gui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5555479037008105413L;
	String way;
	Gui()
	{
	setBounds(0, 0, 500, 500);
	//way="/";
	
	
}
	
	
	public String getway()
	{
		JFileChooser dialog=new JFileChooser();
		dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		dialog.setApproveButtonText("Выбрать");
		dialog.setDialogTitle("Выбор Папки");
		dialog.setDialogType(JFileChooser.OPEN_DIALOG);
		dialog.showOpenDialog(this);
		dialog.setVisible(true);
		System.out.println(dialog.getSelectedFile());
		way=dialog.getSelectedFile().toString();
		System.out.println("Путь ="+way);
		return way;
		
	}
}