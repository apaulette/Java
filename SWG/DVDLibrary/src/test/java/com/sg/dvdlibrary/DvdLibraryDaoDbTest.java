package com.sg.dvdlibrary;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DvdLibraryDaoDbTest {

    private DvdLibraryDao dao;

    public DvdLibraryDaoDbTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Ask Spring for my DAO
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DvdLibraryDao) ctx.getBean("dvdLibraryDao");
        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");
    }

    @After
    public void tearDown() {
    }    
    
    @Test
    public void testAddUpdateDvd() {
        Dvd newEntry = new Dvd();
        newEntry.setTitle("Office Space");
        newEntry.setRatingUS("R");
        newEntry.setUserRating(5);
        dao.addEntry(newEntry);
        
        newEntry.setDirectorName("Mike Judge");
        dao.updateEntry(newEntry);
        
        Dvd retrievedEntry = dao.retrieveEntryById(newEntry.getLibId());
        assertEquals(retrievedEntry.getTitle(), newEntry.getTitle());
        assertEquals(retrievedEntry.getDirectorName(), newEntry.getDirectorName());
        assertEquals(retrievedEntry.getRatingUS(), newEntry.getRatingUS());
        assertEquals(retrievedEntry.getUserRating(), newEntry.getUserRating());
    }
    
    @Test
    public void testAddDeleteDvd() {
        Dvd newEntry = new Dvd();
        Dvd newEntry1 = new Dvd();
        
        newEntry.setTitle("Rushmore");
        newEntry.setRatingUS("R");
        newEntry.setUserRating(5);
        newEntry.setDirectorName("Wes Anderson");
        
        newEntry1.setTitle("Office Space");
        newEntry1.setRatingUS("R");
        newEntry1.setUserRating(5);
        newEntry1.setDirectorName("Mike Judge");
        dao.addEntry(newEntry);
        dao.addEntry(newEntry1);
        
        List<Dvd> testList = dao.loadAllEntries();
        assertEquals(testList.size(), 2);
        
        dao.deleteEntry(newEntry1.getLibId());
        testList = dao.loadAllEntries();
        assertEquals(testList.size(), 1);
    }
    
}