package com.anna.lure.service;

import com.anna.lure.dto.CommentDto;

import java.util.List;

public interface ICommentService {
    Integer saveComment(CommentDto comment, Integer itemId);

    List<CommentDto> fetchComments(Integer itemId);
}
