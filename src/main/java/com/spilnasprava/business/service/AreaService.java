package com.spilnasprava.business.service;

import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;

import java.util.List;

/**
 * Create Service interface to work with the Area
 */
public interface AreaService {
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
