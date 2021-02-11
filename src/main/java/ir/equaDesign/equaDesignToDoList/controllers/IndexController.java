package ir.equaDesign.equaDesignToDoList.controllers;

import ir.equaDesign.equaDesignToDoList.repositories.TaskRepository;
import ir.equaDesign.equaDesignToDoList.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;
    private final TaskRepository taskRepository;

    private static final String VIEWS_INDEX = "index";

    @GetMapping("")
    public ModelAndView index() {
        var mav = new ModelAndView(VIEWS_INDEX);

        mav.addObject("tasks", taskRepository.findAll());
        return mav;
    }

//    @GetMapping("/user/{userId}/tasks")
//    public ModelAndView index(@PathVariable Integer userId) {
//
//        var mav = new ModelAndView(VIEWS_INDEX);
//        mav.addObject("tasks", userService.allTasks(userId));
//
//        return mav;
//    }

    @GetMapping("/tasks/{userId}/delete/{taskId}")
    public String deleteTask(@PathVariable Integer taskId,@PathVariable Integer userId) {
        userService.deleteTask(taskId,userId);

        return "redirect:/";
    }

}
