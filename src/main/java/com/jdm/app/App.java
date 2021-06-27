package com.jdm.app;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    public static String text = "Hello World!";
    public static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println(text);
        LOG.log(Level.INFO, "log4j configured");
    }
}
