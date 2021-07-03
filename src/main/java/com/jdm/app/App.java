package com.jdm.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jdm.app.properties.PropertiesWrapper;

import org.apache.commons.cli.*;

/**
 * Hello world!
 *
 */
public class App {
    public static final Logger LOG = LogManager.getLogger(App.class);

    private static final String VERSION_KEY = "version";

    public static void main(String[] args) throws ParseException, IOException {

        Options options = new Options();
        options.addOption(VERSION_KEY, "Display version!");

        // Create a parser
        CommandLineParser parser = new DefaultParser();

        // Parse the options passed as command line arguments
        CommandLine cmd = parser.parse(options, args);

        Properties props = PropertiesWrapper.getProperties();
        if (cmd.hasOption(VERSION_KEY)) {
            System.out.println("Version: " + props.getProperty(VERSION_KEY));
        }
    }
}
