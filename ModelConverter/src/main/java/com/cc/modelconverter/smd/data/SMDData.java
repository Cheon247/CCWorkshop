/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd.data;

import java.util.List;

/**
 *
 * @author Chingo
 */
public class SMDData {
     /** Data that contains info about the models version. **/
        private String versionData;
        public String getVersionData(){ return versionData; }
        public void setVersionData(String vd) { versionData = vd;}
        
        /** Data that contains info about the models current time. **/
        private String timeData;
        public String getTimeData() { return timeData; }
        public void setTimeData(String td) { timeData = td; }
        
        /** Data that contains info about the node names. **/
        private List<String> nodeNameData;
        public List<String> getNodeNameData() { return nodeNameData; }
        public void setNodeNameData(List<String> nnd){ nodeNameData = nnd; } 
        
        /** Data that contains info about the node positions. **/
        private List<String> nodePositionData;
        public List<String> getNodePositionData() { return nodePositionData; }
        public void setNodePostionsData(List<String> npd) { nodePositionData = npd; }
        
        /** Data that contains info about the triangles **/
        private List<String> triangleData;
        public List<String> getTriangleData() { return triangleData; }
        public void setTriangleData(List<String> td) { triangleData = td; }
}
