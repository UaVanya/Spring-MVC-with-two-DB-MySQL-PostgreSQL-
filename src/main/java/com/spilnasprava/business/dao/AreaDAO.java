package com.spilnasprava.business.dao;

import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;

import java.util.List;

/**
 * Create DAO interface to work with the Area
 */
public interface AreaDAO {
    List<Area> getAllArea();
    void addArea(Area area);
}
