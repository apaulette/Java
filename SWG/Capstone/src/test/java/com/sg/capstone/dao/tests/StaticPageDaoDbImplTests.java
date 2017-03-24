package com.sg.capstone.dao.tests;

import com.sg.capstone.dao.StaticPageDao;
import com.sg.capstone.model.StaticPage;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class StaticPageDaoDbImplTests {
    
    private StaticPageDao dao;
    StaticPage[] testStaticPages = new StaticPage[3];
    
    public StaticPageDaoDbImplTests(){
    }

    @Before
    public void setUp(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (StaticPageDao) ctx.getBean("StaticPageDao");
        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("truncate staticPage");
        
        StaticPage stpg1 = new StaticPage();
        stpg1.setTitle("About Us");
        stpg1.setStaticPageText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        stpg1.setImagePath("c1.jpg");
        stpg1.setDisplayOrder(1);
        stpg1.setIsApproved(1);
        
        StaticPage stpg2 = new StaticPage();
        stpg2.setTitle("Contact Us");
        stpg2.setStaticPageText("Sed feugiat laoreet cursus. Proin non efficitur est.");
        stpg2.setImagePath("c2.jpg");
        stpg2.setDisplayOrder(2);
        stpg2.setIsApproved(1);

        StaticPage stpg3 = new StaticPage();
        stpg3.setTitle("Promotions");
        stpg3.setStaticPageText("Vestibulum sit amet lectus rhoncus, venenatis odio vitae, rutrum nisl.");
        stpg3.setImagePath("c3.jpg");
        stpg3.setDisplayOrder(3);
        stpg3.setIsApproved(0);

        testStaticPages[0] = stpg1;
        testStaticPages[1] = stpg2;
        testStaticPages[2] = stpg3;
    }
    
    @Test
    public void testAddStaticPage(){
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        dao.addStaticPage(testStaticPages[2]);
        
        assertEquals("About Us", dao.getStaticPageById(1).getTitle());
        assertEquals("Contact Us", dao.getStaticPageById(2).getTitle());
        assertEquals("Promotions", dao.getStaticPageById(3).getTitle());

        assertEquals(1, dao.getStaticPageById(1).getDisplayOrder());
        assertEquals("c2.jpg", dao.getStaticPageById(2).getImagePath());
        assertEquals(0, dao.getStaticPageById(3).getIsApproved());
    }
    
    @Test
    public void testGetAllStaticPageLinks(){
        // Add two pages and test
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        List<StaticPage> allStaticPages = dao.getAllStaticPageLinks();
        assertEquals(2, allStaticPages.size());
        
        // Add a third page and test
        dao.addStaticPage(testStaticPages[2]);
        allStaticPages = dao.getAllStaticPageLinks();
        assertEquals(3, allStaticPages.size());
    }
    
    @Test
    public void testGetStaticPageById(){
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        dao.addStaticPage(testStaticPages[2]);
        // Retrieve the page that should have been assigned staticPageId of 2
        StaticPage retrieveFromDbId2 = dao.getStaticPageById(2);
        assertEquals(testStaticPages[1].getTitle(), retrieveFromDbId2.getTitle());
        // Retrieve the page that should have been assigned staticPageId of 3
        StaticPage retrieveFromDbId3 = dao.getStaticPageById(3);
        assertEquals(testStaticPages[2].getIsApproved(), retrieveFromDbId3.getIsApproved());
        // Retrieve the page that should have been assigned staticPageId of 1
        StaticPage retrieveFromDbId1 = dao.getStaticPageById(1);
        assertEquals(testStaticPages[0].getImagePath(), retrieveFromDbId1.getImagePath());
    }
    
    @Test
    public void testUpdateStaticPage(){
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        dao.addStaticPage(testStaticPages[2]);

        StaticPage newStpg1 = new StaticPage();
        newStpg1.setStaticPageId(1);
        newStpg1.setTitle("All About Us!");
        newStpg1.setStaticPageText("Aliquam non nisl vitae lectus mattis feugiat ut ac est.");
        newStpg1.setImagePath("space-jam.jpg");
        newStpg1.setIsApproved(1);
        newStpg1.setDisplayOrder(2);
        
        StaticPage newStpg2 = new StaticPage();
        newStpg2.setStaticPageId(2);
        newStpg2.setTitle("Locations");
        newStpg2.setStaticPageText("Pellentesque fermentum mollis enim, a gravida dui vestibulum vel.");
        newStpg2.setImagePath("bugs-bunny.jpg");
        newStpg2.setIsApproved(1);
        newStpg2.setDisplayOrder(3);
        
        StaticPage newStpg3 = new StaticPage();
        newStpg3.setStaticPageId(3);
        newStpg3.setTitle("Specials");
        newStpg3.setStaticPageText("Cras malesuada metus quis hendrerit ullamcorper.");
        newStpg3.setImagePath("michael-jordan.jpg");
        newStpg3.setIsApproved(1);
        newStpg3.setDisplayOrder(1);
        
        dao.updateStaticPage(newStpg1);
        dao.updateStaticPage(newStpg2);
        dao.updateStaticPage(newStpg3);
        
        assertEquals(newStpg1.getTitle(), dao.getStaticPageById(1).getTitle());
        assertEquals(newStpg1.getStaticPageText(), dao.getStaticPageById(1).getStaticPageText());
        
        assertEquals(newStpg2.getIsApproved(), dao.getStaticPageById(2).getIsApproved());
        assertEquals(newStpg2.getDisplayOrder(), dao.getStaticPageById(2).getDisplayOrder());
        
        assertEquals(newStpg3.getTitle(), dao.getStaticPageById(3).getTitle());
        assertEquals(newStpg3.getImagePath(), dao.getStaticPageById(3).getImagePath());
    }
    
    @Test
    public void testUpdateStaticPageDisplayOrder(){
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        dao.addStaticPage(testStaticPages[2]);
        
        StaticPage newStpg1 = new StaticPage();
        newStpg1.setStaticPageId(1);
        newStpg1.setDisplayOrder(2);
        
        StaticPage newStpg2 = new StaticPage();
        newStpg2.setStaticPageId(2);
        newStpg2.setDisplayOrder(3);
        
        StaticPage newStpg3 = new StaticPage();
        newStpg3.setStaticPageId(3);
        newStpg3.setDisplayOrder(1);
        
        dao.updateStaticPageDisplayOrder(newStpg1);
        dao.updateStaticPageDisplayOrder(newStpg2);
        dao.updateStaticPageDisplayOrder(newStpg3);
        
        assertEquals(newStpg1.getDisplayOrder(), dao.getStaticPageById(1).getDisplayOrder());
        assertEquals(newStpg2.getDisplayOrder(), dao.getStaticPageById(2).getDisplayOrder());
        assertEquals(newStpg3.getDisplayOrder(), dao.getStaticPageById(3).getDisplayOrder());
    }
    
    @Test
    public void testDeleteStaticPage() {
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[1]);
        dao.addStaticPage(testStaticPages[2]);
        // Delete staticPageId 1
        dao.deleteStaticPage(1);
        assertNull(dao.getStaticPageById(1));
        List<StaticPage> allStaticPages = dao.getAllStaticPageLinks();
        assertEquals(2, allStaticPages.size());
        // Delete staticPageId 3
        dao.deleteStaticPage(3);
        assertNull(dao.getStaticPageById(3));
        allStaticPages = dao.getAllStaticPageLinks();
        assertEquals(1, allStaticPages.size());
    }
    
    @Test
    public void testApproveAndUnapproveStaticPage() {
        dao.addStaticPage(testStaticPages[0]);
        dao.addStaticPage(testStaticPages[2]);
        
        dao.unapproveStaticPage(1);
        dao.approveStaticPage(2);
        assertEquals(0, dao.getStaticPageById(1).getIsApproved());
        assertEquals(1, dao.getStaticPageById(2).getIsApproved());
        
        dao.approveStaticPage(1);
        dao.unapproveStaticPage(2);
        assertEquals(1, dao.getStaticPageById(1).getIsApproved());
        assertEquals(0, dao.getStaticPageById(2).getIsApproved());
    }
    
}
