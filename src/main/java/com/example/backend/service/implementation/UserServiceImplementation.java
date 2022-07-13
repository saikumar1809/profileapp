package com.example.backend.service.implementation;

import com.example.backend.model.User;
import com.example.backend.repo.UserRepo;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
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

        return userRepo.findById(id).get();
    }

    @Override
    public User update(User user) {
        log.info("Updating user:{}",user.getFirst_name());
        return userRepo.save(user);
    }

    @Override
    public Boolean delete(Long id) {

        log.info("Deleting user:{}",id);
        userRepo.deleteById(id);
        return Boolean.TRUE;

    }

    private String setProfileImageUrl() {
        //will be implemnted later after storing pictures in folder
        return null;
    }
}
