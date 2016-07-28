package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimReplyVO;

public interface MoimReplyService {

	public void addReply(MoimReplyVO vo) throws Exception;

	public void modifyReply(MoimReplyVO vo) throws Exception;

	public void removeReply(Integer id) throws Exception;

	public List<MoimReplyVO> listReply(Integer moim_id) throws Exception;

	public List<MoimReplyVO> listReplyPage(Integer moim_id, Criteria cri) throws Exception;

	public int cntReply(Integer moim_id) throws Exception;

}
