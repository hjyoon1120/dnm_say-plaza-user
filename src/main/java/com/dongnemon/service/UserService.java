package com.dongnemon.service;

import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;

}
