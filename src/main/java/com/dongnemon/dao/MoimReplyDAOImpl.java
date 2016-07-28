package com.dongnemon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimReplyVO;

@Repository
public class MoimReplyDAOImpl implements MoimReplyDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.MoimReplyDAO";

	@Override
	public void create(MoimReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(MoimReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {

		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<MoimReplyVO> list(Integer moim_id) throws Exception {

		return session.selectList(namespace + ".list", moim_id);
	}

	@Override
	public List<MoimReplyVO> listPage(Integer moim_id, Criteria cri) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("moim_id", moim_id);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int cntReply(Integer moim_id) throws Exception {

		return session.selectOne(namespace + ".cntReply", moim_id);
	}

	@Override
	public int getMoim_id(Integer id) throws Exception {

		return session.selectOne(namespace + ".getMoim_id", id);
	}
}
