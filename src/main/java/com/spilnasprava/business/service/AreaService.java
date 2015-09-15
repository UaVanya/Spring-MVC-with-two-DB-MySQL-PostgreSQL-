package com.spilnasprava.business.service;

import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;

import java.util.List;

/**
 * Create Service interface to work with the Area
 */
public interface AreaService {
    List<Area> getAllArea();
    void addArea(Area area);
}
