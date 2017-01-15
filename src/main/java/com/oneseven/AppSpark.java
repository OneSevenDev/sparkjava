package com.oneseven;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class AppSpark
{
    public static void main( String[] args )
    {
        get("/",(req, res) -> "Hello World");
    }
}
