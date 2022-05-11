package com.uca.core;

import com.uca.dao.EleveDAO;
import com.uca.entity.EleveEntity;

import java.util.ArrayList;

public class EleveCore {

    public static ArrayList<EleveEntity> getAllEleves() {
        return new EleveDAO().getAllEleves();
    }

    public static EleveEntity create(EleveEntity obj) {
	return new EleveDAO().create(obj);
    }

    public static void delete(EleveEntity obj) {
	new EleveDAO().delete(obj);
    }

    public static EleveEntity getEleveById(int id) {
        return new EleveDAO().getEleveById(id);
    }

    public static EleveEntity modify(EleveEntity obj) {
	return new EleveDAO().modify(obj);
    }
}
