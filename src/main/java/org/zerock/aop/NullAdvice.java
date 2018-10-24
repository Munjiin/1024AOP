package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

//@Component
@Aspect
@Log4j
public class NullAdvice {
	
	//계산 전 널 체크
	@Around( "execution(* org.zerock.service.SampleService*.*(..))") //around : 앞 뒤 체크
	public Object checkNull(ProceedingJoinPoint pjp) { //Proceeding~~ : 리플랙션
		
		log.info("checkNull~~~");
		log.info("checkNull~~~");
		log.info("checkNull~~~");
		
		//실행 방법
		Object result =null;
		
		
		try {
			
			boolean checkNull = false;
			Object[] params = pjp.getArgs(); //파라미터 파악
			
			for (Object object : params) {
				if(object == null) {
					throw new Exception("Null");
				}
			}
			
			result = pjp.proceed(); //메소드를 실행하는 invoke
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
