package com.kbkb.mypackage.Persistence;

import java.rmi.server.ExportException;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.kbkb.mypackage.domain.BoardVO;
import com.kbkb.mypackage.domain.Criteria;
import com.kbkb.mypackage.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.kbkb.mypackage.mappers.boardMapper";

	// 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);
	}
	// 조회

	@Override
	public BoardVO read(int idx) throws Exception {
		return sql.selectOne(namespace + ".read", idx);
	}

	// 수정
	@Override
	public void update(BoardVO vo) throws Exception {
		sql.update(namespace + ".update", vo);
	}

	// 삭제
	@Override
	public void delete(int idx) throws Exception {
		sql.delete(namespace + ".delete", idx);
	}

	// 목록
	@Override
	public List<BoardVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	// 목록 + 페이징
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception{
		return sql.selectList(namespace + ".listPage", cri);
	}
	// 게시물 총 갯수
	
	@Override
	public int listCount() throws Exception{
		return sql.selectOne(namespace+".listCount");
	}
	
	
	//  목록  + 페이징 + 검색
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception{
		return sql.selectList(namespace + ".listSearch", scri);
	}
	
	// 검색결과 갯수
	
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace + ".countSearch", scri);
	}
	
}
