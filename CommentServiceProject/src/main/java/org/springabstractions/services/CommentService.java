package org.springabstractions.services;

import org.springabstractions.model.Comment;
import org.springabstractions.proxies.CommentNotificationProxy;
import org.springabstractions.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(
            CommentRepository commentRepository,
           @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy
    ){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;

    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }


}
