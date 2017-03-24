package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import java.util.Map;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface DvdLibraryDao {
    
    // CREATE
    public Dvd addEntry(Dvd entry);
    
    // READ - Get one entry
    public Dvd retrieveEntryById(int libId);
    // READ - Get entry by name
    // public List<Dvd> retrieveEntryByName(String nameToSearch);
    // READ - Get all entries
    public List<Dvd> retrieveSortedEntries();
//    public Map<Integer, Dvd> retrieveDvdMap();
    
    // READ - Search entries by any field
    public List<Dvd> searchEntries(Map<SearchTerm,String> criteria);
    
    // UPDATE
    public void updateEntry(Dvd entry);
    
    // DELETE
    public void deleteEntry(int libId);  
    
    // Dvd entries added to allEntries
    public List<Dvd> loadAllEntries();
    
}
