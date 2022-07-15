package com.example.backend.user.service.implementation;

import com.example.backend.user.model.User;
import com.example.backend.user.repo.UserRepo;
import com.example.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImplementation  implements UserService {
    private final UserRepo userRepo;
    @Override
    public User create(User user) {
        log.info("saving new user:{}",user.getFirst_name());
        user.setProfile_url(setProfileImageUrl());
        return userRepo.save(user);
    }



    @Override
    public Collection<User> list(int limit) {
        log.info("Fetching all users");
        return userRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public User get(Long id) {
        log.info("Fetching user by id:{}",id);
    System.out.println(id);
        return userRepo.findById(id).get();
    }
    public User getByEmail(String email) {
        log.info("Fetching user by id:{}",email);

        return userRepo.findByEmail(email);
    }
    @Override
    public User update(User user) {
       // log.info("Updating user:{}",user.getFirst_name());
        return userRepo.save(user);
    }

    @Override
    public Boolean verifyLogin(String email, String password) {
        User user=userRepo.findByEmail(email);
        return user.getPassword().equals(password);
    }


    @Override
    public Boolean delete(Long id) {

        log.info("Deleting user:{}",id);
        userRepo.deleteById(id);
        return TRUE;

    }

    private String setProfileImageUrl() {
        //will be implemnted later after storing pictures in folder
        return null;
    }
}
