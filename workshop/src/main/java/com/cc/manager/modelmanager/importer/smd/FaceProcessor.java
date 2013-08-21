package com.cc.manager.modelmanager.importer.smd;

import com.cc.manager.modelmanager.model.core.CCFace;
import com.cc.manager.modelmanager.model.core.CCVertex;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Chingo
 */
public class FaceProcessor implements Runnable {

    /**
     * Start of faces, still needs offset of +1. *
     */
    private static final String FACES_START = "triangles";
    /**
     * Start of faces, still needs offset of -1. *
     */
    private static final String FACES_END = "end";
    /**
     * Start index of faces. *
     */
    private Integer facesStart;
    /**
     * End index of faces. *
     */
    private Integer facesEnd;
    /**
     * List of strings that define the faces. *
     */
    private List<String> facesData;
    /**
     * The result of this processor. *
     */
    private ArrayList<CCFace> result;
    /**
     * Index of bone id. *
     */
    private static final int BONE_ID = 0;
    /**
     * Index of x-position. *
     */
    private static final int POSITION_X = 1;
    /**
     * Index of y-position. *
     */
    private static final int POSITION_Y = 2;
    /**
     * Index of z-position. *
     */
    private static final int POSITION_Z = 3;
    /**
     * Index of x-normal. *
     */
    private static final int NORM_X = 4;
    /**
     * Index of y-normal. *
     */
    private static final int NORM_Y = 5;
    /**
     * Index of z-normal. *
     */
    private static final int NORM_Z = 6;
    /**
     * Index of uv-normal. *
     */
    private static final int NORM_UV = 7;
    /**
     * Index of weight-normal. *
     */
    private static final int NORM_WEIGHT = 8;
    /**
     * Valid length for bone position string array.
     */
    private static final int VALID_VERTEX_INFO_LENGTH = 7;

    /**
     * Constructor.
     *
     * @param data List of strings obtained from smd file
     */
    public FaceProcessor(final List<String> data) {
        /**
         * Get and set data indexes for faces. *
         */
        facesStart = data.indexOf(FACES_START);
        facesEnd = data.indexOf(FACES_END);
        /**
         * Set faces data. *
         */
        facesData = data.subList(facesStart, facesEnd);
        /**
         * Create list for result *
         */
        result = new ArrayList<CCFace>();
    }

    /**
     * Sets the faces.
     *
     * @param data Faces data
     */
    private void setFaces(final List<String> data) {
        CCFace face = null;
        int faceIndex = 0;
        for (String s : facesData) {

            String[] faceLine = s.split("\\s");

            if (faceLine.length == 1) {
                faceIndex++;
                face = new CCFace();
                face.setMaterial(s);
            } else {
                if (face != null) {
                    if (faceLine.length == VALID_VERTEX_INFO_LENGTH) {
                        CCVertex v = new CCVertex();
                        // Set BoneID
                        v.setBoneId(Integer.parseInt(faceLine[BONE_ID]));
                        // Set Vertex positions
                        v.setPosX(Double.parseDouble(faceLine[POSITION_X]));
                        v.setPosY(Double.parseDouble(faceLine[POSITION_Y]));
                        v.setPosZ(Double.parseDouble(faceLine[POSITION_Z]));
                        // Set Vertex Normals
                        v.setNormX(Double.parseDouble(faceLine[NORM_X]));
                        v.setNormY(Double.parseDouble(faceLine[NORM_Y]));
                        v.setNormZ(Double.parseDouble(faceLine[NORM_Z]));
                        // Set Norm UV && NormWeight
                        v.setNormUV(Double.parseDouble(faceLine[NORM_UV]));
                        v.setNormWeight(Double.
                                parseDouble(faceLine[NORM_WEIGHT]));

                        face.addVertex(v);
                        faceIndex++;
                    } else {
                        Logger.getLogger(SMDBoneProcessor.class.getName())
                                .log(Level.SEVERE, "Invalid length for vertex "
                                + "data array, length was {0} "
                                + "expected length: {1}"
                                , new Object[]{faceLine.length,
                                    VALID_VERTEX_INFO_LENGTH});
                        result = null;
                        break;
                    }
                }
                result.add(face);
            }
        }
    }

    /**
     * Returns the result, a list of faces with all the properties defined or
     * returns null if data was invalid.
     *
     * @return List of faces with all the properties defined otherwise returns
     * null if data was invalid
     */
    public final ArrayList<CCFace> getResult() {
        return this.result;
    }

    /**
     * Methods that will be executed when this method is fired.
     */
    @Override
    public void run() {
        setFaces(facesData);
    }
}
