package com.dongnemon.service;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimVO;

public interface MoimService {

	public void register(MoimVO moim) throws Exception;
	
	public MoimVO read(Integer id) throws Exception;
	
	public void modify(MoimVO moim) throws Exception;
	
	public void remove(Integer id) throws Exception;
	
	public List<MoimVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public List<String> getAttach(Integer moim_id) throws Exception;
}
