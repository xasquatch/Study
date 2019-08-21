package com.bean.board;

import java.util.Vector;

/*
 DAO클래스는 DB작업을 할 클래스이다.
 만약 DAO클래스를 설계 할 때 팀프로젝트로 진행한다면
 철수는 게시판에 글을 추가하는 메소드 이름을 BoardInsert()라고 정하고
 영미는 게시판에 글을 추가하는 메소드이름을 Insert()라고 정할수도 있다.
 문제점 : 똑같은 기능의 메소드이름을 다르게 지정하면 팀원끼리 혼란이 옴
 	그래서 하나의 메소드 이름으로 규칙정함
 결론 : 어떠한 기준(원칙)을 정해줄 수 있게 하는 것이 인터페이스이다.

 
 */

//(게시판 기능)의 추상메소드의 이름(규칙)을 정해 놓은 인터페이스 만들기
public interface IBoardDAO {
	// DB에 있는 모든 글을 검색 기능 메소드
	public Vector getBoardList(String keyField, String keyWord);

	// DB에 있는 전체 글 중에서 하나의 글에 대한 정보만 검색하는 기능의 메소드
	public BoardDTO getBoard(int num);

	// 글쓰기 기능 메소드
	public void insertBoard(BoardDTO dto);

	// 글 수정 메소드
	public void updateBoard(BoardDTO dto);

	// 글 삭제 메소드
	public void deleteBoard(int num);

	// 글 답변기능 메소드
	public void replayBoard(BoardDTO dto);

}
