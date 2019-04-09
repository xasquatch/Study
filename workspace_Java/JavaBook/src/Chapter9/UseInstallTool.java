package Chapter9;

class InstallTool {
	void copy() {
		System.out.println("파일 복사");
	}

	void install() throws Exception {
		System.out.println("설치");
		if (Math.random() > 0) {
			throw new Exception("설치과정에서 문제 발생");
		}
	}

	void delete() {
		System.out.println("파일 삭제");
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
		System.out.println("설치종료");
	}

}
