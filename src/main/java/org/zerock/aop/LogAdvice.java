package org.zerock.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;



//@Component
@Aspect
@Log4j
public class LogAdvice {
	
	@Before( "execution(* org.zerock.service.SampleService*.*(String,String)) && args(str1,str2)") //띄어쓰기 중요. 실행 전에 이걸 먼저 실행
	public void logBefore(String str1, String str2) {
		
		log.info("=-----------------" + str1);
		log.info("=-----------------" + str2);
		
	}
	
	//after, afterreturning 차이는 반환 전 후 차이
	@AfterReturning( "execution(* org.zerock.service.SampleService*.*(..))") //띄어쓰기 중요. 실행 후에 이걸 먼저 실행
	public void logAfter() {
		
		log.info("~~~~~~~~~~~~~~~~~~~~");
		
	}

}
