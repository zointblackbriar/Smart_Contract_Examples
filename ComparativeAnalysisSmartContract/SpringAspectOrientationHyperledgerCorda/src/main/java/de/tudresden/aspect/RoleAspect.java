package de.tudresden.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Aspect
public class RoleAspect {

	@Around("@execution(* de.tudresden.aspect.RoleAspect.activation(...))")
	public void roleActivation(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("hijacked role method: " + joinpoint.getSignature().getName());
	}
}
