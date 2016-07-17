package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayVO;

public interface SayDAO {
	
	public void create(SayVO vo) throws Exception;

	public SayVO read(Integer id) throws Exception;

	public void update(SayVO vo) throws Exception;

	public void delete(Integer id) throws Exception;

	public List<SayVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public void uptReplyCnt(Integer id, int amount) throws Exception;
	
	public void uptLikeCnt(Integer id) throws Exception ;
	
	public void addAttach(String img_src) throws Exception;
	
	public List<String> getAttach(Integer say_id) throws Exception;
	
	public void deleteAttach(Integer say_id) throws Exception;
	
	public void replaceAttach(String img_src, Integer say_id) throws Exception;
}
