package com.uca.core;

import com.uca.dao.GommetteDAO;
import com.uca.entity.GommetteEntity;

import java.util.ArrayList;

public class GommetteCore {

    public static ArrayList<GommetteEntity> getAllUsers() {
        return new GommetteDAO().getAllUsers();
    }

}
