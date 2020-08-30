package com.suprun.criteria.dao.source;

import com.suprun.criteria.dao.DAOException;

import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class ApplianceSource {

    private static final String RESOURCE_FILE = "properties.file";
    private static final String FILE_NAME = "filename";

    public Path receiveApplianceSourcePath() throws DAOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE);
        String fileName = resourceBundle.getString(FILE_NAME);
        Path path = null;
        URL url = this.getClass().getClassLoader().getResource(fileName);
        if (url != null) {
            path = Path.of(url.getPath().substring(3)); // path without prefix c:
        }
        return path;
    }
}

