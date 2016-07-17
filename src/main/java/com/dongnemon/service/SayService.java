package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayVO;

public interface SayService {

	public void register(SayVO say) throws Exception;
	
	public SayVO read(Integer id) throws Exception;
	
	public void modify(SayVO say) throws Exception;
	
	public void remove(Integer id) throws Exception;
	
	public List<SayVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public void uptLikeCnt(Integer id) throws Exception ;
	
	public List<String> getAttach(Integer say_id) throws Exception;
}
