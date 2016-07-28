package com.dongnemon.dao;

import java.util.Date;
import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;

	public void keepLogin(int id, String sessionId, Date next);

	public UserVO checkUserWithSessionKey(String value);

	public void create(UserVO vo) throws Exception;

	public UserVO read(Integer id) throws Exception;

	public void update(UserVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<UserVO> list(Criteria cri) throws Exception;

	public int cntPaging(Criteria cri) throws Exception;

	public void addAttach(String img_src) throws Exception;

	public List<String> getAttach(Integer user_id) throws Exception;

	public void deleteAttach(Integer user_id) throws Exception;

	public void replaceAttach(String img_src, Integer user_id) throws Exception;
}
