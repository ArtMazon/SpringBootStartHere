package org.springabstractions.proxies;

import org.springabstractions.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{


    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending comment: "+ comment.getText());

    }
}
