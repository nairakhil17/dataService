package com.springapp.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

/**
 * Created by akhil on 5/7/16.
 */
public class GenericDaoHibernate<T,PK extends Serializable> implements GenericDao<T,PK> {

    private Class<T> persitenceClass;
    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;

    public GenericDaoHibernate(Class<T> persitenceClass) {
        this.persitenceClass = persitenceClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<T> getAll() {
        return hibernateTemplate.loadAll(persitenceClass);
    }

    @Override
    public T get(PK id) {
        return hibernateTemplate.get(this.persitenceClass,id);
    }

    @Override
    public T save(T object) {
        return hibernateTemplate.merge(object);
    }

    @Override
    public void remove(PK id) {
        hibernateTemplate.delete(this.get(id));
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
