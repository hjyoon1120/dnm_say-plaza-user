package com.dongnemon.dao;

import java.util.Date;

import com.dongnemon.domain.AccountVO;
import com.dongnemon.dto.LoginDTO;

public interface AccountDAO {
	
	public AccountVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public AccountVO checkUserWithSessionKey(String value);
}
