package ac.challenge.ortogoloso.configuration;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configurazione per gestire il logging tramite AOP su tutti i service e controller
 */
@Configuration
public class LoggingConfiguration {

    @Bean
    @Autowired
    public Advisor controllerLogger(LoggingInterceptor interceptor){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* ac.challenge.ortogoloso.controller.*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }

    @Bean
    @Autowired
    public Advisor serviceLogger(LoggingInterceptor interceptor){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* ac.challenge.ortogoloso.service.*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }

}
