package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.BaseEntity;
import com.bulat.jobboard.model.State;
import org.springframework.ui.ModelMap;

import java.util.Date;

public class Attributes {

    public static void addSuccessAttributes(ModelMap map, String message){
        map.addAttribute("title", "Good job!");
        map.addAttribute("message", message);
        map.addAttribute("category", "success");
    }

    public static void addErrorAttributes(ModelMap map, String message){
        map.addAttribute("title", "Oops!");
        map.addAttribute("message", message);
        map.addAttribute("category", "error");
    }

    public static void addAttributes(BaseEntity baseEntity){
        baseEntity.setStatus(State.ACTIVE);
        baseEntity.setCreated(new Date());
        baseEntity.setUpdated(new Date());
    }
}
