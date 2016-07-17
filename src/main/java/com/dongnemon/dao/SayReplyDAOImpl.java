package com.dongnemon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayReplyVO;

@Repository
public class SayReplyDAOImpl implements SayReplyDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.SayReplyDAO";

	@Override
	public void create(SayReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(SayReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {

		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<SayReplyVO> list(Integer say_id) throws Exception {

		return session.selectList(namespace + ".list", say_id);
	}

	@Override
	public List<SayReplyVO> listPage(Integer say_id, Criteria cri) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("say_id", say_id);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int cntReply(Integer say_id) throws Exception {

		return session.selectOne(namespace + ".cntReply", say_id);
	}

	@Override
	public int getSay_id(Integer id) throws Exception {

		return session.selectOne(namespace + ".getSay_id", id);
	}
}
