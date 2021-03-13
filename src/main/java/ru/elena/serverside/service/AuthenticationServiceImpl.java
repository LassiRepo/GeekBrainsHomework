package ru.elena.serverside.service;

import ru.elena.serverside.interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<User> userList;

    public AuthenticationServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("A","A", "UserA"));
         userList.add(new User("B","B", "UserB"));
          userList.add(new User("C","C", "UserC"));
    }

    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");

    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        return userList.stream()
                .map(a ->{
            if (a.login.equals(login) && a.password.equals(password)){
                   return a.nick;
            }
            return "";
        }).collect(Collectors.joining());
    }

    private class  User{
        private String login;
        private String password;
        private String nick;

        public User(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }



    }
}
