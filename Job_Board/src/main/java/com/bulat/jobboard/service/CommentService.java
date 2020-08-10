package com.bulat.jobboard.service;

import com.bulat.jobboard.model.Comment;
import com.bulat.jobboard.model.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> findByStatus(State state);
}
