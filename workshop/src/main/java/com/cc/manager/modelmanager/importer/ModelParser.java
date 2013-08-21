package com.cc.manager.modelmanager.importer;

import com.cc.manager.modelmanager.model.core.CCModel;
import java.io.File;


/**
 * Abstract class modelimporter.
 * @author Chingo
 */
public abstract class ModelParser {
    /**
     * Parses a model from a file.
     * @param file The file containing the model
     * @return The model
     */
    public abstract CCModel parseModelFromFile(File file);

    /**
     * Writes a model to a file.
     * @param model The model to export
     */
    public abstract void writeModelToFile(CCModel model);

}
