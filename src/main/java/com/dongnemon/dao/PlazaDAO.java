package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaVO;

public interface PlazaDAO {
	
	public void create(PlazaVO vo) throws Exception;

	public PlazaVO read(Integer id) throws Exception;

	public void update(PlazaVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<PlazaVO> listTopic(Criteria cri) throws Exception;
	
	public int cntPagingTopic(Criteria cri) throws Exception;
	
	public List<PlazaVO> listSaying(Criteria cri) throws Exception;
	
	public int cntPagingSaying(Criteria cri) throws Exception;
	
	public void uptReplyCnt(Integer id, int amount) throws Exception;
	
	public void uptLikeCnt(Integer id) throws Exception ;
	
	public void addAttach(String img_src) throws Exception;
	
	public List<String> getAttach(Integer plaza_id) throws Exception;
	
	public void deleteAttach(Integer plaza_id) throws Exception;
	
	public void replaceAttach(String img_src, Integer plaza_id) throws Exception;
}
