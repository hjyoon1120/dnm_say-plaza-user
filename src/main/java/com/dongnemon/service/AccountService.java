package com.dongnemon.service;

import java.util.Date;

import com.dongnemon.domain.AccountVO;
import com.dongnemon.dto.LoginDTO;

public interface AccountService {
	
	public AccountVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;
	
	public AccountVO checkLoginBefore(String value);

}
