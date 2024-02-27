package org.springabstractions.proxies;

import org.springabstractions.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {

        System.out.println("Sending push comment notification for comment: "+comment.getText());


    }
}
