package com.uca.gui;

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

    public static String getAllProfesseurs() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("professeurs", ProfesseurCore.getAllProfesseurs());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs/professeurs.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getProfesseurById(int id, boolean userLog) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("professeur", ProfesseurCore.getProfesseurById(id));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs/professeur.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String login(String log, boolean userLog, int id) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("log", log);
	input.put("userLog", userLog);
	input.put("userId", id);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs/login.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String create(String log) throws IOException, TemplateException {
	Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("log", log);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("professeurs/create.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
