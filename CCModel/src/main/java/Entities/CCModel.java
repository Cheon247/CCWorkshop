/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * CCModel class contains all the basic attributes of a model.
 * @author Chingo
 */
@Entity
@Table(name = "ccmodel")
public class CCModel implements Serializable {

    /** Unique identifier for this model. **/
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    public Long getId() { return this.id; }
    
    /**
     * The version of this model.
     * Default version = 1
     */
    @Column(name = "Version")
    private Integer version = 1;
    public Integer getVersion() { return this.version; }
    public void setVersion(final Integer v){ this.version = v; }
    
    
    /**
     * The time of this model.
     * Default time = 0
     */
    @Column(name = "ModelTime")
    private Integer time = 0;
    public Integer getTime() { return this.version; }
    public void setTime(final Integer t){ this.version = t; }
    
    
    /**
     * Nodes for this model. 
     */
    @OneToMany(targetEntity = CCNode.class, mappedBy = "ccmodel", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CCNode> nodes;
    public List<CCNode> getNodes() { return this.nodes; }
    public void setNodes(List<CCNode> nodes) { this.nodes = nodes; }
    
    
    /**
     * Triangles for this model.
     */
    @OneToMany(targetEntity = CCTriangle.class, cascade = CascadeType.ALL, mappedBy = "ccmodel",
            fetch = FetchType.LAZY)
    private List<CCTriangle> triangles;
    public List<CCTriangle> getTriangles(){ return this.triangles; }
    public void setTriangles(List<CCTriangle> triangles){ this.triangles = triangles; }
    
}
