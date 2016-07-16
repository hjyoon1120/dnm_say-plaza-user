package com.dongnemon.dao;

import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
}
