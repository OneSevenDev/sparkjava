package com.oneseven;

import freemarker.ext.beans.HashAdapter;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.*;

import static spark.Spark.*;

/**
 * Created by manuelguarniz on 14/01/17.
 */
public class AppSparkFreemarker {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(AppSparkFreemarker.class, "/");

        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            try {
                Template template = configuration.getTemplate("hello.ftl");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("name", "Manuel Guarniz");

                template.process(map,writer);
            } catch (Exception e) {
                halt(500);
                e.printStackTrace();
            }
            return writer;
        });
    }
}
