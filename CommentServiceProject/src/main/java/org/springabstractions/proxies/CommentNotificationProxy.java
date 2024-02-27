package org.springabstractions.proxies;

import org.springabstractions.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
