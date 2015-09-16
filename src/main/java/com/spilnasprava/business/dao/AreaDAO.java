package com.spilnasprava.business.dao;

import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;

import java.util.List;

/**
 * Create DAO interface to work with the Area
 */
public interface AreaDAO {
    /**
     * Get list Area from database.
     *
     * @return list Area
     */
    List<Area> getAllArea();

    /**
     * Save User in DB.
     *
     * @return list User
     */
    long addArea(Area area);
}
