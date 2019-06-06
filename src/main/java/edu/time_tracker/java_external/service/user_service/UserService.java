package edu.time_tracker.java_external.service.user_service;

import edu.time_tracker.java_external.domain.entity.User;
import edu.time_tracker.java_external.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }



    public Optional<User> getById(Long userId) {
        return userRepository.findById(userId);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
