package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Feedback;
import com.bulat.jobboard.model.User;
import com.bulat.jobboard.security.details.UserDetailsImpl;
import com.bulat.jobboard.service.FeedbackService;
import com.bulat.jobboard.service.UserService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contact")
public class FeedbackController {

    private final UserService userService;
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(UserService userService, FeedbackService feedbackService) {
        this.userService = userService;
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public String getContact(){
        return "contact";
    }

    @PostMapping
    public String sendFeedback(Feedback f, Authentication authentication){
        User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        Optional<User> userOptional = userService.findByEmail(u.getEmail());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            Attributes.addAttributes(f);
            Feedback feedback = feedbackService.save(f);
            if (user.getFeedbacks().isEmpty()){
                user.setFeedbacks(Collections.singletonList(feedback));
            }else{
                List<Feedback> feedbacks = user.getFeedbacks();
                feedbacks.add(feedback);
                user.setFeedbacks(feedbacks);
            }
            userService.save(user);
        }
        System.out.println(f);
        return "contact";
    }
}
