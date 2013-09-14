/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd;

import Entities.CCModel;
import Entities.CCNode;
import Entities.CCTriangle;
import Entities.CCVertex;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

/**
 *
 * @author Chingo
 */
public final class CCTriangleProcessor {

    /**
     * Private Constructor.
     */
    private CCTriangleProcessor() {
    }

    /**
     * Gets triangles from data.
     *
     * @param td The data that contains info about the triangles
     * @return list of triangles
     */
    protected static List<CCTriangle> getTriangles(final List<String> td
            , final List<CCNode> nodes, final CCModel model) {
        ArrayList<CCTriangle> triangles = new ArrayList<>();
        CCTriangle triangle = null;
        for (String s : td) {
            if (!s.split("\\s")[0].matches("[0-9]+")) {
                triangle = new CCTriangle();
                triangle.setMaterial(s);
                triangle.setCCModel(model);
                triangles.add(triangle);
            } else if (triangle == null) {
                Logger.getLogger(CCTriangleProcessor.class.getName())
                        .log(Logger.Level.WARN, "Triangle was null");
            } else {
                CCVertex vertex = CCVertexDataProcessor.processVertex(s);
                vertex = setNode(vertex, CCVertexDataProcessor.getNodeId(s),
                        nodes);
                vertex.setCCTriangle(triangle);
                triangle = addToTriangle(triangle, vertex);
            }
        }
        return triangles;
    }

    /**
     * @param v The vertex to set the node
     * @param nodeId The id of the node
     * @param nodes A list of existing nodes
     * @return The vertex with the node attribute set
     */
    private static CCVertex setNode(final CCVertex v, final int nodeId,
            final List<CCNode> nodes) {
        for (CCNode n : nodes) {
            if (n.getNodeId() == nodeId) {
                v.setCCNode(n);
                break;
            }
        }
        return v;
    }
    /**
     * Adds a vertex to a triangle.
     * @param t The triangle to add the vertex to
     * @param v The vertex to add to the triangle
     * @return The triangle with the vertex added
     */
    private static CCTriangle addToTriangle(final CCTriangle t,
            final CCVertex v) {
        List<CCVertex> vts;
        if (t.getVertices() != null) {
            vts = t.getVertices();
        } else {
            vts = new ArrayList<>();
        }
        vts.add(v);
        t.setVertices(vts);

        return t;
    }
}
