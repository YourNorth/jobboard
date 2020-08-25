package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Subscriber;
import com.bulat.jobboard.service.SubscriberService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Controller for subscribing to site news
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
@RequestMapping("/subscribe")
public class SubscribersController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscribersController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    /**
     * Method for subscribing to site news
     * @param redirectAttributes Report check
     * @param email Mail that subscribe to site news
     */
    @GetMapping
    public String addSubscribe(RedirectAttributes redirectAttributes, @RequestParam(name = "email") String email){
        Optional<Subscriber> subscriberOptional = subscriberService.findByEmail(email);
        if (subscriberOptional.isPresent()){
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "This mail is already a subscriber!");
        }else{
            Subscriber subscriber = new Subscriber();
            Attributes.addAttributesForEntity(subscriber);
            subscriber.setEmail(email);
            subscriberService.save(subscriber);
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success!");
        }
        return "redirect:/index";
    }
}
