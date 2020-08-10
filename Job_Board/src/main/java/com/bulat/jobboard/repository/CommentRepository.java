package com.bulat.jobboard.repository;

import com.bulat.jobboard.model.Comment;
import com.bulat.jobboard.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByStatus(State state);
}
