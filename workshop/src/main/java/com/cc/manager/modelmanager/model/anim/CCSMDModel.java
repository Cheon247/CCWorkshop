package com.cc.manager.modelmanager.model.anim;

import com.cc.manager.modelmanager.model.core.CCBone;
import com.cc.manager.modelmanager.model.core.CCFace;
import java.util.List;

/**
 * Class CCSMDModel.
 * @author Chingo
 */
public class CCSMDModel extends AnimModel {

    /** The current frame the model is in.
     *  Default value is -1
     **/
    private Integer timeframe = -1;
    /** Model version.
     * Default value is -1
     */
    private Integer version = -1;
    /**
     * Constructor for smdModel.
     * @param fcs List of faces
     * @param bns List of bns
     */
    public CCSMDModel(final List<CCFace> fcs, final List<CCBone> bns) {
        super(fcs, bns);
    }
    /**
     * Gets the current timeFrame of this model.
     * @return the current TimeFrame the model is in
     */
    public final Integer getTimeframe() {
        return this.timeframe;
    }

    /**
     * Sets the current timeFrame of this model.
     * @param tf The timeFrame to set
     */
    public final void setTimeframe(final Integer tf) {
        this.timeframe = tf;
    }

    /**
     * Gets the version of this model.
     * @return The version of this model
     */
    public final Integer getVersion() {
        return this.version;
    }

    /**
     * Sets the version of this model.
     * @param vsn The version to set
     */
    public final void setVersion(final Integer vsn) {
        this.version = vsn;
    }
}
