/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.loggerService;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.loggerEntity.User;
import mx.edu.utez.springboot.sendtomx.loggerModel.UserModel;

/**
 *
 * @author Daniel
 */
public interface UserService {
    
        public abstract UserModel addUser(UserModel userModel);
	public abstract List<UserModel> listAllUsers();
	public abstract User findUserById(int id);
	public abstract UserModel findUserByIdModel(int id);
	public abstract void removeUser(int id);
    
}
