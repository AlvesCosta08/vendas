package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.UsuarioAlreadyExistsException;
import com.vendas.vendas.exceptions.UsuarioNotFoundException;
import com.vendas.vendas.models.UserInfo;
import com.vendas.vendas.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo createUser(UserInfo userInfo) {
        if (userInfoRepository.existsByUsername(userInfo.getUsername())) {
            throw new UsuarioAlreadyExistsException("User already exists with username: " + userInfo.getUsername());
        }
        return userInfoRepository.save(userInfo);
    }

    public UserInfo getUserById(long id) {
        return userInfoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("User not found with id: " + id));
    }

    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo updateUser(long id, UserInfo userInfo) {
        UserInfo existingUser = getUserById(id);
        existingUser.setUsername(userInfo.getUsername());
        existingUser.setPassword(userInfo.getPassword());
        existingUser.setRoles(userInfo.getRoles());
        return userInfoRepository.save(existingUser);
    }

    public void deleteUser(long id) {
        UserInfo existingUser = getUserById(id);
        userInfoRepository.delete(existingUser);
    }
}
