package com.uca.core;

import com.uca.dao.GommetteAttribueeDAO;
import com.uca.entity.GommetteAttribueeEntity;

import java.util.ArrayList;

public class GommetteAttribueeCore {

    public static GommetteAttribueeEntity create(GommetteAttribueeEntity obj) {
	return new GommetteAttribueeDAO().create(obj);
    }

    public static void delete(GommetteAttribueeEntity obj) {
	new GommetteAttribueeDAO().delete(obj);
    }

}
