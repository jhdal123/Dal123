package com.kbkb.mypackage.service;

import java.util.List;

import com.kbkb.mypackage.domain.BoardVO;

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
}
