package Chapter16;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MenuEx extends JFrame {

	JLabel ImageLabel;
	
	class OpenListener implements ActionListener{
		JFileChooser chooser = new JFileChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & Gif Images","jpg","gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);

			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을선택하지않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				
				return;
			}

			String filePath= chooser.getSelectedFile().getPath();
			ImageLabel.setIcon(new ImageIcon(filePath));
			
			pack();
		}	
	}
	
	class SaveListener implements ActionListener{

		JFileChooser chooser = new JFileChooser();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & Gif Images","jpg","gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showSaveDialog(null);
			
			if(ret == JFileChooser.APPROVE_OPTION) {
				String filePath= chooser.getSelectedFile().getPath();
				File saveFile= new File(filePath);
				//이미지공간확보하기
				BufferedImage newImage= new BufferedImage(ImageLabel.getIcon().getIconWidth(),
				ImageLabel.getIcon().getIconHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = newImage.getGraphics();
				ImageLabel.getIcon().paintIcon(null, g, 0, 0);//생성된공간에그리기(복사)
				g.dispose(); //만들어진그래픽삭제
				
				try {
					ImageIO.write(newImage, "jpg", saveFile);
				}catch (IOException ex) {ex.printStackTrace();}
					
			}
		}
	}
	
	class ColorListener implements ActionListener{

		JColorChooser chooser = new JColorChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			Color selectedColor = chooser.showDialog(null, "Color", Color.BLUE);
			
			if (selectedColor != null) {
				ImageLabel.setOpaque(true);
				ImageLabel.setText("COLOR");
				ImageLabel.setBackground(selectedColor);
				
			}
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
		mntmSave.addActionListener(new SaveListener());
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
		mntmNewMenuItem.addActionListener(new ColorListener());
		mnNewMenu_1.add(mntmNewMenuItem);
		
		ImageLabel = new JLabel("Image Label");
		getContentPane().add(ImageLabel, BorderLayout.CENTER);
		
		setSize(new Dimension(300, 300));
		setTitle("MenuEx");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}
}