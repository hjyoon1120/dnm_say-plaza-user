package com.dongnemon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaVO;

@Repository
public class PlazaDAOImpl implements PlazaDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.PlazaDAO";

	@Override
	public void create(PlazaVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public PlazaVO read(Integer id) throws Exception {
		return session.selectOne(namespace + ".read", id);
	}

	@Override
	public void update(PlazaVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {
		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<PlazaVO> listTopic(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list_topic", cri);
	}

	@Override
	public int cntPagingTopic(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".cntPaging_topic", cri);
	}
	
	@Override
	public List<PlazaVO> listSaying(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list_saying", cri);
	}

	@Override
	public int cntPagingSaying(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".cntPaging_saying", cri);
	}
	
	@Override
	public void uptReplyCnt(Integer id, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", id);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".uptReplyCnt", paramMap);
	}
	
	@Override
	public void uptLikeCnt(Integer plaza_id) throws Exception {
		session.update(namespace + ".uptLikeCnt", plaza_id);
	}
	
	@Override
	public void addAttach(String img_src) throws Exception {
		session.insert(namespace + ".addAttach", img_src);
	}
	
	@Override
	public List<String> getAttach(Integer plaza_id) throws Exception {
		return session.selectList(namespace + ".getAttach", plaza_id);
	}
	
	@Override
	public void deleteAttach(Integer plaza_id) throws Exception {
		session.delete(namespace + ".deleteAttach", plaza_id);
	}
	
	@Override
	public void replaceAttach(String img_src, Integer plaza_id) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("plaza_id", plaza_id);
		paramMap.put("img_src", img_src);
		
		session.insert(namespace + ".replaceAttach", paramMap);
	}
}
