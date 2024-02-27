package org.springabstractions.main;

import org.springabstractions.config.ConfigClass;
import org.springabstractions.model.Comment;
import org.springabstractions.proxies.EmailCommentNotificationProxy;
import org.springabstractions.repositories.DBCommentRepository;
import org.springabstractions.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ConfigClass.class);


        var commentService = context.getBean(CommentService.class);

      /*  var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository,commentNotificationProxy);
        */var comment = new Comment();

        comment.setAuthor("Solomon");
        comment.setText("Hello world!");

        commentService.publishComment(comment);






    }
}