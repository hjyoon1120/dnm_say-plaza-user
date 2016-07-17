package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayReplyVO;

public interface SayReplyDAO {

	public void create(SayReplyVO vo) throws Exception;

	public void update(SayReplyVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<SayReplyVO> list(Integer say_id) throws Exception;

	public List<SayReplyVO> listPage(Integer say_id, Criteria cri) throws Exception;

	public int cntReply(Integer say_id) throws Exception;

	public int getSay_id(Integer id) throws Exception;
	

}
