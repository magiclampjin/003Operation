package com.operation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.operation.dto.FileDTO;
import com.operation.dto.QnaAnswerFileDTO;
import com.operation.dto.QnaQuestionFileDTO;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession db;
	
	
	// 자유/질문 게시판 파일 삽입
	public int insert(FileDTO dto) {
		return db.insert("File.insert",dto);
	}
	
	// qna 질문 게시글 파일 삽입
	public int insert(QnaQuestionFileDTO dto) {
		return db.insert("File.qnaInsert",dto);
	}
	
	// qna 답변 게시글 파일 삽입
	public int insert(QnaAnswerFileDTO dto) {
		return db.insert("File.qnaAwnserInsert",dto);
	}
		
	
	// 파일 삭제
	public int delete(Integer[] array) {
		return db.delete("File.delete",array);
	}
	
	// 삭제할 파일 origin_name 가져오기 (서버 컴퓨터에서 삭제하기 위함.)
	public List<String> selectByIds(Integer[] array) {
		List<String> result = db.selectList("File.selectByIds",array);
		return result;
	}
	
	// 기존 파일 전체 삭제
	public int deleteAllByPostId(int bulletin_board_id) {
		return db.delete("File.deleteAllByPostId",bulletin_board_id);
	}
	
	// 자유 or 질문 게시글 삭제할 파일 origin_name 가져오기 (서버 컴퓨터에서 삭제하기 위함.)
	public List<String> selectAllByPostId(int bulletin_board_id) {
		return db.selectList("File.selectAllByPostId",bulletin_board_id);
	}
	
	// qna 질문 게시글 삭제할 파일 origin_name 가져오기 (서버 컴퓨터에서 삭제하기 위함.)
	public List<String> selectAllByQnaQId(int qna_question_board_id) {
		return db.selectList("File.selectAllByQnaQId",qna_question_board_id);
	}
}
