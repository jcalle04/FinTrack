package org.example.fintrack.Service;

import org.example.fintrack.Domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public boolean authenticate(String email, String password);
    public boolean authenticateRegister(String email, String password, String repeat);
    public void createUser(String email, String password);

    public User findByUsername(String username);
    public  User findByEmail(String email);
}
