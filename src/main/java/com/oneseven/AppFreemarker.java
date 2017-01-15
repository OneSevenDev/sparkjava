package com.oneseven;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manuelguarniz on 14/01/17.
 */
public class AppFreemarker {
    public static void main(String[] args) {
        Configuration configuration =  new Configuration();
        configuration.setClassForTemplateLoading(AppFreemarker.class, "/");

        try {
            Template template =  configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "Freemarker");

            template.process(map,writer);
            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
