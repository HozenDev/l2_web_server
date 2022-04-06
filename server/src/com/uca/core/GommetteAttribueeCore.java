package com.uca.core;

import com.uca.dao.GommetteAttribueeDAO;
import com.uca.entity.GommetteAttribueeEntity;

import java.util.ArrayList;

public class GommetteAttribueeCore {

    public static ArrayList<GommetteAttribueeEntity> getAllUsers() {
        return new GommetteAttribueeDAO().getAllUsers();
    }

}
