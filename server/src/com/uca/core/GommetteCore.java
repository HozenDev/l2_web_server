package com.uca.core;

import com.uca.dao.GommetteDAO;
import com.uca.entity.GommetteEntity;

import java.util.ArrayList;

public class GommetteCore {

    public static ArrayList<GommetteEntity> getAllUsers() {
        return new GommetteDAO().getAllUsers();
    }

    public static GommetteEntity create(GommetteEntity obj) {
	return new GommetteDAO().create(obj);
    }

    public static void delete(GommetteEntity obj) {
	new GommetteDAO().delete(obj);
    }    

}
