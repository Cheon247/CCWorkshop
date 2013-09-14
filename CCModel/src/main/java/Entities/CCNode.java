package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Class for node objects.
 * A node or else known as joint moves all vertices that are asigned
 * to this node along  with them.
 * @author Chingo
 */
@Entity
@Table(name = "ccnode")
public class CCNode implements Serializable {
    /** Unique Identifier. **/
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    public Long getId() { return this.id; }
    
    
    /** The model this node belongs to. **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ccmodel")
    private CCModel ccmodel;
    public CCModel getCCModel() { return ccmodel; }
    public void setCCModel(CCModel ccmodel) { this.ccmodel = ccmodel; }
    
    
    @OneToMany(mappedBy = "ccnode", fetch = FetchType.LAZY)
    private List<CCVertex> vertices;
    public List<CCVertex> getVertices() { return vertices; }
    public void setVertices(List<CCVertex> vertices) { this.vertices = vertices; }
    
    
    /** value of this node within a model. **/
    @Column(name = "NodeId")
    private Integer nodeId;
    public Integer getNodeId() { return this.nodeId; }
    public void setNodeId(final Integer bId) { this.nodeId = bId; }
    
    
    /** Name of the node. **/
    @Column(name = "BoneName", nullable = false)
    private String name;
    public String getNodeName() { return name; }
    public void setNodeName(final String bName) { this.name = bName; }
    
    
    /** CCNode identifier of this node its parent. **/
    @Column(name = "ParentBoneId")
    private Integer parentNodeId;
    public Integer getParentNodeId() { return this.parentNodeId; }
    public void setParentNodeId(final Integer pbId) { this.parentNodeId = pbId; }
    

    /** x-position of the node. **/
    @Column(name = "PosX")
    private Double posX;
    public Double getPosX() { return this.posX; }
    public void setPosX(final Double positionX) { this.posX = positionX; }
    
    
    /** y-position of the node. **/
    @Column(name = "PosY")
    private Double posY;
    public Double getPosY() { return this.posY; }
    public void setPosY(final Double positionY) { this.posY = positionY; }
    
    
    /** z-position of the node. **/
    @Column(name = "PosZ")
    private Double posZ;
    public Double getPosZ() {return this.posZ; }
    public void setPosZ(final Double positionZ) { this.posZ = positionZ; }
    
    
    /** norm-x-position of the node. **/
    @Column(name = "NormX")
    private Double normX;
    public Double getNormX() { return this.normX; }
    public void setNormX(final Double normalX) { this.normX = normalX; }
    
    
    /** norm-y-position of the node. **/
    @Column(name = "NormY")
    private Double normY;
    public Double getNormY() { return this.normY; }
    public void setNormY(final Double normalY) { this.normY = normalY; }
    
    
    /** norm-z-position of the node. **/
    @Column(name = "Norm_z")
    private Double normZ;
    public Double getNormZ() { return this.normZ; }
    public void setNormZ(final Double normalZ) { this.normZ = normalZ; }
    

    @Override
    public final String toString() {
    String nodeInfo;
    nodeInfo = "NodeID: " + nodeId + "\tNodeName:" + name
            + "\tParentNodeID:" + parentNodeId;
        return nodeInfo;
    }
}
