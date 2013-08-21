package com.cc.manager.modelmanager.importer.smd;

import com.cc.manager.modelmanager.model.core.CCBone;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SMDBoneProcessor launches a thread to get bones from a List<String>.
 *
 * @author Chingo Definitions: Bonestructure: The part of the smd file where all
 * the bones are defined. This part always starts with the string "nodes" and
 * ends with "end"
 * Example:
 * nodes
 * 0 "abdomen" -1
 * 1 "thigh.L" 0
 * 2 "calf.L" 1
 * 3 "foot.L" 2
 * 4 "thigh.R" 0
 * 5 "calf.R" 4
 * 6 "foot.R" 5
 * 7 "spine" 0
 * 8 "thorax" 7
 * 9 "head" 8
 * 10 "shoulder.L" 8
 * 11 "upperarm.L" 10
 * 12 "forearm.L" 11
 * 13 "hand.L" 1
 * 14 "item.L" 13
 * 15 "shoulder.R" 8
 * 16 "upperarm.R" 15
 * 17 "forearm.R" 16
 * 18 "hand.R" 17
 * 19 "item.R" 18
 * end
 */
public final class SMDBoneProcessor implements Runnable {

    /**
     * Start of bone structure, still needs an offset of +1. *
     */
    private static final String BONE_STRUCTURE_START = "nodes";
    /**
     * Start of bone positions, still needs an offset of +2. *
     */
    private static final String BONE_POSITIONS_START = "skeleton";
    /**
     * End of bone structure and bonePositions, still needs an offset of -1. **
     */
    private static final String BONES_END = "end";
    /**
     * Start index for the boneStructure. *
     */
    private Integer bonesStart;
    /**
     * End index for the boneStructure. *
     */
    private Integer bonesEnd;
    /**
     * Start index for bonePositions. *
     */
    private Integer bonePositionsStart;
    /**
     * End index for bonePositions. *
     */
    private Integer bonePositionsEnd;
    /**
     * List of strings that defines the bonestructure. *
     */
    private List<String> bonestructureData;
    /**
     * List of strings that defines the bonepositions. *
     */
    private List<String> bonePositionData;
    /**
     * The offset from BONE_POSITIONS_START. *
     */
    private static final Integer BONE_POSITIONS_OFFSET = 2;
    /**
     * Bonestructure data indexes.
     */
    /**
     * String array index for boneId. *
     */
    private final Integer boneIdIndex = 0;
    /**
     * String array index for boneName. *
     */
    private final Integer boneNameIndex = 1;
    /**
     * String array index for parentBoneid. *
     */
    private final Integer parentBoneIdIndex = 2;
    /**
     * BonePositions data indexes.
     */
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
     * The result of this processor.
     */
    private ArrayList<CCBone> result;
    /**
     * Valid length for bone structure string array.
     */
    private static final int VALID_BONESTRUCTURE_LENGTH = 3;
    /**
     * Valid length for bone position string array.
     */
    private static final int VALID_BONEPOSITION_LENGTH = 7;
    /**
     * Constructor.
     *
     * @param data List of strings obtained from smd file
     */
    public SMDBoneProcessor(final List<String> data) {
        /**
         * Get and set data indexes for bonestructure. *
         */
        bonesStart = data.indexOf(BONE_STRUCTURE_START);
        bonesEnd = data.indexOf(BONES_END);
        /**
         * Set bonestructure data. *
         */
        bonestructureData = data.subList(bonesStart + 1, bonesEnd - 1);
        /**
         * Get and set data indexes for bonepositions. *
         */
        List<String> temp = data.subList(bonesEnd + 1, data.size());
        bonePositionsStart = temp.indexOf(BONE_POSITIONS_START)
                + BONE_POSITIONS_OFFSET;
        bonePositionsEnd = temp.indexOf(bonePositionsEnd);
        /**
         * Set bonePositions data. *
         */
        bonePositionData = data.subList(bonePositionsStart,
                bonePositionsEnd - 1);
        if (bonePositionData.size() != bonestructureData.size()) {
            if (bonestructureData.size() > bonePositionData.size()) {
                Logger.getLogger(SMDBoneProcessor.class.getName()).
                        log(Level.WARNING,
                        "More bones defined than bonepositions given!");
            } else {
                Logger.getLogger(SMDBoneProcessor.class.getName()).
                        log(Level.WARNING,
                        "More bonepositions given than bones defined!");
            }
        } else {
            /**
             * Define result if everything is ok *
             */
            result = new ArrayList<CCBone>();
        }
    }

    /**
     * Sets the data in result that define the bone structure. NOTE: Should be
     * fired BEFORE getBonePositions!
     *
     * @param data Bonestructure data
     */
    private void setBoneStructure(final List<String> data) {
        if (result != null) {
            for (String s : data) {
                CCBone bone = new CCBone();
                String[] b = s.split("\\s");
                if (b.length != VALID_BONESTRUCTURE_LENGTH) {
                    Logger.getLogger(SMDBoneProcessor.class.getName())
                            .log(Level.SEVERE,
                            "Invalid length for bone structure data");
                    this.result = null;
                    break;
                }

                bone.setBoneId(Integer.parseInt(b[boneIdIndex].trim()));
                bone.setBoneName(b[boneNameIndex]);
                bone.setParentBoneId(Integer.parseInt(b[parentBoneIdIndex]));

                result.add(bone);
            }
        }
    }
    /**
     * Sets the data in result that define the bone positions. NOTE: Should be
     * fired AFTER getBonePositions!
     *
     * @param data Bone position data
     */
    private void setBonePositions(final List<String> data) {
        /** if result is null do nothing **/
        if (result != null) {
            for (String s : data) {
                String[] b = s.split("\\s");
                if (b.length != VALID_BONEPOSITION_LENGTH) {
                    Logger.getLogger(SMDBoneProcessor.class.getName())
                            .log(Level.SEVERE,
                            "Invalid length for bone positions data");
                    this.result = null;
                    break;
                }
                int boneid = Integer.parseInt(b[BONE_ID]);

                Double boneXpos = Double.parseDouble(b[POSITION_X]);
                Double boneYpos = Double.parseDouble(b[POSITION_Y]);
                Double boneZpos = Double.parseDouble(b[POSITION_Z]);
                Double boneXNormpos = Double.parseDouble(b[NORM_X]);
                Double boneYNormpos = Double.parseDouble(b[NORM_Y]);
                Double boneZNormpos = Double.parseDouble(b[NORM_Z]);

                for (CCBone bone : result) {
                    if (bone.getBoneId() == boneid) {
                        bone.setPosX(boneXpos);
                        bone.setPosY(boneYpos);
                        bone.setPosZ(boneZpos);

                        bone.setNormX(boneXNormpos);
                        bone.setNormY(boneYNormpos);
                        bone.setNormZ(boneZNormpos);
                    }
                }

            }
        }
    }

    /**
     * Returns the result, a list of bones with all the properties defined or
     * returns null if data was invalid.
     * @return List of bones with all the properties defined
     * otherwise returns null if data was invalid
     */
    public ArrayList<CCBone> getResult() {
        return this.result;
    }

    /**
     * Methods that will be executed when this method is fired.
     */
    @Override
    public void run() {
        setBoneStructure(bonePositionData);
        setBonePositions(bonePositionData);
    }
}
