/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.manager.modelmanager.model.anim;

import com.cc.manager.modelmanager.model.core.CCBone;
import com.cc.manager.modelmanager.model.core.CCFace;
import com.cc.manager.modelmanager.model.core.CCModel;
import java.util.List;

/**
 * Class animated model for models with bones.
 *
 * @author Chingo
 */
public abstract class AnimModel extends CCModel {

    /**
     * List of bones. *
     */
    private List<CCBone> bones;

    /**
     * Constructor.
     *
     * @param fcs List of faces
     * @param bns List of bones
     *
     */
    public AnimModel(final List<CCFace> fcs, final List<CCBone> bns) {
        super(fcs);
        this.bones = bns;
    }

    /**
     * Gets the bones from this model.
     *
     * @return List of bones from this model
     */
    public final List<CCBone> getBones() {
        return this.bones;
    }

    /**
     * Adds a bone to this model. WARNING: If you want to replace a bone use
     * replace bone instead
     *
     * @param b The bone to add to this model
     * @throws Exception if model already has bone
     */
    public final void addBone(final CCBone b) throws Exception {
        if (hasBoneWithBoneId(b.getBoneId())
                || hasBoneWithName(b.getBoneName())) {
            throw new Exception("Already has bone with this name of id"
                    + ", use replaceBone() instead");
        } else {
            this.bones.add(b);
        }
    }

    /**
     * Gets the bone by its BoneId. WARNING: Do not confuse BoneId with the bone
     * its UNIQUE identifier id
     *
     * @param boneId The bone its id
     * @return The bone with the boneId
     */
    public final CCBone getBoneById(final Integer boneId) {
        CCBone bone = null;
        for (CCBone b : bones) {
            if (b.getBoneId() == boneId) {
                bone = b;
            }
        }
        return bone;
    }

    /**
     * Gets the bone by boneName.
     *
     * @param boneName the Name of the bone to get
     * @return The bone with the BoneName
     */
    public final CCBone getBoneByName(final String boneName) {
        CCBone bone = null;
        for (CCBone b : bones) {
            if (b.getBoneName().equals(boneName)) {
                return b;
            }
        }
        return bone;
    }

    /**
     * Sets the bones of this model.
     *
     * @param bns List of bones to set
     */
    public final void setBones(final List<CCBone> bns) {
        this.bones = bns;
    }

    /**
     * Checks if this model already has a Bone with this boneId.
     *
     * @param boneId The boneId of this model
     * @return true if model already has bone with this id
     */
    public final Boolean hasBoneWithBoneId(final Integer boneId) {
        Boolean hasBoneWithId = false;
        for (CCBone b : this.bones) {
            if (b.getBoneId() == boneId) {
                hasBoneWithId = true;
                break;
            }
        }
        return hasBoneWithId;
    }

    /**
     * Checks if this model alread has a bone with this name.
     *
     * @param boneName The bone name to do apply the check on
     * @return true if model has bone with this boneName
     */
    public final Boolean hasBoneWithName(final String boneName) {
        Boolean hasBone = false;
        for (CCBone bone : this.bones) {
            if (bone.getBoneName().equals(boneName)) {
                hasBone = true;
                break;
            }
        }
        return hasBone;
    }

    /**
     * Replaces a certain bone if exists.
     * @param bone The bone that needs to be replaced
     */
    public final void replaceBone(final CCBone bone) {
        if (this.hasBoneWithBoneId(bone.getBoneId())
                || this.hasBoneWithName(bone.getBoneName())) {
            for (CCBone b : this.bones) {
                if (b.equals(bone)) {
                    b = bone;
                }
            }
        }
    }
}
