package com.kbkb.mypackage.service;

import java.util.List;

import com.kbkb.mypackage.domain.BoardVO;
import com.kbkb.mypackage.domain.Criteria;
import com.kbkb.mypackage.domain.SearchCriteria;

public interface BoardService {
	
	// 작성
	public void write(BoardVO vo) throws Exception;
	
	// 조회
	public BoardVO read(int idx) throws Exception;

	// 수정
	public void update(BoardVO vo) throws Exception;
	
	// 삭제
	public void delete(int idx) throws Exception;
	
	// 목록
	public List<BoardVO> list() throws Exception;
	
	// 목록 + 페이징
	public List<BoardVO> listPage(Criteria cri) throws Exception;

	// 게시물 총 갯수
	public int listCount() throws Exception;
	
	// 목록 + 페이징 + 검색
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;
	
	// 목록 검색 갯수
	public int countSearch(SearchCriteria scri) throws Exception;
	
}
