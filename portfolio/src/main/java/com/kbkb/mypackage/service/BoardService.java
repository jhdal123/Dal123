package com.kbkb.mypackage.service;

import java.util.List;

import com.kbkb.mypackage.domain.BoardVO;

public interface BoardService {
	
	// �ۼ�
	public void write(BoardVO vo) throws Exception;
	
	// ��ȸ
	public BoardVO read(int idx) throws Exception;

	// ����
	public void update(BoardVO vo) throws Exception;
	
	// ����
	public void delete(int idx) throws Exception;
	
	// ���
	public List<BoardVO> list() throws Exception;
}
