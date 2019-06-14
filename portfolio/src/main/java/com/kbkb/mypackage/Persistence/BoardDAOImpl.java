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

	// �ۼ�
	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);
	}
	// ��ȸ

	@Override
	public BoardVO read(int idx) throws Exception {
		return sql.selectOne(namespace + ".read", idx);
	}

	// ����
	@Override
	public void update(BoardVO vo) throws Exception {
		sql.update(namespace + ".update", vo);
	}

	// ����
	@Override
	public void delete(int idx) throws Exception {
		sql.delete(namespace + ".delete", idx);
	}

	// ���
	@Override
	public List<BoardVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	// ��� + ����¡
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception{
		return sql.selectList(namespace + ".listPage", cri);
	}
	// �Խù� �� ����
	
	@Override
	public int listCount() throws Exception{
		return sql.selectOne(namespace+".listCount");
	}
	
	
	//  ���  + ����¡ + �˻�
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception{
		return sql.selectList(namespace + ".listSearch", scri);
	}
	
	// �˻���� ����
	
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		return sql.selectOne(namespace + ".countSearch", scri);
	}
	
}
