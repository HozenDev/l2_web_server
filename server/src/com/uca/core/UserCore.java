package com.uca.core;

import com.uca.dao.UserDAO;
import com.uca.entity.UserEntity;

import java.util.ArrayList;

public class UserCore {

    public static ArrayList<UserEntity> getAllUsers() {
        return new UserDAO().getAllUsers();
    }

    public static ArrayList<UserEntity> getUserById(int id) {
        return new UserDAO().getUserById(id);
    }

    public static UserEntity create(UserEntity obj) {
	return new UserDAO().create(obj);
    }

    public static void delete(UserEntity obj) {
	new UserDAO().delete(obj);
    }
}
