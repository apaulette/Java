/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
@Controller
public class HomeController {
    
    private DvdLibraryDao dao;
    
    @Inject
    public HomeController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
    // Display index page
    @RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
    public String displayHome(Model model) {
        if (dao.retrieveSortedEntries().isEmpty()) {
            dao.loadAllEntries();
        }
        List<Dvd> allEntries = dao.retrieveSortedEntries();
        model.addAttribute("allEntries", allEntries);
        return "index";
    }
    
    
// C - Create a new DVD
    @RequestMapping(value = "/addDvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Dvd createEntry(@Valid @RequestBody Dvd dvd, HttpServletResponse response) {
        if (!dvd.getTitle().equals(".")) {
            dao.addEntry(dvd);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return dvd;
    }    
    
// R - Retrieve ALL DVDs (GET)
    @RequestMapping(value="/alldvds", method=RequestMethod.GET)
    @ResponseBody
    public List<Dvd> retrieveSortedEntries(){
        return dao.retrieveSortedEntries();
    }

// R - Retrieve a single DVD (GET)
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getEntry(@PathVariable("id") int id) {
        return dao.retrieveEntryById(id);
    }
    
//  U - Update a DVD (PUT)
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEntry(@PathVariable("id") int id, @Valid @RequestBody Dvd dvd) {
        dvd.setLibId(id);
        dao.updateEntry(dvd);
    }
    
//- D - Delete a DVD (DELETE)
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable("id") int id) {
        dao.deleteEntry(id);
    }
    
}
