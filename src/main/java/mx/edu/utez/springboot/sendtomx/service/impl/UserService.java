package mx.edu.utez.springboot.sendtomx.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.edu.utez.springboot.sendtomx.loggerEntity.UserRole;
import mx.edu.utez.springboot.sendtomx.loggerRepository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        mx.edu.utez.springboot.sendtomx.loggerEntity.User user = userRepository.findByUsername(username);
        if (user != null) {
            return buildUser(user, buildAuthorities(user.getUserRole()));
        } else {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
    }

    private User buildUser(mx.edu.utez.springboot.sendtomx.loggerEntity.User user, List<GrantedAuthority> authorities) {
        boolean enabled = false;

        if (user.getEnabled() == 1) {
            enabled = true;
        }

        return new User(user.getUsername(), user.getPassword(), enabled, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);

    }
}
