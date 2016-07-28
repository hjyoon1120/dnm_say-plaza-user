package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaReplyVO;

public interface PlazaReplyDAO {

	public void create(PlazaReplyVO vo) throws Exception;

	public void update(PlazaReplyVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<PlazaReplyVO> list(Integer plaza_id) throws Exception;

	public List<PlazaReplyVO> listPage(Integer plaza_id, Criteria cri) throws Exception;

	public int cntReply(Integer plaza_id) throws Exception;

	public int getPlaza_id(Integer id) throws Exception;
	

}
