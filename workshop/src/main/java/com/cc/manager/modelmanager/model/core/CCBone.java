package com.cc.manager.modelmanager.model.core;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Class for bone objects.
 * A bone or else known as joint moves all vertices that are asigned
 * to this bone along  with them.
 * @author Chingo
 */

public class CCBone implements Serializable {
    /** Unique Identifier. **/
    private Long id;
    /** CCBone identifier. **/
    private Integer boneId;
    /** Name of the bone.
     *  Also is unique within a model
     **/
    private String boneName;
    /** CCBone identifier of this bone its parent. **/
    private Integer parentBoneId;
    /** positions. **/
    /** x-position of the bone. **/
    private Double posX;
    /** y-position of the bone. **/
    private Double posY;
    /** z-position of the bone. **/
    private Double posZ;
    /** norm-x-position of the bone. **/
    private Double normX;
    /** norm-y-position of the bone. **/
    private Double normY;
    /** norm-z-position of the bone. **/
    private Double normZ;
    /** Treemap of vertices on this bone. **/
    private TreeMap vertices;

    /**
     * Default Constructor.
     */
    public CCBone(){
        this.vertices = new TreeMap();
    }
    /**
     * Gets the UNIQUE identifier for this bone.
     * @return the unique identifier for this bone
     */
    public final Long getId() {
        return this.id;
    }
    /**
     * Set the all the vertices asigned to this bone.
     * @param vts Treemap of vertices to set to this bone
     */
    public final void setVertices(final TreeMap vts) {
        this.vertices = vts;
    }
    /**
     * Gets the vertices from this bone.
     * @return Treemap of vertices of this bone
     */
    public final TreeMap getVertices() {
        return this.vertices;
    }
    /**
     * Gets the size of this bone.
     * @return the number of vertices asigned to this bone
     */
    public final int size() {
        return this.vertices.size();
    }

    /**
     * Adds/puts a vertex on this bone.
     * @param v The vertex that should be put on this bone
     */
    public final void putVertex(final CCVertex v) {
        vertices.put(v.getId(), v);
    }

    /**
     * Removes a specific vertex from this bone.
     * @param v The vertex that should be removed from this bone
     */
    public final void removeVertex(final CCVertex v) {
        this.vertices.remove(v.getId());
    }
    /**
     * Gets this bone it's id.
     * WARNING!: Not to confuse with this bone it's unique identifier!
     * @return This bone it's id
     */
    public final Integer getBoneId() {
        return this.boneId;
    }

    /**
     * Sets this bone its boneId
     * WARNING!: Not to confuse with this bone it's unique identifier!
     * @param bId The boneId this bone should have
     */
    public final void setBoneId(final Integer bId) {
        this.boneId = bId;
    }

    /**
     * Gets the boneName.
     * @return The bone it's name
     */
    public final String getBoneName() {
        return boneName;
    }

    /**
     * Sets the bone it's name.
     * @param bName The boneName to set this bone name to
     */
    public final void setBoneName(final String bName) {
        this.boneName = bName;
    }

    /**
     * Gets the Id of this bone it's parent.
     * WARNING!: Not to confuse with this bone it's unique identifier!
     * @return The id of this bone it's parent
     */
    public final Integer getParentBoneId() {
        return this.parentBoneId;
    }

    /**
     * Sets this bone its parentId.
     * @param pbId The parentBoneId to set this bone to
     */
    public final void setParentBoneId(final Integer pbId) {
        this.parentBoneId = pbId;
    }

    /**
     * Gets the x-position of this bone.
     * @return The x-position of this bone
     */
    public final Double getPosX() {
        return this.posX;
    }

    /**
     * Set the x-position of this bone.
     * @param positionX The x-position to set
     */
    public final void setPosX(final Double positionX) {
        this.posX = positionX;
    }

    /**
     * Gets the y-postion of this bone.
     * @return The y-position of this bone
     */
    public final Double getPosY() {
        return this.posY;
    }

    /**
     * Set the y-position of this bone.
     * @param positionY The y-position to set
     */
    public final void setPosY(final Double positionY) {
        this.posY = positionY;
    }

    /**
     * Get the z-position of this bone.
     * @return The z-position of this bone
     */
    public final Double getPosZ() {
        return this.posZ;
    }

    /**
     * Sets the z-position of this bone.
     * @param positionZ The z-position to set
     */
    public final void setPosZ(final Double positionZ) {
        this.posZ = positionZ;
    }

    /**
     * Gets the norm-x of this bone.
     * @return The norm-x of this bone
     */
    public final Double getNormX() {
        return this.normX;
    }

    /**
     * Sets the norm-x of this bone.
     * @param normalX The norm-x to set
     */
    public final void setNormX(final Double normalX) {
        this.normX = normalX;
    }

    /**
     * Gets the norm-y of this bone.
     * @return The norm-y of this bone
     */
    public final Double getNormY() {
        return this.normY;
    }

    /**
     * Sets the norm-y of this bone.
     * @param normalY The norm-y to set
     */
    public final void setNormY(final Double normalY) {
        this.normY = normalY;
    }
    /**
     * Gets the norm-z of this bone.
     * @return The norm-z of this bone
     */
    public final Double getNormZ() {
        return this.normZ;
    }

    /**
     * Sets the norm-z of this bone.
     * @param normalZ The norm-z to set
     */
    public final void setNormZ(final Double normalZ) {
        this.normZ = normalZ;
    }
    /**
     * Checks if this bone is equal to another bone by its boneId and boneName.
     * @param bone The bone to compare to
     * @return true if BoneId and BoneName are the same
     */
    public final Boolean equals(final CCBone bone) {
        Boolean isEqual = false;
        if (this.getBoneId() == bone.getBoneId()
                && this.boneName.equals(bone.getBoneName())) {
            isEqual = true;
        }
        return isEqual;
    }

    @Override
    public final String toString() {
    String boneInfo;
    boneInfo = "BoneID: " + boneId + "\tboneName:" + boneName
            + "\tParentBoneID:" + parentBoneId;
        return boneInfo;
    }
}
