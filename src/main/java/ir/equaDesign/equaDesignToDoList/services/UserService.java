package ir.equaDesign.equaDesignToDoList.services;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import ir.equaDesign.equaDesignToDoList.domain.User;

public interface UserService {

    User save(User user);

    User findByName(User user);

    User findById(Integer id);

    ToDo updateTask(Integer userId, Integer taskId, String description);

    ToDo markAsDone(Integer TaskId, Integer userId);

    ToDo markAsUnDone(Integer TaskId, Integer userId);

    void delete(Integer id);

    void deleteTask(Integer taskId, Integer userId);
}
