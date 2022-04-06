package com.uca.core;

import com.uca.dao.EleveDAO;
import com.uca.entity.EleveEntity;

import java.util.ArrayList;

public class EleveCore {

    public static ArrayList<EleveEntity> getAllUsers() {
        return new EleveDOA().getAllUsers();
    }

}
