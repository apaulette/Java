package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.SearchTerm;
import com.sg.dvdlibrary.model.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
@Controller
public class SearchController {
   private DvdLibraryDao dao;

    @Inject
    public SearchController(DvdLibraryDao dao) {
        this.dao = dao;
    }

    // Display search page
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "index";
    }
    
    // Search Addresses
    @RequestMapping(value = "index/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchAddresses(@RequestBody Map<String, String> searchMap, Model model) {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        
        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        currentTerm = searchMap.get("ratingUS");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RATING_US, currentTerm);
        }
        currentTerm = searchMap.get("releaseDate");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASE_DATE, currentTerm);
        }
        currentTerm = searchMap.get("directorName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTOR_NAME, currentTerm);
        }
        currentTerm = searchMap.get("studioName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STUDIO_NAME, currentTerm);
        }
        currentTerm = searchMap.get("userRating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.USER_RATING, currentTerm);
        }
        
        return dao.searchEntries(criteriaMap);
    }
    
    
}