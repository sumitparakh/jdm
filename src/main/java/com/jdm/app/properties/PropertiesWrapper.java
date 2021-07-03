package com.jdm.app.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesWrapper {

    private static final Logger LOG = LogManager.getLogger(PropertiesWrapper.class);

    PropertiesWrapper() throws IOException {
        getProperties();
    }

    public static Properties getProperties() throws IOException {
        try (InputStream input = PropertiesWrapper.class.getClassLoader().getResourceAsStream("jdm.properties")) {
            Properties props = new Properties();
            if (input == null) {
                LOG.error("Sorry, unable to find jdm.properties");
                return props;
            }
            props.load(input);
            return props;
        }
    }
}
