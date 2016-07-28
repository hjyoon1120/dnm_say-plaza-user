package com.dongnemon.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.UserDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void keepLogin(int id, String sessionId, Date next) throws Exception {
		dao.keepLogin(id, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}
	
	@Transactional
	@Override
	public void register(UserVO vo) throws Exception {
		dao.create(vo);
		
		String[] files = vo.getFiles();
		
		if(files == null) { return; }
		
		for (String fileName : files) {
			System.out.println("fileName: " + fileName);
			dao.addAttach(fileName);
		}
	}
	
	@Override
	public UserVO read(Integer id) throws Exception {
		return dao.read(id);
	}
	
	
	@Transactional
	@Override
	public void modify(UserVO vo) throws Exception {
		dao.update(vo);
		
		Integer user_id = vo.getId();
		
		dao.deleteAttach(user_id);
		
		String[] files = vo.getFiles();
		
		if (files == null) {
			return;
		}
		
		for(String fileName : files) {
			dao.replaceAttach(fileName, user_id);
		}
	}
	
	@Transactional
	@Override
	public void remove(Integer id) throws Exception {
		dao.deleteAttach(id);
		dao.delete(id);
	}
	
	@Override
	public List<UserVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}
	
	@Override
	public int cntPaging(Criteria cri) throws Exception{
		return dao.cntPaging(cri);
	}
	
	@Override
	public List<String> getAttach(Integer user_id) throws Exception {
		return dao.getAttach(user_id);
	}

}
