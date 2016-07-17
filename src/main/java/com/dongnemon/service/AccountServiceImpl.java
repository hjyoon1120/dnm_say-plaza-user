package com.dongnemon.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnemon.dao.AccountDAO;
import com.dongnemon.domain.AccountVO;
import com.dongnemon.dto.LoginDTO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO dao;

	@Override
	public AccountVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	
	@Override
	public void keepLogin(String uid, String sessionId, Date next) throws Exception {
		dao.keepLogin(uid, sessionId, next);
	}
	
	@Override
	public AccountVO checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}
	
	
}
