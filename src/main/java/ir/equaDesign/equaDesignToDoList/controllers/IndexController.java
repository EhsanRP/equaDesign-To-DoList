package ir.equaDesign.equaDesignToDoList.controllers;

import ir.equaDesign.equaDesignToDoList.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @
}
