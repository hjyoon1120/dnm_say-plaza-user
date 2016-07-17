package com.dongnemon.dao;

import java.util.Date;

import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
