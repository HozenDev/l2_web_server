package com.uca.core;

import com.uca.dao.ProfesseurDAO;
import com.uca.entity.ProfesseurEntity;

import java.util.ArrayList;

public class ProfesseurCore {

    public static ArrayList<ProfesseurEntity> getAllProfesseurs() {
        return new ProfesseurDAO().getAllProfesseurs();
    }

    public static ProfesseurEntity getProfesseurById(int id) {
        return new ProfesseurDAO().getProfesseurById(id);
    }
    
    public static ProfesseurEntity create(ProfesseurEntity obj) {
	return new ProfesseurDAO().create(obj);
    }

    public static void delete(ProfesseurEntity obj) {
	new ProfesseurDAO().delete(obj);
    }    

}
