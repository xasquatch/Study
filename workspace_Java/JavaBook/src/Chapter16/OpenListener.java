package Chapter16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class OpenListener implements ActionListener{

	JFileChooser chooser = new JFileChooser();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FileNameExtensionFilterfilter =
				new FileNameExtensionFilter("JPG & Gif Images","jpg","gif");
				chooser.setFileFilter(filter);
				intret = chooser.showOpenDialog(null);
				// 사용자가창을강제로닫았거나취소버튼을누른경우
				if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을선택하지않았습니다",
				"경고", JOptionPane.WARNING_MESSAGE);
				return;
				}
				// 사용자가파일을선택하고"열기" 버튼을누른경우
				String filePath= chooser.getSelectedFile().getPath();.
				imageLabel.setIcon(new ImageIcon(filePath));
				pack();
				}
	
	

}
