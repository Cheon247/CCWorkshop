/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.manager.modelmanager.model.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CCModel class contains all the basic attributes of a model.
 * @author Chingo
 */
public abstract class CCModel implements Serializable {

    /** Unique identifier for this model. **/
    private int id;
    /** used to group similar models. **/
    private CCModelGroup group;
    /** All faces in this model. **/
    private List<CCFace> faces;

    /**
     * Constructor.
     * @param fcs List of all faces of this model
     */
    public CCModel(final List<CCFace> fcs) {
        this.faces = fcs;
    }
    /**
     * The group of this model.
     * @return CCModelGroup The group of this model
     */
    public final CCModelGroup getGroupName() {
        return this.group;
    }

    /**
     * Sets the group for this model .
     * @param g The group of this model
     */
    public final void setGroup(final CCModelGroup g) {
        assert g != null : "null group";
        this.group = g;
    }

    /**
     * Gets the id for this model.
     * @return id The id of this model
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Adds a faces to this model.
     * @param f The face that should be added
     */
    public final void addFace(final CCFace f) {
        assert f != null : "null face";
        this.faces.add(f);
    }

    /**
     * Gets the faces for this model.
     * @return ArrayList of faces of this model
     */
    public final List<CCFace> getFaces() {
        return this.faces;
    }

    /**
     * Sets the faces for this model.
     * @param fcs ArrayList of faces for this model
     */
    public final void setTriangles(final ArrayList<CCFace> fcs) {
        this.faces = fcs;
    }

    /**
     * Writes triangles to log file.
     */
    public final void writeFacesToLogFile() {
        File file = new File("log/triangles.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CCModel.class.getName())
                        .log(Level.SEVERE, null, ex);
        }
        if (writer != null) {
        for (CCFace t : faces) {
            writer.println(t.getVertices().size());
        }
        writer.close();
        }
    }
}
