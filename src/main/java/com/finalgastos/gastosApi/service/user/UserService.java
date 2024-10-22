package com.finalgastos.gastosApi.service.user;

import com.finalgastos.gastosApi.model.User;



public interface UserService {
    User registrarUsuario(User user);
    String login(String username, String password);
}
