/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd;

import Entities.CCModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chingo
 */
public final class CCModelProcessor {

    /**
     * Private Constructor.
     */
    private CCModelProcessor() {
    }
    /**
     * Creates a new model with given data.
     * @param model The model to set the data tos
     * @param modelData The data that contains the model info
     * @return The model that has been set
     */
    protected static CCModel getModel(final String versionData,
            final String timeData) {
        CCModel model = new CCModel();
        model.setVersion(getVersion(versionData));
        model.setTime(getTime(timeData));
        return model;
    }

    /**
     * Parses the version from the string.
     * @param versionData The string that contains the version info
     * @return Integer version of the model, if no version was found
     * it returns 1
     */
    private static Integer getVersion(final String versionData) {
        String[] vArray = versionData.split("\\s");
        int version = 1;
        if (vArray.length == 2
                && vArray[0].equals("version")
                && vArray[1].matches("[0-9]+")) {
            Integer.parseInt(vArray[1]);
        } else {
            Logger.getLogger(SMDConverter.class.getName()).log(Level.WARNING,
                    "no version was found, setting version to default: 1");
        }
        return version;
    }
    
    private static Integer getTime(final String timeData) {
        String[] vArray = timeData.split("\\s");
        int time = 1;
        if (vArray.length == 2
                && vArray[0].equals("version")
                && vArray[1].matches("[0-9]+")) {
            Integer.parseInt(vArray[1]);
        } else {
            Logger.getLogger(SMDConverter.class.getName()).log(Level.WARNING,
                    "no time was found, setting time to default: 1");
        }
        return time;
    }
}
