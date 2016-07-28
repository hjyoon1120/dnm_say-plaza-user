package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimReplyVO;

public interface MoimReplyDAO {

	public void create(MoimReplyVO vo) throws Exception;

	public void update(MoimReplyVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<MoimReplyVO> list(Integer moim_id) throws Exception;

	public List<MoimReplyVO> listPage(Integer moim_id, Criteria cri) throws Exception;

	public int cntReply(Integer moim_id) throws Exception;

	public int getMoim_id(Integer id) throws Exception;
	

}
