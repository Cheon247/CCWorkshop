/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.manager.modelmanager.model.core;

/**
 * Class that defines the a group that a model could belong to.
 * @author Chingo
 */
public class CCModelGroup {
    /** Unique Identifier for this group. **/
    private int id;
    /** Unique Name for this group. **/
    private String name;
    /**
     * Gets the id of this group.
     * @return the id of this group
     **/
    public final int getId() {
        return this.id;
    }
    /**
     * Gets the name of this group.
     * @return The group its name
     **/
    public final String getName() {
        return this.name;
    }
    /**
     * Sets the name of this group.
     * @param groupName the Name of this group
     **/
    public final void setName(final String groupName) {
        this.name = groupName;
    }
}
