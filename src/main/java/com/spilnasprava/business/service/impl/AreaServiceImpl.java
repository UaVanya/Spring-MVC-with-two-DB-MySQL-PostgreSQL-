package com.spilnasprava.business.service.impl;

import com.spilnasprava.business.dao.AreaDAO;
import com.spilnasprava.business.service.AreaService;
import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDAO areaDAO;

    public List<Area> getAllArea() {
        return areaDAO.getAllArea();
    }

    public void addArea(Area area) {
        areaDAO.addArea(area);
    }
}
