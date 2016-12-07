package com.anna.lure.service.impl;

import com.anna.lure.converter.CommentConverter;
import com.anna.lure.dto.CommentDto;
import com.anna.lure.persist.Comment;
import com.anna.lure.persist.Lure;
import com.anna.lure.repository.CommentRepository;
import com.anna.lure.repository.LureRepository;
import com.anna.lure.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    LureRepository lureRepository;

    @Override
    public Integer saveComment(CommentDto comment, Integer itemId) {
        Assert.notNull(itemId, "lure id must not be null");
        Assert.notNull(comment, "comment must not be null");
        Assert.isNull(comment.getId(), "comment id must be null");
        Assert.notNull(comment.getDate(), "comment date must not be null");
        Lure lure = lureRepository.findOne(itemId);
        Comment commentEntity = CommentConverter.toCommentEntity(comment, lure);
        lure.getComments().add(commentEntity);
        commentRepository.saveAndFlush(commentEntity);
        return commentEntity.getId();
    }

    @Override
    public List<CommentDto> fetchComments(Integer itemId) {
        return commentRepository.findByLure(lureRepository.findOne(itemId)).stream()
                .map(comment -> CommentConverter.toCommentDto(comment))
                .collect(Collectors.toList());
    }
}
