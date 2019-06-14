package com.kbkb.mypackage.Persistence;

import java.util.List;

import com.kbkb.mypackage.domain.BoardVO;
import com.kbkb.mypackage.domain.Criteria;
import com.kbkb.mypackage.domain.SearchCriteria;

public interface BoardDAO {
	
	public void write(BoardVO vo) throws Exception;
	
	public BoardVO read(int idx) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(int idx) throws Exception;
	
	public List<BoardVO> list() throws Exception;
	
	//��� + ����¡
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	// �Խù� �� ����
	public int listCount() throws Exception;
	
	// ��� + ����¡ + �˻�
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;
	
	// �˻� ��� ����
	public int countSearch(SearchCriteria scri) throws Exception;

	
}
