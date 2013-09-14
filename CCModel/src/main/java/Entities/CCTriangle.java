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
 * Class for CCTriangle.
 *
 * @author Chingo
 */
@Entity
@Table(name = "cctriangle")
public class CCTriangle implements Serializable {
    /**
     * Unique identifier. *
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    public Long getId() { return this.id; }

    
    /**
     * The model this face belongs to.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ccmodel")
    private CCModel ccmodel;
    public final CCModel getCCModel() { return ccmodel; }
    public final void setCCModel(final CCModel m) { this.ccmodel = m; }
    


    @OneToMany(targetEntity = CCVertex.class, cascade = CascadeType.ALL,mappedBy = "cctriangle", fetch = FetchType.LAZY)
    private List<CCVertex> vertices;
    public List<CCVertex> getVertices() { return this.vertices; }
    public void setVertices(List<CCVertex> vertices){ this.vertices = vertices; }
    
    
    /**
     * Material of the triangle.
     */

    @Column(name = "Material")
    private String material;
    public String getMaterial() { return this.material; }
    public void setMaterial(String material) { this.material = material; }
    
}
