package Chapter16;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEx extends JFrame {

	JLabel ImageLabel;
	
	class OpenListener implements ActionListener{
		JFileChooser chooser = new JFileChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			
			String filepath = chooser.getSelectedFile().getPath();
			ImageLabel.setIcon(new ImageIcon(filepath));
			
			pack();
		}	
	}
	
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new OpenListener());
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmEdie = new JMenuItem("Exit");
		mntmEdie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnNewMenu.add(mntmEdie);
		
		JMenu mnNewMenu_1 = new JMenu("edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Setting Color");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		ImageLabel = new JLabel("Image Label");
		getContentPane().add(ImageLabel, BorderLayout.CENTER);
		
		setSize(new Dimension(300, 300));
		setVisible(true);
		setTitle("MenuEx");
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
}
