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

    public static String getAllUsers(boolean userLog, int userId) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

	input.put("userLog", userLog);
	input.put("userId", userId);
	input.put("eleves", EleveCore.getAllUsers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleves.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getUserById(int id, boolean userLog) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleve", EleveCore.getUserById(id));
	input.put("userLog", userLog);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleve.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String modify(int id, boolean userLog, String log) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleve", EleveCore.getUserById(id));
	input.put("userLog", userLog);
	input.put("log", log);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/modify.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(String log) throws IOException, TemplateException {
	Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("log", log);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/create.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
