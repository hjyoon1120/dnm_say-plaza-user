package com.dongnemon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaReplyVO;

@Repository
public class PlazaReplyDAOImpl implements PlazaReplyDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.PlazaReplyDAO";

	@Override
	public void create(PlazaReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(PlazaReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {

		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<PlazaReplyVO> list(Integer plaza_id) throws Exception {

		return session.selectList(namespace + ".list", plaza_id);
	}

	@Override
	public List<PlazaReplyVO> listPage(Integer plaza_id, Criteria cri) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("plaza_id", plaza_id);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int cntReply(Integer plaza_id) throws Exception {

		return session.selectOne(namespace + ".cntReply", plaza_id);
	}

	@Override
	public int getPlaza_id(Integer id) throws Exception {

		return session.selectOne(namespace + ".getPlaza_id", id);
	}
}
