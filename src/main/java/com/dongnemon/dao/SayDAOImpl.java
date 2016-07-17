package com.dongnemon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayVO;

@Repository
public class SayDAOImpl implements SayDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.SayDAO";

	@Override
	public void create(SayVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public SayVO read(Integer id) throws Exception {
		return session.selectOne(namespace + ".read", id);
	}

	@Override
	public void update(SayVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {
		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<SayVO> list(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public int cntPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".cntPaging", cri);
	}
	
	@Override
	public void uptReplyCnt(Integer id, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", id);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".uptReplyCnt", paramMap);
	}
	
	@Override
	public void uptLikeCnt(Integer say_id) throws Exception {
		session.update(namespace + ".uptLikeCnt", say_id);
	}
	
	@Override
	public void addAttach(String img_src) throws Exception {
		session.insert(namespace + ".addAttach", img_src);
	}
	
	@Override
	public List<String> getAttach(Integer say_id) throws Exception {
		return session.selectList(namespace + ".getAttach", say_id);
	}
	
	@Override
	public void deleteAttach(Integer say_id) throws Exception {
		session.delete(namespace + ".deleteAttach", say_id);
	}
	
	@Override
	public void replaceAttach(String img_src, Integer say_id) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("say_id", say_id);
		paramMap.put("img_src", img_src);
		
		session.insert(namespace + ".replaceAttach", paramMap);
	}
}
