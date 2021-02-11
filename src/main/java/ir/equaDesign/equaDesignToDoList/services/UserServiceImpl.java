package ir.equaDesign.equaDesignToDoList.services;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import ir.equaDesign.equaDesignToDoList.domain.User;
import ir.equaDesign.equaDesignToDoList.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByName(User user) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public ToDo markAsDone(Integer id, Integer userId) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(id))
                .findFirst()
                .get()
                .setDone(true);
        userRepository.save(user);

        return user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public ToDo updateTask(Integer userId, Integer taskId, String description) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(taskId))
                .findFirst()
                .get()
                .setDescription(description);

        userRepository.save(user);

        return user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(taskId))
                .findFirst()
                .get();
    }

    @Override
    public ToDo markAsUnDone(Integer TaskId, Integer userId) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(TaskId))
                .findFirst()
                .get()
                .setDone(false);
        userRepository.save(user);

        return user.getTasks().stream()
                .filter(toDo -> toDo.getId().equals(TaskId))
                .findFirst()
                .get();
    }

    @Override
    public void deleteTask(Integer taskId, Integer userId) {
        var user = userRepository.findById(userId).get();

        user.getTasks().remove(
                user.getTasks()
                        .stream()
                        .filter(toDo -> toDo.getId().equals(taskId))
                        .findFirst()
                        .get()
        );

    }

    @Override
    public ToDo createTask(Integer userId, ToDo toDo) {
        var user = userRepository.findById(userId).get();
        var returnValue = user.addToDo(toDo);

        userRepository.save(user);

        return returnValue;
    }

    @Override
    public Set<ToDo> allTasks(Integer userId) {

        var list = userRepository.findById(userId).get().getTasks();

        return list;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
