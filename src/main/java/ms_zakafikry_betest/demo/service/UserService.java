package ms_zakafikry_betest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ms_zakafikry_betest.demo.entity.User;
import ms_zakafikry_betest.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = "users", key = "#accountNumber")
    public Optional<User> getUserByAccountNumber(String accountNumber) {
        return userRepository.findByAccountNumber(accountNumber);
    }

    @Cacheable(value = "users", key = "#identityNumber")
    public Optional<User> getUserByIdentityNumber(String identityNumber) {
        return userRepository.findByIdentityNumber(identityNumber);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
}