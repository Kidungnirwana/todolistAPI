package com.core.todolist.service;

import com.core.todolist.model.User;
import com.core.todolist.repository.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Getter
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll(){

        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User>user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new IllegalStateException("User not found....");
        }
        return user.get();
    }

    public User create(User user){

        return userRepository.save(user);
    }

    public User update(Long id, User user){
        Optional<User> userOps = userRepository.findById(id);
        User updateUser = new User();
        if (userOps.isPresent()){

            updateUser = userOps.get();
            updateUser.setUserName(user.getUserName());
            updateUser.setDescription(user.getDescription());
            updateUser.setEmail(user.getEmail());
            updateUser = userRepository.save(updateUser);
        }
        return updateUser;
    }
    public void deleteById (Long id) {

        Optional<User>user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new IllegalStateException("User not exist....");
        }
        userRepository.deleteById(id);
    }

    public void deleteAll () {

        userRepository.deleteAll();
    }
}
