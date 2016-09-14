package experiment.model;


import experiment.model.experiment.setup.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DBTest {


    @Test
    public void demoExperiment() {

        String userName = "sandeep";

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User(userName, "Narcissistic Guy", new Date());

        session.save(user);
        session.getTransaction().commit();

        List list = session.createCriteria(User.class).add(Restrictions.eq("username", userName)).list();

        assertNotNull(list);
        assertEquals(userName, ((User)list.get(0)).getUsername());
    }

    @Test
    public void demoExperimentAnnotation() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        AnnotatedUser user = new AnnotatedUser("testUser", "testUser@testUser.com");
        session.save(user);

        session.getTransaction().commit();

        List list = session.createCriteria(AnnotatedUser.class).add(Restrictions.eq("userName", "testUser")).list();
        assertNotNull(list);
        assertEquals("testUser", ((AnnotatedUser)list.get(0)).getUserName());
    }

    @Test
    public void yourExperimentHere() {

        // Go Crazy
    }
}
