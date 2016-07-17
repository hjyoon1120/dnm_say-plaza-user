package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayReplyVO;

public interface SayReplyService {

	public void addReply(SayReplyVO vo) throws Exception;

	public void modifyReply(SayReplyVO vo) throws Exception;

	public void removeReply(Integer id) throws Exception;

	public List<SayReplyVO> listReply(Integer say_id) throws Exception;

	public List<SayReplyVO> listReplyPage(Integer say_id, Criteria cri) throws Exception;

	public int cntReply(Integer say_id) throws Exception;

}
