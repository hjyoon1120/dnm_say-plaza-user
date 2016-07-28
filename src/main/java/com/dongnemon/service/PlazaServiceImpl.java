package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.PlazaDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaVO;

@Service
public class PlazaServiceImpl implements PlazaService {

	@Autowired
	private PlazaDAO dao;

	@Transactional
	@Override
	public void register(PlazaVO plaza) throws Exception {
		dao.create(plaza);

		String[] files = plaza.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.addAttach(fileName);
		}
	}

	@Override
	public PlazaVO read(Integer id) throws Exception {
		return dao.read(id);
	}

	@Transactional
	@Override
	public void modify(PlazaVO plaza) throws Exception {
		dao.update(plaza);

		Integer plaza_id = plaza.getId();

		dao.deleteAttach(plaza_id);

		String[] files = plaza.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, plaza_id);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws Exception {
		dao.deleteAttach(id);
		dao.delete(id);
	}

	@Override
	public List<PlazaVO> listTopic(Criteria cri) throws Exception {
		return dao.listTopic(cri);
	}

	@Override
	public int cntPagingTopic(Criteria cri) throws Exception {
		return dao.cntPagingTopic(cri);
	}

	@Override
	public List<PlazaVO> listSaying(Criteria cri) throws Exception {
		return dao.listSaying(cri);
	}

	@Override
	public int cntPagingSaying(Criteria cri) throws Exception {
		return dao.cntPagingSaying(cri);
	}

	@Override
	public void uptLikeCnt(Integer id) throws Exception {
		dao.uptLikeCnt(id);
	}

	@Override
	public List<String> getAttach(Integer plaza_id) throws Exception {
		return dao.getAttach(plaza_id);
	}
}
