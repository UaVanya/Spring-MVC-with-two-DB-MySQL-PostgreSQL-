package com.spilnasprava.business.dao.impl;

import com.spilnasprava.business.dao.AreaDAO;
import com.spilnasprava.business.dao.utils.SeesionBaseInit;
import com.spilnasprava.entity.postgresql.Area;
import com.spilnasprava.entity.postgresql.AreaKey;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements interface DAO @see com.spilnasprava.business.dao.AreaDAO
 */
public class AreaDaoImpl extends SeesionBaseInit implements AreaDAO {

    /**
     * Get list Area from database.
     *
     * @return list Area
     */
    public List<Area> getAllArea() {
        Session session = getSessionPostgreSQL();
        List<Area> areaList = new ArrayList<Area>();
        List<Area> areas = (List<Area>) session.createCriteria(Area.class).list();
        List<AreaKey> areaKeys = (List<AreaKey>) session.createCriteria(AreaKey.class).list();
        for (AreaKey areaKey : areaKeys) {
            Area area = areaKey.getArea();
            area.setAreaKeys(areaKey);
            areaList.add(area);
        }
        return areaList;
    }

    /**
     * Save User in DB.
     *
     * @return list User
     */
    public long addArea(Area area) {
        return (Long) getSessionPostgreSQL().save(area);
    }
}
