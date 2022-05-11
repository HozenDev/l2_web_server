package com.uca.gui;

import com.uca.entity.GommetteAttribueeEntity;
import com.uca.core.GommetteAttribueeCore;
import com.uca.core.GommetteCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GommetteAttribueeGUI {

    public static String create(int id_student, String log) throws IOException, TemplateException {
	Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("log", log);
	input.put("gommettes", GommetteCore.getAllGommettes());
	input.put("id_student", id_student);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/attribuees/create.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
