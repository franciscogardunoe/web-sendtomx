/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.loggerModel;

/**
 *
 * @author Daniel
 */
public class UserModel {
    
    private String username;
    private int enabled;
    private String password;

    public UserModel() {
        super();
    }

    public UserModel(String username, int enabled, String password) {
        super();
        this.username = username;
        this.enabled = enabled;
        this.password = password;
    }   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
