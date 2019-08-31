package com.common.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 메서드 레벨에서만 적용되며, 해당 애너테이션을 사용할 경우
 * 공통 서비스 AOP에서 해당 메서드의 공통 로깅을 작업하지 않는다
 *
 * @see    com.common.aop.CommonAspect.commonServiceMethodAspect()
 * @author Dong-Min-Seol
 * @since  2019. 08. 15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLogging {

	// [1] 메서드 정상 수행 시 로깅 안함
	boolean inScuuess()   default true;

	// [2] 메서드 예외 발생시 로깅 안함
	boolean inException() default false;
}
