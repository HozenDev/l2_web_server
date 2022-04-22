package com.uca.core;

import com.uca.dao.EleveDAO;
import com.uca.entity.EleveEntity;

import java.util.ArrayList;

public class EleveCore {

    public static ArrayList<EleveEntity> getAllUsers() {
        return new EleveDAO().getAllUsers();
    }

    public static EleveEntity create(EleveEntity obj) {
	return new EleveDAO().create(obj);
    }

    public static void delete(EleveEntity obj) {
	new EleveDAO().delete(obj);
    }

    public static ArrayList<EleveEntity> getUserById(int id) {
        return new EleveDAO().getUserById(id);
    }
}
