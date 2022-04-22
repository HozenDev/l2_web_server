package com.uca.core;

import com.uca.dao.ProfesseurDAO;
import com.uca.entity.ProfesseurEntity;

import java.util.ArrayList;

public class ProfesseurCore {

    public static ArrayList<ProfesseurEntity> getAllUsers() {
        return new ProfesseurDAO().getAllUsers();
    }

    public static ProfesseurEntity create(ProfesseurEntity obj) {
	return new ProfesseurDAO().create(obj);
    }

    public static void delete(ProfesseurEntity obj) {
	new ProfesseurDAO().delete(obj);
    }    

}
