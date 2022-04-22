package com.uca.gui;

import com.uca.entity.ProfesseurEntity;
import com.uca.core.ProfesseurCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ProfesseurGUI {

    public static String getAllUsers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("professeurs", ProfesseurCore.getAllUsers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs/professeurs.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(ProfesseurEntity obj) throws IOException, TemplateException {
        return String.format("<p> %s a été créé. </p>", ProfesseurCore.create(obj).toString());
    }

    public static String delete(ProfesseurEntity obj) throws IOException, TemplateException {
	try {
	    ProfesseurCore.delete(obj);
	}
	catch (Exception e) {
	    throw new RuntimeException("impossible de supprimer l'élève.");
	}
        return "<p> Le professeur a été supprimé. </p>";
    }
}
