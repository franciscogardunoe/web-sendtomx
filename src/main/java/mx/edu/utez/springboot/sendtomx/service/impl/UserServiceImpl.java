/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.loggerConverter.UserConverter;
import mx.edu.utez.springboot.sendtomx.loggerEntity.User;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserModel;
import mx.edu.utez.springboot.sendtomx.loggerRepository.UserRepository;
import org.springframework.stereotype.Service;
import mx.edu.utez.springboot.sendtomx.loggerService.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Daniel
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserModel addUser(UserModel userModel) {
        User user = userRepository.save(userConverter.convertUserModelToUser(userModel));
        return userConverter.convertUserToUserModel(user);
    }

    @Override
    public List<UserModel> listAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserModel findUserByIdModel(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
