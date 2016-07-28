package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.MoimDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimVO;

@Service
public class MoimServiceImpl implements MoimService {

	@Autowired
	private MoimDAO dao;

	@Transactional
	@Override
	public void register(MoimVO moim) throws Exception {
		dao.create(moim);

		String[] files = moim.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.addAttach(fileName);
		}
	}

	@Override
	public MoimVO read(Integer id) throws Exception {
		return dao.read(id);
	}

	@Transactional
	@Override
	public void modify(MoimVO moim) throws Exception {
		dao.update(moim);

		Integer moim_id = moim.getId();

		dao.deleteAttach(moim_id);

		String[] files = moim.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, moim_id);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws Exception {
		dao.deleteAttach(id);
		dao.delete(id);
	}

	@Override
	public List<MoimVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int cntPaging(Criteria cri) throws Exception {
		return dao.cntPaging(cri);
	}

	@Override
	public List<String> getAttach(Integer moim_id) throws Exception {
		return dao.getAttach(moim_id);
	}
}
