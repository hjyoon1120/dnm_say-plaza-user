package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaVO;

public interface PlazaService {

	public void register(PlazaVO plaza) throws Exception;
	
	public PlazaVO read(Integer id) throws Exception;
	
	public void modify(PlazaVO plaza) throws Exception;
	
	public void remove(Integer id) throws Exception;
	
	public List<PlazaVO> listTopic(Criteria cri) throws Exception;
	
	public int cntPagingTopic(Criteria cri) throws Exception;
	
	public List<PlazaVO> listSaying(Criteria cri) throws Exception;
	
	public int cntPagingSaying(Criteria cri) throws Exception;
	
	public void uptLikeCnt(Integer id) throws Exception ;
	
	public List<String> getAttach(Integer plaza_id) throws Exception;
}
