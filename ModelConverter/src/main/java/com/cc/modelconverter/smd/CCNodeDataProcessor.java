/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd;

import Entities.CCModel;
import Entities.CCNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes nodeData.
 *
 * @author Chingo
 */
public final class CCNodeDataProcessor {

    /**
     * Length of node name data. *
     */
    private static final Integer NODE_NAME_DATA_LENGTH = 3;
    /**
     * Length of node position data. *
     */
    private static final Integer NODE_POSITION_DATA_LENGTH = 7;
    /**
     * String array index for nodeName. *
     */
    private static final Integer NODE_NAME_INDEX = 1;
    /**
     * String array index for parentBoneid. *
     */
    private static final Integer PARENT_NODE_ID_INDEX = 2;
    /**
     * Index of node id. *
     */
    private static final int NODE_ID_INDEX = 0;
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
     * Constructor.
     */
    private CCNodeDataProcessor() {
    }

    protected static List<CCNode> processNodes(final List<String> nodeNameData,
            final List<String> nodePositionData, final CCModel model)
            throws Exception {

        ArrayList<CCNode> nodes = new ArrayList<>();

        /**
         * Verifiy and add nodes *
         */
        if (nodeNameData.size() == nodePositionData.size()) {
            for (int i = 0; i < nodeNameData.size(); i++) {
                CCNode node = processData(nodeNameData.get(i),
                        nodePositionData.get(i));
//                node.setCCModel(model);
                node.setCCModel(model);
                nodes.add(node);
            }
        } else {
            throw new Exception("Amount of node names isn't equal to the "
                    + "amount of node positions defined");
        }
        return nodes;
    }

    /**
     * Processes data to CCNode.
     *
     * @param nodeData The String that contains the nodeData
     * @param nodePosData The String that contains the data for the positions
     * @param model The model this bone belongs to
     * @throws NodeDataException if data wasn't valid
     * @throws NodeDataLengthException if length of data wasnt correct
     * @return CCNode the node that has been processed
     */
    private static CCNode processData(final String nodeData,
            final String nodePosData)
            throws NodeDataLengthException, NodeDataException {
        CCNode node = new CCNode();
        String[] nodeNameData = nodeData.split("\\s");
        String[] nodePositionData = nodePosData.split("\\s");
        /**
         * Check if both have valid length
         */
        if (nodeNameData.length != NODE_NAME_DATA_LENGTH
                || nodePositionData.length != NODE_POSITION_DATA_LENGTH) {
            throw new NodeDataLengthException();
        }
        /**
         * Check if both data are for the same node if so set the id, else throw
         * exception.
         */
        if (nodeNameData[0].equals(nodePositionData[NODE_ID_INDEX])) {
            node.setNodeId(Integer.parseInt(nodeNameData[NODE_ID_INDEX]));
        } else {
            throw new NodeDataException();
        }
        node.setNodeName(nodeNameData[NODE_NAME_INDEX]);
        node.setParentNodeId(Integer.parseInt(
                nodeNameData[PARENT_NODE_ID_INDEX]));

        /**
         * Set position data
         */
        node.setPosX(Double.parseDouble(nodePositionData[POSITION_X_INDEX]));
        node.setPosY(Double.parseDouble(nodePositionData[POSITION_Y_INDEX]));
        node.setPosZ(Double.parseDouble(nodePositionData[POSITION_Z_INDEX]));
        /**
         * Set normal data
         */
        node.setNormX(Double.parseDouble(nodePositionData[NORM_X_INDEX]));
        node.setNormY(Double.parseDouble(nodePositionData[NORM_Y_INDEX]));
        node.setNormZ(Double.parseDouble(nodePositionData[NORM_Z_INDEX]));
        return node;
    }

    /**
     * Exception that should be thrown when the data wasn't valid.
     */
    private static class NodeDataException extends Exception {

        public NodeDataException() {
            super("node data was invalid");
        }
    }

    /**
     * Exception that should be thrown when the data array doesnt have the
     * correct length.
     */
    private static class NodeDataLengthException extends Exception {

        public NodeDataLengthException() {
            super("invalid length");
        }
    }
    
    
}
