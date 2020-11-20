package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.QnADAO;
import com.ssafy.happyhouse.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADAO dao;
	
	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}
	
	@Override
	public boolean writeQnA(QnA qna) {
		System.out.println("insert id : " + qna.getQnaUserid());
		return dao.insertQnA(qna) == 1;
	}

	@Override
	public QnA detailQnA(int no) {
		return dao.selectQnAByNo(no);
	}

	@Override
	@Transactional
	public boolean updateQnA(QnA qna) {
		return dao.updateQnA(qna) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQnA(int no) {
		return dao.deleteQnA(no) == 1;
	}

	@Override
	public boolean replyQnA(QnA qna) {
		return dao.replyQnA(qna) == 1;
	}
}
