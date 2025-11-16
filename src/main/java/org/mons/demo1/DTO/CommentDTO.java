package org.mons.demo1.DTO;

import org.mons.demo1.models.Comment;

public class CommentDTO {
    private long id;
    private String commentText;

    public CommentDTO(Comment comment){
        this.id= comment.getId();
        this.commentText=comment.getComment();

    }

    public CommentDTO(long id, String commentText){
        this.commentText=commentText;
        this.id =id;
    }

    public String getCommentText(){
        return commentText;
    }


}
