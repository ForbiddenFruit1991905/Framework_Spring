package ru.example.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import ru.example.model.Comment;
import ru.example.service.CommentService;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* ru.example.service.*.*(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
          // Вар.1
//        System.out.println("Сообщение до вызова декорируемого метода");
////        logger.info("Сообщение до вызова декорируемого метода");
//        Object returnedByMethod = joinPoint.proceed();
////        logger.info("Сообщение после вызова декорируемого метода");
//        System.out.println("Сообщение после вызова декорируемого метода");
//        return returnedByMethod;
        // Вар.2
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        System.out.println("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");

        System.out.println("Сообщение до вызова декорируемого метода");

        Comment comment = new Comment();
        comment.setAuthor("Jenny");
        comment.setText("Some other text!");
        Object [] newArguments = {comment};

        Object returnedByMethod = joinPoint.proceed(newArguments);
        System.out.println("Сообщение после вызова декорируемого метода");
        return returnedByMethod;
    }

    @Around("execution(* ru.example.service.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Метод: " + joinPoint.getSignature().getName() + " - " + elapsedTime + " милсек");
         return result;
    }

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue){
        logger.info("Method executed and returned " + returnedValue);
    }
}
