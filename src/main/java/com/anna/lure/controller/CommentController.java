package com.anna.lure.controller;

import com.anna.lure.dto.CommentDto;
import com.anna.lure.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    ICommentService commentService;

    @RequestMapping(value = {"/comment.req"}, method = RequestMethod.POST,
            headers = "Accept=application/json")
    @ResponseBody
    protected Integer saveComment(@RequestBody CommentDto comment, @RequestParam("itemId") Integer itemId) {
        return commentService.saveComment(comment, itemId);
    }

    @RequestMapping(value = {"/comments.req"}, method = RequestMethod.GET,
            headers = "Accept=application/json")
    @ResponseBody
    public List<CommentDto> fetchComments(@RequestParam("itemId") Integer itemId) {
        return commentService.fetchComments(itemId);
    }
}
