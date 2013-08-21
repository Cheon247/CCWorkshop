package com.cc.manager.modelmanager.importer.smd;

import com.cc.manager.modelmanager.model.anim.CCSMDModel;
import com.cc.manager.modelmanager.model.core.CCBone;
import com.cc.manager.modelmanager.model.core.CCFace;
import com.cc.manager.modelmanager.model.core.CCModel;
import com.google.common.base.Charsets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parses SMD.
 *
 * @author Chingo
 */
public final class SMDParser {

    /**
     * Constructor.
     */
    private SMDParser() {
    }

    /**
     * Parse SMDModel from file.
     * @param file The SMDFile
     * @return SMDModel if was valid otherwise returns null
     * @throws InterruptedException if face or boneprocessing goes wrong
     */
    public CCSMDModel parseSMDModelFromFile(final File file)
            throws InterruptedException {
        assert file != null : "file is null";

        /**
         * Read data *
         */
        List<String> data = null;
        try {
            data = Files.readAllLines(Paths.get(file.getAbsolutePath()),
                    Charsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(com.cc.manager.modelmanager.importer.smd
                    .SMDParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Process file.
         * -------------
         * Assign data to processors
         */
        SMDBoneProcessor boneProcessor = new SMDBoneProcessor(data);
        FaceProcessor faceProcessor = new FaceProcessor(data);

        /**
         * Create thread for processors *
         */
        Thread boneThread = new Thread(boneProcessor);
        Thread triangleThread = new Thread(faceProcessor);

        /**
         * Start Processors *
         */
        boneThread.start();
        triangleThread.start();
        /**
         * Wait till complete.
         */
        triangleThread.join();
        boneThread.join();
        /**
         * Get results
         */
        ArrayList<CCBone> bones = boneProcessor.getResult();
        ArrayList<CCFace> faces = faceProcessor.getResult();
        /**
         * Null check results, model will be null or set afther this
         */
        CCSMDModel model = null;
        if (bones == null) {
            Logger.getLogger(SMDParser.class.getName())
                    .log(Level.SEVERE, "List of bones is null");
        } else {
            if (faces == null) {
            Logger.getLogger(SMDParser.class.getName())
                    .log(Level.SEVERE, "List of faces is null");
            } else {
                /** Faces and bones arent null, set give model bones **/
                model = new CCSMDModel(faces, bones);
            }
        }
        return model;
    }

    /**
     * Writes model to a file.
     * @param model The model to write to a file
     */
    public void writeModelToFile(final CCModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
}
