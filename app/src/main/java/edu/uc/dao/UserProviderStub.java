package edu.uc.dao;

import java.util.HashMap;

import edu.uc.dto.User;

/**
 * Created by ucint on 9/6/2016.
 */
public class UserProviderStub implements IUserDAO {
    @Override
    public void save(User user) throws Exception {

    }

    @Override
    public User fetch(String username) throws Exception {
        return null;
    }

    @Override
    public HashMap<String, User> fetchAll() {
        return null;
    }
}
