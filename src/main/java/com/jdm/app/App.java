package com.jdm.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    public static final Logger LOG = LogManager.getLogger(App.class);

    @Parameter(names = "-version", description = "Get version detail of jdm!", help = true)
    private String version = "1.0.0";

    public static void main(String[] args) {
        App app = new App();
        try {
            JCommander.newBuilder().addObject(app).build().parse(args);
        } catch (ParameterException exception) {
            if (exception.getMessage().indexOf("-version") <= -1) {
                LOG.log(Level.ERROR, exception.getMessage());
                exception.getJCommander().usage();
            }
        }
        app.run();
    }

    public void run() {
        LOG.log(Level.INFO, version);
    }
}
