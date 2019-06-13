package com.kbkb.mypackage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kbkb.mypackage.domain.BoardVO;
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

	// ¸ñ·Ï
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
}
