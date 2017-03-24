package com.sg.dvdlibrary;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DvdLibraryDaoTest {
    
    private DvdLibraryDao dao;
    
    public DvdLibraryDaoTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDaoInMem", DvdLibraryDao.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testLoadAllRetrieveSortedEntries(){
        dao.loadAllEntries();
        List<Dvd> testList = dao.retrieveSortedEntries();
        assertEquals(testList.size(), 13);
        assertEquals(testList.get(0).getTitle(), "Ant-Man");
        assertEquals(testList.get(12).getTitle(), "Thor: The Dark World");
    }
    
    @Test
    public void testAddEntry() {
        Dvd newEntry = new Dvd();
        newEntry.setTitle("The Princess Bride");
        newEntry.setReleaseDate("1987");
        newEntry.setDirectorName("Rob Reiner");
        dao.addEntry(newEntry);
        // Test that I've successfully added one DVD
        List<Dvd> testList = dao.retrieveSortedEntries();
        assertEquals(testList.size(), 1);
        assertEquals(testList.get(0).getTitle(), "The Princess Bride");
        assertEquals(testList.get(0).getDirectorName(), "Rob Reiner");
        
        Dvd newEntry1 = new Dvd();
        newEntry1.setTitle("Elf");
        newEntry1.setReleaseDate("2003");
        newEntry1.setDirectorName("Jon Favreau");
        dao.addEntry(newEntry1);
        // Test that I've successfully added a second DVD
        testList = dao.retrieveSortedEntries();
        assertEquals(testList.size(), 2);
        assertEquals(testList.get(0).getTitle(), "Elf");
        assertEquals(testList.get(1).getReleaseDate(), "1987");
        
        // And for good measure...
        Dvd retrievedEntry = dao.retrieveEntryById(newEntry.getLibId());
        Dvd retrievedEntry1 = dao.retrieveEntryById(newEntry1.getLibId());
        assertEquals(retrievedEntry, newEntry);
        assertEquals(retrievedEntry1, newEntry1);
    }
    
    @Test
    public void testDeleteEntry() {
        dao.loadAllEntries();
        // Delete one and test
        dao.deleteEntry(6);
        List<Dvd> testList = dao.retrieveSortedEntries();
        assertEquals(testList.size(), 12);
        // Delete another two and test
        dao.deleteEntry(2);
        dao.deleteEntry(9);
        testList = dao.retrieveSortedEntries();
        assertEquals(testList.size(), 10);
    }
    
    @Test
    public void testAddUpdateRetrieveEntry() {
        dao.loadAllEntries();
        Dvd newEntry = new Dvd();
        newEntry.setTitle("Office Space");
        newEntry.setReleaseDate("1999");
        dao.addEntry(newEntry);
        
        newEntry.setDirectorName("Mike Judge");
        dao.updateEntry(newEntry);
        
        Dvd retrievedEntry = dao.retrieveEntryById(newEntry.getLibId());
        assertEquals(retrievedEntry, newEntry);
    }    
    
}