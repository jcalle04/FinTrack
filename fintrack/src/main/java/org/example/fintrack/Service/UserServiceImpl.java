package org.example.fintrack.Service;

import org.example.fintrack.Domain.User;
import org.example.fintrack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String email, String password) {

        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public boolean authenticateRegister(String email, String password, String repeat) {

        if(userRepository.findByEmail(email) != null) {
            return false;
        }
        else if(!password.equals(repeat)) {
            return false;
        }

        return true;
    }

    @Override
    public void createUser(String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(email.substring(0, email.indexOf("@")));
        user.setUsername("user" + (userRepository.findAll().size()+1));

        userRepository.save(user);
    }
}
