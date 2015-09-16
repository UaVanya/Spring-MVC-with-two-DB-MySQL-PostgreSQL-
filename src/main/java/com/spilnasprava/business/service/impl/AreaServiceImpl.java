package com.spilnasprava.business.service.impl;

import com.spilnasprava.business.dao.AreaDAO;
import com.spilnasprava.business.service.AreaService;
import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implements interface Service @see com.spilnasprava.business.service.AreaService
 */
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDAO areaDAO;

    /**
     * Get list Area from database.
     *
     * @return list Area
     */
    public List<Area> getAllArea() {
        return areaDAO.getAllArea();
    }

    /**
     * Save User in DB.
     *
     * @return list User
     */
    public long addArea(Area area) {
        return areaDAO.addArea(area);
    }
}
