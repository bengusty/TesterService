package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
    private static SessionFactory factory;

    static
    {
        try
        {
    		Configuration configuration = new Configuration().setNamingStrategy(ImprovedNamingStrategy.INSTANCE).configure();
    		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    		SessionFactory factory = configuration.buildSessionFactory(builder.build());
        }
        catch (HibernateException he)
        {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static Session getSession()
    {
		Session session = factory.openSession();
		return session;
    } 
}