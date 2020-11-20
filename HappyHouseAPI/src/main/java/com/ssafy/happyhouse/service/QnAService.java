package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	List<QnA> retrieveQnA();
	public QnA detailQnA(int no);
	public boolean writeQnA(QnA qna);
	public boolean updateQnA(QnA qna);
	public boolean replyQnA(QnA qna);
	public boolean deleteQnA(int no);
}
