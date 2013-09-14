/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd;

import Entities.CCNode;
import Entities.CCTriangle;
import Entities.CCVertex;
import java.util.List;

/**
 *
 * @author Chingo
 */
public class CCVertexDataProcessor {
     /**
     * Index of bone id. *
     */
    private static final int BONE_ID_INDEX = 0;
    /**
     * Index of x-position. *
     */
    private static final int POSITION_X_INDEX = 1;
    /**
     * Index of y-position. *
     */
    private static final int POSITION_Y_INDEX = 2;
    /**
     * Index of z-position. *
     */
    private static final int POSITION_Z_INDEX = 3;
    /**
     * Index of x-normal. *
     */
    private static final int NORM_X_INDEX = 4;
    /**
     * Index of y-normal. *
     */
    private static final int NORM_Y_INDEX = 5;
    /**
     * Index of z-normal. *
     */
    private static final int NORM_Z_INDEX = 6;
    /**
     * Index of uv-normal. *
     */
    private static final int NORM_UV_INDEX = 7;
    /**
     * Index of weight-normal. *
     */
    private static final int NORM_WEIGHT_INDEX = 8;
    /**
     * Valid length for vertex string array.
     */
    private static final int VALID_VERTEX_INFO_LENGTH = 7;
    /**
     * Processes a vertex from given String.
     * @param vertexData the Data string that contains the vertex info
     * @param triangle the face where this vertex belongs to
     * @return the vertex
     */
    protected static CCVertex processVertex(final String vertexData) {
        String[] vData = vertexData.split("\\s");
        CCVertex vertex = new CCVertex();
        /** Set bone id */
//        vertex.setCCNode(Integer.parseInt(vData[BONE_ID_INDEX]));
        /** Set bone positions */
        vertex.setPosX(Double.parseDouble(vData[POSITION_X_INDEX]));
        vertex.setPosY(Double.parseDouble(vData[POSITION_Y_INDEX]));
        vertex.setPosZ(Double.parseDouble(vData[POSITION_Z_INDEX]));
        /** Set normals */
        vertex.setNormX(Double.parseDouble(vData[NORM_X_INDEX]));
        vertex.setNormY(Double.parseDouble(vData[NORM_Y_INDEX]));
        vertex.setNormZ(Double.parseDouble(vData[NORM_Z_INDEX]));
        /** Set Weight & UV */
        vertex.setNormUV(Double.parseDouble(vData[NORM_UV_INDEX]));
        vertex.setNormWeight(Double.parseDouble(vData[NORM_WEIGHT_INDEX]));
//        vertex.setCCTriangle(triangle);
        return vertex;
    }

    /**
     * Only gets the node id of this vertex.
     * @param vertexData The data that contains the info of this vertex
     * @return nodeId
     */
    protected static Integer getNodeId(final String vertexData) {
        String[] vData = vertexData.split("\\s");
        return Integer.parseInt(vData[BONE_ID_INDEX]);
    }
}
