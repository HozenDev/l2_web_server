package com.uca.core;

import com.uca.dao.GommetteDAO;
import com.uca.entity.GommetteEntity;

import java.util.ArrayList;

public class GommetteCore {

    public static ArrayList<GommetteEntity> getAllGommettes() {
        return new GommetteDAO().getAllGommettes();
    }

    public static GommetteEntity create(GommetteEntity obj) {
	return new GommetteDAO().create(obj);
    }

    public static void delete(GommetteEntity obj) {
	new GommetteDAO().delete(obj);
    }

    public static GommetteEntity getGommetteById(int id) {
	return new GommetteDAO().getGommetteById(id);
    }

    public static GommetteEntity modify(GommetteEntity obj) {
	return new GommetteDAO().modify(obj);
    }

}
