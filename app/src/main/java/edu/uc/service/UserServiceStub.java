package edu.uc.service;

import edu.uc.dto.User;

/**
 * Created by ucint on 9/6/2016.
 */
public class UserServiceStub implements IUserService {
    @Override
    public boolean logon(String username, String password) throws Exception {
        return false;
    }

    @Override
    public void save(User user) throws Exception {

    }

    @Override
    public User getUser(String username) throws Exception {
        return null;
    }
}
