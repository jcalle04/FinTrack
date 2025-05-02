package org.example.fintrack.Service;

import org.example.fintrack.Domain.User;
import org.example.fintrack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String email, String password) {

        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public boolean authenticateRegister(String email, String password, String repeat) {

        return userRepository.findByEmail(email) == null;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(email.substring(0, email.indexOf("@")));
        user.setUsername("user" + (userRepository.findAll().size()+1));

        userRepository.save(user);
    }
}
