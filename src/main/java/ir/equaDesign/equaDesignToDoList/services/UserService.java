package ir.equaDesign.equaDesignToDoList.services;

import ir.equaDesign.equaDesignToDoList.domain.Task;
import ir.equaDesign.equaDesignToDoList.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User save(User user);

    User findByName(User user);

    User findById(Integer id);

    Set<Task> allTasks(Integer userId);

    List<User> findAll();

    Task createTask(Integer userId, Task task);

    Task updateTask(Integer userId, Integer taskId, String description);

    Task markAsDone(Integer TaskId, Integer userId);

    Task markAsUnDone(Integer TaskId, Integer userId);

    void deleteUser(Integer id);

    void deleteTask(Integer taskId, Integer userId);
}
