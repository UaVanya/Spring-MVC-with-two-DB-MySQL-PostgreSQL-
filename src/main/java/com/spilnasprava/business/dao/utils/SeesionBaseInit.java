package com.spilnasprava.business.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Creates a SessionFactory
 */
public class SeesionBaseInit {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactoryPostgreSQL")
    private SessionFactory sessionFactoryPost;

    /**
     * @return Session
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * @return Session
     */
    public Session getSessionPost() {
        return sessionFactoryPost.getCurrentSession();
    }
}
