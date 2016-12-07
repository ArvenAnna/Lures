package com.anna.lure.converter;

import com.anna.lure.dto.CommentDto;
import com.anna.lure.persist.Comment;
import com.anna.lure.persist.Lure;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CommentConverter {

    public static Comment toCommentEntity(CommentDto commentDto, Lure lure){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setComment(commentDto.getComment());
        comment.setLure(lure);
        comment.setAuthor(commentDto.getAuthor());
        try {
            comment.setDate(LocalDateTime.parse(commentDto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return comment;
    }

    public static CommentDto toCommentDto(Comment entity) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(entity.getId());
        commentDto.setComment(entity.getComment());
        commentDto.setAuthor(entity.getAuthor());
        commentDto.setDate(entity.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return commentDto;
    }
}
