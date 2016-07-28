package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaReplyVO;

public interface PlazaReplyService {

	public void addReply(PlazaReplyVO vo) throws Exception;

	public void modifyReply(PlazaReplyVO vo) throws Exception;

	public void removeReply(Integer id) throws Exception;

	public List<PlazaReplyVO> listReply(Integer plaza_id) throws Exception;

	public List<PlazaReplyVO> listReplyPage(Integer plaza_id, Criteria cri) throws Exception;

	public int cntReply(Integer plaza_id) throws Exception;

}
