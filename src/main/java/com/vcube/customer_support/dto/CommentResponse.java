package com.vcube.customer_support.dto;

public class CommentResponse {

    private Long commentId;
    private Long ticketId;
    private Integer userId;
    private String comment;
    private String commentType;
    private Integer rating;

    public CommentResponse(Long commentId, Long ticketId,
            Integer userId, String comment,
            String commentType, Integer rating) {

        this.commentId = commentId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.comment = comment;
        this.commentType = commentType;
        this.rating = rating;
    }

    public Long getCommentId() {
        return commentId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentType() {
        return commentType;
    }

    public Integer getRating() {
        return rating;
    }
}