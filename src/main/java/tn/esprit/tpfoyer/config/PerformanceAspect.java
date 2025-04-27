package tn.esprit.tpfoyer.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.esprit.tpfoyer.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();  // Exécute la méthode

        long elapsedTime = System.currentTimeMillis() - start;
        String methodName = pjp.getSignature().getName();
        log.info("⏱️ Temps d'exécution de la méthode " + methodName + ": " + elapsedTime + " ms");

        return obj;
    }

}