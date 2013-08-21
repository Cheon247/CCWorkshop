package com.cc.manager.modelmanager.model.core;

import com.cc.utils.CCNumberFormatter;
import java.io.Serializable;

/**
 * Class for CCVertex.
 * @author Chingo
 */
public class CCVertex implements Serializable {

    /** This vertex it's unique identifier. **/
    private Long id;
    /** This vertex its bone id, initial is -1, which means root. **/
    private Integer boneId;
    /** positions. **/
    /** x-position of the vertex. **/
    private Double posX;
    /** y-position of the vertex. **/
    private Double posY;
    /** z-position of the vertex. **/
    private Double posZ;
    /** norm-x-position of the vertex. **/
    private Double normX;
    /** norm-y-position of the vertex. **/
    private Double normY;
    /** norm-z-position of the vertex. **/
    private Double normZ;
    /** normal UV of the vertex. **/
    private Double normUV;
    /** normal Weight of the vertex. **/
    private Double normWeight;

    /**
     * Default Constructor.
     */
    public CCVertex() {
    }
    /**
     * Constructor that set all position values immediately.
     * @param positionx The x-position to set
     * @param positiony The y-position to set
     * @param positionz The z-position to set
     * @param normalx The normal-x to set
     * @param normaly The normal-y to set
     * @param normalz The normal-z to set
     */
    public CCVertex(final Double positionx,
                    final Double positiony,
                    final Double positionz,
                    final Double normalx,
                    final Double normaly,
                    final Double normalz) {
        this.posX = positionx;
        this.posY = positiony;
        this.posZ = positionz;
        this.normX = normalx;
        this.normY = normaly;
        this.normZ = normalz;
    }

    /**
     * Gets the normal uv of this vertex.
     * @return The normal uv of this vertex
     */
    public final Double getNormUV() {
        return normUV;
    }

    /**
     * Sets the normal uv of this vertex.
     * @param normalUV The normal uv to set
     */
    public final void setNormUV(final Double normalUV) {
        this.normUV = normalUV;
    }

    /**
     * Gets the normal weight of this vertex.
     * @return The normal weight of this vertex
     */
    public final Double getNormWeight() {
        return normWeight;
    }

    /**
     * Sets the normal weight of this vertex.
     * @param normalWeight The normal weight to set on this vertex
     */
    public final void setNormWeight(final Double normalWeight) {
        this.normWeight = normalWeight;
    }
    /**
     * Gets the UNIQUE identifier for this bone.
     * @return the unique identifier for this bone
     */
    public final Long getId() {
        return this.id;
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
     * Checks if the vertex has the same boneId and is on exactly the same
     * position.
     * @param v The vertex to compare to
     * @return true if vertex is on the same position
     */
    public final boolean isSameAs(final CCVertex v) {
        boolean isSame = false;
        if (this.getBoneId() == v.getBoneId()
                && this.getPosX() == v.getPosX()
                && this.getPosY() == v.getPosY()
                && this.getPosZ() == this.getPosZ()) {
            isSame = true;
        }
        return isSame;
    }
    @Override
    public final String toString() {
        String vertexString = "";
        vertexString += this.boneId + " ";
        vertexString += CCNumberFormatter.smdformat(this.posX) + " ";
        vertexString += CCNumberFormatter.smdformat(this.posY) + " ";
        vertexString += CCNumberFormatter.smdformat(this.posZ) + " ";
        vertexString += CCNumberFormatter.smdformat(this.normX) + " ";
        vertexString += CCNumberFormatter.smdformat(this.normY) + " ";
        vertexString += CCNumberFormatter.smdformat(this.normZ) + " ";
        vertexString += CCNumberFormatter.smdformat(this.normUV) + " ";
        vertexString += CCNumberFormatter.smdformat(this.normWeight) + " ";

        return vertexString;
    }
}
