package com.uca.gui;

import com.uca.entity.GommetteEntity;
import com.uca.core.GommetteCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GommetteGUI {

    public static String getAllUsers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettes", GommetteCore.getAllUsers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/gommettes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(GommetteEntity obj) throws IOException, TemplateException {
        return String.format("<p> %s a été créé. </p>", GommetteCore.create(obj).toString());
    }

    public static String delete(GommetteEntity obj) throws IOException, TemplateException {
	try {
	    GommetteCore.delete(obj);
	}
	catch (Exception e) {
	    throw new RuntimeException("impossible de supprimer l'élève.");
	}
        return "<p> La gommette a été supprimé. </p>";
    }    
}
