package sec03.brd01;

import java.sql.Date;

//��ȸ�� ���� �����ϴ� VO������ Ŭ���� 
public class ArticleVO {

	private int level;
	private int articleNo;
	private int parentNo;
	private String title;
	private String content;
	private String imageFileName;
	private String id;
	private Date writeDate;
	
	//�⺻ ������
	public ArticleVO() { }	
	//������ -> ��ü ������ ������ ���� �ʱ�ȭ ����
	public ArticleVO(int level, 
					 int articleNo, 
					 int parentNo, 
					 String title, 
					 String content, 
					 String imageFileName,
					 String id 
					 ) {	
		this.level = level;
		this.articleNo = articleNo;
		this.parentNo = parentNo;
		this.title = title;
		this.content = content;
		this.imageFileName = imageFileName;
		this.id = id;
	}
	
	//getter,setter
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	
	
}






