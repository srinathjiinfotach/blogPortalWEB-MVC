package ru.ildar.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil
{
    private static SessionFactory sFact = null;

    static
    {
        Configuration config = new Configuration();
        config.configure();
        ServiceRegistry registry = new ServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        sFact = config.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() { return sFact; }
}