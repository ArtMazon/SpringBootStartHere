package org.springabstractions.repositories;

import org.springabstractions.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
