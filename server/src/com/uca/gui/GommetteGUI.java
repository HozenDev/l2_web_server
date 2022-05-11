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

    public static String getAllGommettes(boolean userLog, int userId) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettes", GommetteCore.getAllGommettes());
	input.put("userLog", userLog);
	input.put("userId", userId);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/gommettes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(String log) throws IOException, TemplateException {
	Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("log", log);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/create.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String modify(int id, boolean userLog, String log) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommette", GommetteCore.getGommetteById(id));
	input.put("userLog", userLog);
	input.put("log", log);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/modify.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
