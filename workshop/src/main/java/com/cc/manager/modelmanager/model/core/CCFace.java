package com.cc.manager.modelmanager.model.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for CCFace.
 * @author Chingo
 */
public class CCFace implements Serializable {

    /** Unique identifier. **/
    private Long id;

    /** The material applied to this triangle. **/
    private String material;

    /** List of vertices in this triangle. **/
    private List<CCVertex> vertices;
    /**
     * Constructor.
     * @param vtcs List of vertices to set
     */
    public CCFace() {
        this.vertices = new ArrayList<CCVertex>();
    }

    /**
     * Gets the material.
     * @return the Material
     */
    public final String getMaterial() {
        return this.material;
    }

    /**
     * Sets the material.
     * @param m the Material
     */
    public final void setMaterial(final String m) {
        this.material = m;
    }

    /**
     * Gets the id.
     * @return This face it's id
     */
    public final Long getId() {
        return this.id;
    }

    /**
     * Gets all vertices of this triangle.
     * @return ArrayList of vertices in this triangle
     */
    public final List<CCVertex> getVertices() {
        return this.vertices;
    }

    /**
     * Sets the vertices in this triangle.
     * @param vtcs The list of vertices to set
     */
    public final void setVertices(final List<CCVertex> vtcs) {
        this.vertices = vtcs;
    }

    /**
     * Checks if vertex is in triangle.
     * @param v The vertex
     * @return true if vertex is in triangle
     */
    public final boolean containsVertex(final CCVertex v) {
        return this.vertices.contains(v);
    }

    /**
     * Gets a vertex on a specific index.
     * @param index The index
     * @return the vertex on the index
     */
    public final CCVertex getVertex(final Integer index) {
        return this.vertices.get(index);
    }

    /**
     * Adds a vertex to the triangle.
     * @param vertex The vertex to add to the triangle
     */
    public final void addVertex(final CCVertex vertex) {
        this.vertices.add(vertex);
    }

    /**
     * Removes a vertex from this triangle.
     * @param vertex The vertex to remove from this triangle
     */
    public final void removeVertex(final CCVertex vertex) {
        this.vertices.remove(vertex);
    }
    /**
     * Returns the size of this triangle.
     * @return amount of vertices in this triangle
     */
    public final Integer size() {
        return this.vertices.size();
    }

    @Override
    public final String toString() {
        String triangleString = "";
        triangleString += this.material;
        for (CCVertex v : vertices) {
            triangleString += "\n" + v.toString();
        }
        return triangleString;
    }
}
