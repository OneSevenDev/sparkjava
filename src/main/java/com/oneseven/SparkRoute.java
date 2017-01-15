package com.oneseven;

import static spark.Spark.*;

/**
 * Created by manuelguarniz on 14/01/17.
 */
public class SparkRoute {
    public static void main(String[] args) {
        get("/",(req, res) -> "Hello World");
        get("/test",(req, res) -> "Page on test");
        get("/echo/:thing",(req, res) -> req.params(":thing"));
    }
}
