package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.SayDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayVO;

@Service
public class SayServiceImpl implements SayService {

	@Autowired
	private SayDAO dao;

	@Transactional
	@Override
	public void register(SayVO say) throws Exception {
		dao.create(say);

		String[] files = say.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.addAttach(fileName);
		}
	}

	@Override
	public SayVO read(Integer id) throws Exception {
		return dao.read(id);
	}

	@Transactional
	@Override
	public void modify(SayVO say) throws Exception {
		dao.update(say);

		Integer say_id = say.getId();

		dao.deleteAttach(say_id);

		String[] files = say.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, say_id);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws Exception {
		dao.deleteAttach(id);
		dao.delete(id);
	}

	@Override
	public List<SayVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int cntPaging(Criteria cri) throws Exception {
		return dao.cntPaging(cri);
	}

	@Override
	public void uptLikeCnt(Integer id) throws Exception {
		dao.uptLikeCnt(id);
	}

	@Override
	public List<String> getAttach(Integer say_id) throws Exception {
		return dao.getAttach(say_id);
	}
}
