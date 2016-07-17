package com.dongnemon.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.AccountVO;
import com.dongnemon.dto.LoginDTO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.AccountDAO";

	@Override
	public AccountVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);

		session.update(namespace + ".keepLogin", paramMap);
	}

	@Override
	public AccountVO checkUserWithSessionKey(String value) {

		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}
}
