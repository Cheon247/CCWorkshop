package Entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Class for CCVertex.
 *
 * @author Chingo
 */
@Entity
@Table(name = "ccvertex")
public class CCVertex implements Serializable {

    /** This vertex it's unique identifier. **/
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    public Long getId() { return this.id; }
    
    
    /** The face where this vertex belongs to. **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cctriangle")
    private CCTriangle cctriangle;
    public CCTriangle getCCTriangle() { return cctriangle; }
    public void setCCTriangle(final CCTriangle cctriangle) { this.cctriangle = cctriangle; }
    
    
    /** The node this vertex belongs to. **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ccnode")
    private CCNode ccnode;
    public CCNode getCCNode() { return this.ccnode; }
    public void setCCNode(final CCNode n) { this.ccnode = n; }
    
    /** x-position of the vertex. **/
    @Column(name = "Pos_x")
    private Double posX;
    public Double getPosX() { return this.posX; }
    public void setPosX(final Double positionX) { this.posX = positionX; }
    
    /**
     * y-position of the vertex. *
     */
    @Column(name = "Pos_y")
    private Double posY;
    public Double getPosY() { return this.posY; }
    public void setPosY(final Double positionY) { this.posY = positionY; }
    
    /**
     * z-position of the vertex. *
     */
    @Column(name = "Pos_z")
    private Double posZ;
    public Double getPosZ() { return this.posZ; }
    public void setPosZ(final Double positionZ) { this.posZ = positionZ; }
    
    /**
     * norm-x-position of the vertex. *
     */
    @Column(name = "Norm_x")
    private Double normX;
    public Double getNormX() { return this.normX; }
    public void setNormX(final Double normalX) { this.normX = normalX; }
    
    
    /**
     * norm-y-position of the vertex. *
     */
    @Column(name = "Norm_y")
    private Double normY;
    public Double getNormY() { return this.normY; }
    public void setNormY(final Double normalY) { this.normY = normalY; }
    
    /**
     * norm-z-position of the vertex. *
     */
    @Column(name = "Norm_z")
    private Double normZ;
    public Double getNormZ() { return this.normZ; }
    public void setNormZ(final Double normalZ) { this.normZ = normalZ; }
    
    /**
     * normal UV of the vertex. *
     */
    @Column(name = "Norm_UV")
    private Double normUV;
    public Double getNormUV() { return normUV; }
    public void setNormUV(final Double normalUV) { this.normUV = normalUV; }
    
    /**
     * normal Weight of the vertex. *
     */
    @Column(name = "Norm_Weight")
    private Double normWeight;
    public Double getNormWeight() { return normWeight; }
    public void setNormWeight(final Double normalWeight) { this.normWeight = normalWeight; }
    

    /**
     * Default Constructor.
     */
    public CCVertex() {
    }

    /**
     * Constructor that set all position values immediately.
     *
     * @param positionx The x-position to set
     * @param positiony The y-position to set
     * @param positionz The z-position to set
     * @param normalx The normal-x to set
     * @param normaly The normal-y to set
     * @param normalz The normal-z to set
     */
    public CCVertex(final Double positionx,
            final Double positiony,
            final Double positionz,
            final Double normalx,
            final Double normaly,
            final Double normalz) {
        this.posX = positionx;
        this.posY = positiony;
        this.posZ = positionz;
        this.normX = normalx;
        this.normY = normaly;
        this.normZ = normalz;
    }
}
