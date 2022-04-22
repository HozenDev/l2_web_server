package com.uca.gui;

import com.uca.core.EleveCore;
import com.uca.entity.EleveEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EleveGUI {

    public static String getAllUsers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleves", EleveCore.getAllUsers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getUserById(int id) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleves", EleveCore.getUserById(id));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(EleveEntity obj) throws IOException, TemplateException {
        return String.format("<p> %s a été créé. </p>", EleveCore.create(obj).toString());
    }

    public static String delete(EleveEntity obj) throws IOException, TemplateException {
	try {
	    EleveCore.delete(obj);
	}
	catch (Exception e) {
	    throw new RuntimeException("impossible de supprimer l'élève.");
	}
        return "<p> L'élève a été supprimé. </p>";
    }
}
