package com.dongnemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.MessageDAO;
import com.dongnemon.dao.PointDAO;
import com.dongnemon.domain.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO mDao;

	@Autowired
	private PointDAO pDao;

	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {

		mDao.create(vo);
		pDao.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mid) throws Exception {

		mDao.updateState(mid);
		pDao.updatePoint(uid, 5);

		return mDao.readMessage(mid);
	}

}
