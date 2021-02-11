package ir.equaDesign.equaDesignToDoList.controllers;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import ir.equaDesign.equaDesignToDoList.domain.User;
import ir.equaDesign.equaDesignToDoList.repositories.TaskRepository;
import ir.equaDesign.equaDesignToDoList.services.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;
    private final TaskRepository taskRepository;

    private static final String VIEWS_INDEX = "index";

    @GetMapping("")
    public ModelAndView index() {
        var mav = new ModelAndView(VIEWS_INDEX);
//
//        var users = userService.findAll();
//
//        Set<ToDo> tasks = new HashSet<>();
//        for (User user : users) {
//            tasks.addAll(user.getTasks());
//        }

        mav.addObject("tasks", taskRepository.findAll());
        return mav;
    }

    @GetMapping("/user/{userId}/tasks")
    public ModelAndView index(@PathVariable Integer userId) {

        var mav = new ModelAndView(VIEWS_INDEX);
        mav.addObject("tasks", userService.allTasks(userId));

        return mav;
    }

}
