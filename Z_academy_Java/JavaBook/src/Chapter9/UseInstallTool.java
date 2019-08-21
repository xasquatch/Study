package Chapter9;

class InstallTool {
	void copy() {
		System.out.println("���� ����");
	}

	void install() throws Exception {
		System.out.println("��ġ");
		if (Math.random() > 0) {
			throw new Exception("��ġ�������� ���� �߻�");
		}
	}

	void delete() {
		System.out.println("���� ����");
	}
}

public class UseInstallTool {

	public static void main(String[] args) {
		
		InstallTool tool = new InstallTool();
		try {
			tool.copy();
			tool.install();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			tool.delete();
		}
		System.out.println("��ġ����");
	}

}