package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.T1Mapper;
import org.zerock.mapper.T2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleServiceImpl implements SampleService {
	

	@Setter(onMethod_ = @Autowired)
	private T1Mapper t1Mapper;
	
	@Setter(onMethod_ = @Autowired)	
	private T2Mapper t2Mapper;

	@Override
	public Integer doAdd(String str1, String str2) throws Exception { //스트링 받는데 정수 반환
		
		Thread.sleep(3000);//쿼리 실행 시간 테스트용
		
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	
	}

	@Transactional //모두 다 되지 않도록  하는 것.
	@Override
	public void addMulti(String str) {
		// TODO Auto-generated method stub
		t1Mapper.insert(str);
		t2Mapper.insert(str);
		
	}

}
