package com.spilnasprava.entity.postgresql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create entity for table area with PostgreSQL DB.
 */
@Entity
@Table(name = "area")
public class Area implements Serializable {
    private long id;
    private byte area;
    private AreaKey areaKeys;

    /**
     * @return current id the area
     */
    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    /**
     * Sets the id the area
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return current area the area
     */
    public byte getArea() {
        return area;
    }

    /**
     * Sets the area the area
     *
     * @param area
     */
    public void setArea(byte area) {
        this.area = area;
    }

    /**
     * @return current area_id the area
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    public AreaKey getAreaKeys() {
        return areaKeys;
    }

    /**
     * Sets the area_id the area
     *
     * @param areaKeys
     */
    public void setAreaKeys(AreaKey areaKeys) {
        this.areaKeys = areaKeys;
    }
}
