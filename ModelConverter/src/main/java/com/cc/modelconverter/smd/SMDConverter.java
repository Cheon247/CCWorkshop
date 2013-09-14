/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.modelconverter.smd;

import Entities.CCModel;
import Entities.CCNode;
import Entities.CCTriangle;
import Entities.CCVertex;
import com.cc.modelconverter.smd.data.SMDData;
import com.google.common.base.Charsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.CCWorkshopManager;

/**
 * @author Chingo
 */
public final class SMDConverter {
    
    /**
     * Constructor.
     */
    private SMDConverter() {
    }

    /**
     * @param file The file to convert
     * @return model that has been imported
     * @throws Exception if input file was invalid, or data wasn't valid
     */
    public static CCModel convertSMDModel(final File file)
            throws Exception {
        List<String> data = Files.readAllLines(
                Paths.get(file.getAbsolutePath()), Charsets.UTF_8);
        
       /** Prepare smdData **/ 
       SMDData smdData = prepareData(data);
       /** Set model **/
       CCModel model = CCModelProcessor.getModel(smdData.getVersionData(),
               smdData.getTimeData());
       /** Set model nodes **/
       model.setNodes(CCNodeDataProcessor
               .processNodes(smdData.getNodeNameData(),
               smdData.getNodePositionData(), model));
       /** Set model triangles **/
       model.setTriangles(CCTriangleProcessor
               .getTriangles(smdData.getTriangleData(), model.getNodes(), model));
       
       CCWorkshopManager.getInstance().save(model);
//       for (CCTriangle t : model.getTriangles()) {
////           CCWorkshopManager.getInstance().save(t);
////           for(CCVertex v : t.getVertices()) {
////               CCWorkshopManager.getInstance().save(v);
////           }
//       }
       
//       for (CCNode n : model.getNodes()){
//           CCWorkshopManager.getInstance().save(n);
//       }
//       
       return model;
    }
    
    /**
     * @param data Prepares data to be processed.
     * @return CleanData, data without empty strings;
     * @throws Exception if data was invalid.
     */
    private static SMDData prepareData(final List<String> data)
            throws Exception {
        SMDData smdData = new SMDData();
        int endIndex = 0;
        /** ModelData indexes **/
        int nodeNamesStart = 0, nodeNamesEnd = 0,
        nodePositionsStart = 0, nodePositionEnd = 0,
        trianglesStart = 0, trianglesEnd = 0, 
        timeData = 0, versionData = 0;
        
        /**
         * Set all indexes.
         */
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).trim().length() > 0) {
                switch (data.get(i)) {
                    case "nodes":nodeNamesStart = i + 1; break;
                    case "time": timeData = i; break;
                    case "version": versionData = i; break;
                    case "end":
                        switch (endIndex) {
                            case 0: nodeNamesEnd = i; endIndex++; break;
                            case 1: nodePositionEnd = i; endIndex++; break;
                            case 2: trianglesEnd = i; endIndex++; break;
                            default:break;
                        }
                        break;
                    case "skeleton":nodePositionsStart = i + 2; break;
                    case "triangles":trianglesStart = i + 1; break;
                    default:break;
                }
            } else {
                Logger.getLogger(SMDConverter.class.getName())
                        .log(Level.INFO, "Removed empty String");
            }
        }
        
        /**
         * Set SMDData.
         */
        smdData.setNodeNameData(data.subList(nodeNamesStart, nodeNamesEnd));
        smdData.setNodePostionsData(data.subList(nodePositionsStart, nodePositionEnd));
        smdData.setTriangleData(data.subList(trianglesStart, trianglesEnd));
        smdData.setTimeData(data.get(timeData));
        smdData.setVersionData(data.get(versionData));
        return smdData;
    }
}
