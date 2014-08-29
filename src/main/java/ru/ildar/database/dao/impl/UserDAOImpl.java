package ru.ildar.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.ildar.database.HibernateUtil;
import ru.ildar.database.dao.UserDAO;
import ru.ildar.entities.User;
import ru.ildar.entities.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO
{
    @Override
    public boolean userExists(String name, String password)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User)session.createCriteria(User.class)
                    .add(Restrictions.eq("name", name)).add(Restrictions.eq("password", password))
                    .uniqueResult();
            session.getTransaction().commit();
            return user != null;
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void addUser(User user, UserDetails details)
    {
        if(details.getUser() == null)
            details.setUser(user);

        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(details);
            session.getTransaction().commit();
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public User getUser(int id)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User)session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }
}
