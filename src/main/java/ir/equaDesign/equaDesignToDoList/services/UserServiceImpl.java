package ir.equaDesign.equaDesignToDoList.services;

import ir.equaDesign.equaDesignToDoList.domain.Task;
import ir.equaDesign.equaDesignToDoList.domain.User;
import ir.equaDesign.equaDesignToDoList.repositories.TaskRepository;
import ir.equaDesign.equaDesignToDoList.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;


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
    public Task markAsDone(Integer id, Integer userId) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .get()
                .setDone(true);
        userRepository.save(user);

        return user.getTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Integer userId, Integer taskId, String description) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .get()
                .setDescription(description);

        userRepository.save(user);

        return user.getTasks().stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .get();
    }

    @Override
    public Task markAsUnDone(Integer TaskId, Integer userId) {
        var user = userRepository.findById(userId).get();
        user.getTasks().stream()
                .filter(task -> task.getId().equals(TaskId))
                .findFirst()
                .get()
                .setDone(false);
        userRepository.save(user);

        return user.getTasks().stream()
                .filter(task -> task.getId().equals(TaskId))
                .findFirst()
                .get();
    }

    @Override
    public void deleteTask(Integer taskId, Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()){
            User user = userOptional.get();

            Optional<Task> taskOptional = user.getTasks().stream()
                    .filter(task -> task.getId().equals(taskId))
                    .findFirst();

            if (taskOptional.isPresent()){
                Task taskToDelete = taskOptional.get();
                taskToDelete.setUser(null);
                user.getTasks().remove(taskToDelete);
                taskRepository.deleteById(taskId);
                userRepository.save(user);
            } else
                log.debug("Ingredient ID " + taskId + " Not Found");
        } else
            log.debug("Recipe Id " + userId + " Not Found");
    }

    @Override
    public Task createTask(Integer userId, Task task) {
        var user = userRepository.findById(userId).get();
        var returnValue = user.addTask(task);

        userRepository.save(user);

        return returnValue;
    }

    @Override
    public Set<Task> allTasks(Integer userId) {

        var list = userRepository.findById(userId).get().getTasks();

        return list;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
