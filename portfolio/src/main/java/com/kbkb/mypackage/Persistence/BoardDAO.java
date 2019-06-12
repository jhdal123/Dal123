package com.kbkb.mypackage.Persistence;

import java.util.List;

import com.kbkb.mypackage.domain.BoardVO;

public interface BoardDAO {
	
	public void write(BoardVO vo) throws Exception;
	
	public BoardVO read(int idx) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(int idx) throws Exception;
	
	public List<BoardVO> list() throws Exception;
}
