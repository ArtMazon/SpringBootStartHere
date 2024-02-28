package org.springAOP;

import org.apache.commons.logging.Log;
import org.springAOP.config.ConfigClass;
import org.springAOP.models.Comment;
import org.springAOP.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ConfigClass.class);
        var service = context.getBean(CommentService.class);

        var comment = new Comment();
        comment.setAuthor("Solomon");
        comment.setText("YHVH");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);


    }
}