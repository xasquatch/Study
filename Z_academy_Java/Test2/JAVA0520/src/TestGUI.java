import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI {

	public static void main(String[] args) {
		MemberGUI m = new MemberGUI();
	}

}
class MemberGUI{
	public MemberGUI() {
		System.out.println("MemberGUI() 호출됨!");
		showFrame();
	}
	public void showFrame() {
		JFrame f = new JFrame("GUI 연습");
        f.setSize(300, 200);
        
        JButton btn = new JButton("버튼클릭"); 
        f.add(btn);
        
        f.setVisible(true);
        
	}
	
}