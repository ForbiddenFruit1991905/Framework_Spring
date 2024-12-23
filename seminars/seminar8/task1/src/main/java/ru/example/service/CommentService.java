package ru.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.example.aspects.ToLog;
import ru.example.model.Comment;

import java.util.logging.Logger;

@Service
@Component
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        System.out.println("Опубликовать комментарий: " + comment.getText());
        return "SUCCESS";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    //для примера
//    public void method1(){
//        System.out.println("Вызван метод1");
//    }
}
