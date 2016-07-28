package com.dongnemon.service;

import java.util.Date;
import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(int id, String sessionId, Date next) throws Exception;
	
	public UserVO checkLoginBefore(String value);
	
	public void register(UserVO vo) throws Exception;
	
	public UserVO read(Integer id) throws Exception;
	
	public void modify(UserVO vo) throws Exception;
	
	public void remove(Integer id) throws Exception;
	
	public List<UserVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public List<String> getAttach(Integer user_id) throws Exception;

}
