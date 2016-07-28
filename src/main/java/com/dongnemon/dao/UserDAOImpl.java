package com.dongnemon.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession session;

	private static String namespace = "com.dongnemon.dao.UserDAO";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void keepLogin(int id, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("id", id);
		paramMap.put("sess", sessionId);
		paramMap.put("sessionlimit", next);

		session.update(namespace + ".keepLogin", paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {

		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}

	@Override
	public void create(UserVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public UserVO read(Integer id) throws Exception {
		return session.selectOne(namespace + ".read", id);
	}

	@Override
	public void update(UserVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer id) throws Exception {
		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<UserVO> list(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public int cntPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".cntPaging");
	}

	@Override
	public void addAttach(String img_src) throws Exception {
		session.insert(namespace + ".addAttach", img_src);
	}

	@Override
	public List<String> getAttach(Integer user_id) throws Exception {
		return session.selectList(namespace + ".getAttach", user_id);
	}

	@Override
	public void deleteAttach(Integer user_id) throws Exception {
		session.delete(namespace + ".deleteAttach", user_id);
	}

	@Override
	public void replaceAttach(String img_src, Integer user_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("user_id", user_id);
		paramMap.put("img_src", img_src);

		session.insert(namespace + ".replaceAttach", paramMap);
	}

}
