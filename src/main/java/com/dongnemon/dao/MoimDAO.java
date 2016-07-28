package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimVO;

public interface MoimDAO {
	
	public void create(MoimVO vo) throws Exception;
	
	public MoimVO read(Integer id) throws Exception;
	
	public void update(MoimVO vo) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	public List<MoimVO> list(Criteria cri) throws Exception;
	
	public int cntPaging(Criteria cri) throws Exception;
	
	public void uptReplyCnt(Integer id, int amount) throws Exception;
	
	public void addAttach(String img_src) throws Exception;
	
	public List<String> getAttach(Integer moim_id) throws Exception;
	
	public void deleteAttach(Integer moim_id) throws Exception;
	
	public void replaceAttach(String img_src, Integer moim_id) throws Exception;
	
}
