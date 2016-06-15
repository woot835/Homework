

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecTimeAspect {
    @Around("execution(* *(..)) && @annotation(LogExecTime)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = MethodSignature.class.cast(point.getSignature()).getMethod().getName();
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - start;
        System.out.println("took " + time + "ms to run " + methodName);
        return result;
    }
}