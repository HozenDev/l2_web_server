package com.uca.gui;

import com.uca.entity.GommetteAttribueeEntity;
import com.uca.core.GommetteAttribueeCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GommetteAttribueeGUI {

    public static String getAllUsers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettesAttribuees", GommetteAttribueeCore.getAllUsers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettesAttribuees/gommettesAttribuees.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(GommetteAttribueeEntity obj) throws IOException, TemplateException {
        return String.format("<p> %s a été créé. </p>", GommetteAttribueeCore.create(obj).toString());
    }

    public static String delete(GommetteAttribueeEntity obj) throws IOException, TemplateException {
	try {
	    GommetteAttribueeCore.delete(obj);
	}
	catch (Exception e) {
	    throw new RuntimeException("impossible de supprimer l'élève.");
	}
        return "<p> La gommette n'est plus attribuée. </p>";
    }
}
