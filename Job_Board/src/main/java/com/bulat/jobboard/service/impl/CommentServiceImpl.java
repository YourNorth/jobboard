package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Comment;
import com.bulat.jobboard.model.State;
import com.bulat.jobboard.repository.CommentRepository;
import com.bulat.jobboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findByStatus(State state) {
        return commentRepository.findByStatus(state);
    }
}
