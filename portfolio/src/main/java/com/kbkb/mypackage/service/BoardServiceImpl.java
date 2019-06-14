package com.kbkb.mypackage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kbkb.mypackage.domain.BoardVO;
import com.kbkb.mypackage.domain.Criteria;
import com.kbkb.mypackage.domain.SearchCriteria;
import com.kbkb.mypackage.Persistence.BoardDAO;

@Repository
public class BoardServiceImpl implements BoardService {

	@Inject
	private com.kbkb.mypackage.Persistence.BoardDAO dao;

	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public BoardVO read(int idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(idx);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);

	}

	@Override
	public void delete(int idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(idx);

	}

	// 목록
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	
	//목록 + 페이징
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception{
		return dao.listPage(cri);
	}
	
	// 게시물 총갯수
	@Override
	public int listCount() throws Exception{
		return dao.listCount();
	}
	
	// 목록 + 페이징 +검색
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}
	
	// 검색 결과 갯수
	
	@Override
	
	public int countSearch(SearchCriteria scri) throws Exception{
		return dao.countSearch(scri);
	}
	
}
