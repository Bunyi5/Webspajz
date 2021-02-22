package com.thesis.webspajz.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertiesLoader {

    public Properties loadProperties(String resourceFileName) throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(resourceFileName);

        configuration.load(inputStream);

        assert inputStream != null;
        inputStream.close();

        return configuration;
    }
}
