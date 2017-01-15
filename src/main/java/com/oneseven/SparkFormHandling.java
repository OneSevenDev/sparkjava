package com.oneseven;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
/**
 * Created by manuelguarniz on 14/01/17.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        //Configure Freemark
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormHandling.class,"/");

        get("/",(req, res) -> {
            Map<String, Object> fruitMap = new HashMap<>();
            StringWriter writer = new StringWriter();
            try {
                Template template = configuration.getTemplate("fruitPicker.ftl");
                fruitMap.put("fruits",Arrays.asList("apple","banana","orange","peach"));
                template.process(fruitMap,writer);
                return writer;
            } catch (Exception e){
                halt(500);
                return null;
            }
        });

        post("/favorite_fruit",(req, res) -> {
            final String fruit = req.queryParams("fruit");
            return fruit == null ? "Why don't you pick one?": "Your favorite fruit is ".concat(fruit);
        });
    }
}
