package ir.equaDesign.equaDesignToDoList.services;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import ir.equaDesign.equaDesignToDoList.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User save(User user);

    User findByName(User user);

    User findById(Integer id);

    Set<ToDo> allTasks(Integer userId);

    List<User> findAll();

    ToDo createTask(Integer userId, ToDo toDo);

    ToDo updateTask(Integer userId, Integer taskId, String description);

    ToDo markAsDone(Integer TaskId, Integer userId);

    ToDo markAsUnDone(Integer TaskId, Integer userId);

    void deleteUser(Integer id);

    void deleteTask(Integer taskId, Integer userId);
}
