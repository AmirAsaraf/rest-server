package com.example.services;

import com.example.exceptions.UserNotExistsException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by asaraf on 28/12/2016.
 */
public class UsersService {

    final           Logger          logger          = LogManager.getLogger(UsersService.class.getName());

    private static UsersService usersService =      null;

    private UsersService() {}

    public static UsersService getInstance() {
        if (usersService == null) {
            usersService = new UsersService();
        }
        return usersService;
    }

    public void findUser(String userId) throws UserNotExistsException {
        //some logic
    }
}
