/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.loggerConverter;

import mx.edu.utez.springboot.sendtomx.loggerEntity.User;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Daniel
 */
@Component
public class UserConverter {

    public User convertUserModelToUser(UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setEnabled(userModel.getEnabled());
        user.setPassword(userModel.getPassword());
        return user;
    }

    public UserModel convertUserToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setUsername(user.getUsername());
        userModel.setEnabled(user.getEnabled());
        userModel.setPassword(user.getPassword());
        return userModel;
    }

}
