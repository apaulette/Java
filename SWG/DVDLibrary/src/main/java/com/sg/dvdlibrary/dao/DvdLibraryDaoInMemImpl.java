package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DvdLibraryDaoInMemImpl implements DvdLibraryDao {
    
    private Map<Integer, Dvd> dvdMap = new HashMap<>();
    private List<Dvd> allEntries;
    private static int libIdGen = 0;
    
    
    // C - CREATE
    @Override
    public Dvd addEntry(Dvd entry) {
        entry.setLibId(libIdGen);
        libIdGen++;
        dvdMap.put(entry.getLibId(), entry);
        return entry;
    }
    // R - READ
    @Override
    public List<Dvd> retrieveSortedEntries() {
        allEntries = new ArrayList<>(dvdMap.values());
        Collections.sort(allEntries);
        return allEntries;
    }
    // R - READ
    @Override
    public Dvd retrieveEntryById(int libId) {
        return dvdMap.get(libId);
    }
    // U - UPDATE
    @Override
    public void updateEntry(Dvd entry) {
        dvdMap.put(entry.getLibId(), entry);
    }
    // D - DELETE
    @Override
    public void deleteEntry(int libId) {
        dvdMap.remove(libId);
    }
    
    @Override
    public List<Dvd> searchEntries(Map<SearchTerm, String> criteria) {
        // Get all the things we're searching for into individual variables
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String ratingUSCriteria = criteria.get(SearchTerm.RATING_US);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String directorNameCriteria = criteria.get(SearchTerm.DIRECTOR_NAME);
        String studioNameCriteria = criteria.get(SearchTerm.STUDIO_NAME);
        String userRatingCriteria = criteria.get(SearchTerm.USER_RATING);
        // Declare predicate conditions - to be used by our filters
        Predicate<Dvd> titleMatches;
        Predicate<Dvd> ratingUSMatches;
        Predicate<Dvd> releaseDateMatches;
        Predicate<Dvd> directorNameMatches;
        Predicate<Dvd> studioNameMatches;
        Predicate<Dvd> userRatingMatches;
        // Default predicate
        Predicate<Dvd> truePredicate = (dp) -> {return true; };
        // Assign values to predicates
        // If a given search term is empty, assign the default Predicate
        // Otherwise, assign the predicate that filters for that term
        
        // ? expression = ternary expression
        // boolean expression ? true value : false value
        // (Do we have nothing in first name criteria?  Use default : Filter on firstNameCriteria
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> dp.getTitle().contains(titleCriteria);
        ratingUSMatches = (ratingUSCriteria == null || ratingUSCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> dp.getRatingUS().equalsIgnoreCase(ratingUSCriteria);
        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> dp.getReleaseDate().equalsIgnoreCase(releaseDateCriteria);
        directorNameMatches = (directorNameCriteria == null || directorNameCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> dp.getDirectorName().contains(directorNameCriteria);
        studioNameMatches = (studioNameCriteria == null || studioNameCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> dp.getStudioName().contains(studioNameCriteria);
        userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty()) ?
                truePredicate
                : (dp) -> String.valueOf(dp.getUserRating()).equals(userRatingCriteria);

        return dvdMap.values().stream()
                .filter(titleMatches
                .and(ratingUSMatches)
                .and(releaseDateMatches)
                .and(directorNameMatches)
                .and(studioNameMatches)
                .and(userRatingMatches))
                .collect(Collectors.toList());
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="public void loadAllEntries()">
    @Override
    public List<Dvd> loadAllEntries() {
        Dvd dvd01 = new Dvd();
        dvd01.setTitle("Iron Man");
        dvd01.setRatingUS("PG-13");
        dvd01.setReleaseDate("2008");
        dvd01.setDirectorName("Jon Favreau");
        dvd01.setStudioName("Marvel Studios");
        dvd01.setCoverArt("iron-man.jpg");
        dvd01.setUserRating(0);
        addEntry(dvd01);

        Dvd dvd02 = new Dvd();
        dvd02.setTitle("The Incredible Hulk");
        dvd02.setRatingUS("PG-13");
        dvd02.setReleaseDate("2008");
        dvd02.setDirectorName("Louis Leterrier");
        dvd02.setStudioName("Marvel Studios");
        dvd02.setCoverArt("the-incredible-hulk.jpg");
        dvd02.setUserRating(0);
        addEntry(dvd02);

        Dvd dvd03 = new Dvd();
        dvd03.setTitle("Iron Man 2");
        dvd03.setRatingUS("PG-13");
        dvd03.setReleaseDate("2010");
        dvd03.setDirectorName("Jon Favreau");
        dvd03.setStudioName("Marvel Studios");
        dvd03.setCoverArt("iron-man-2.jpg");
        dvd03.setUserRating(0);
        addEntry(dvd03);

        Dvd dvd04 = new Dvd();
        dvd04.setTitle("Thor");
        dvd04.setRatingUS("PG-13");
        dvd04.setReleaseDate("2011");
        dvd04.setDirectorName("Kenneth Branagh");
        dvd04.setStudioName("Marvel Studios");
        dvd04.setCoverArt("thor.jpg");
        dvd04.setUserRating(0);
        addEntry(dvd04);

        Dvd dvd05 = new Dvd();
        dvd05.setTitle("Captain America: The First Avenger");
        dvd05.setRatingUS("PG-13");
        dvd05.setReleaseDate("2011");
        dvd05.setDirectorName("Joe Johnston");
        dvd05.setStudioName("Marvel Studios");
        dvd05.setCoverArt("captain-america-first-avenger.jpg");
        dvd05.setUserRating(0);
        addEntry(dvd05);

        Dvd dvd06 = new Dvd();
        dvd06.setTitle("Marvel's The Avengers");
        dvd06.setRatingUS("PG-13");
        dvd06.setReleaseDate("2012");
        dvd06.setDirectorName("Joss Whedon");
        dvd06.setStudioName("Marvel Studios");
        dvd06.setCoverArt("marvels-the-avengers.jpg");
        dvd06.setUserRating(0);
        addEntry(dvd06);

        Dvd dvd07 = new Dvd();
        dvd07.setTitle("Iron Man 3");
        dvd07.setRatingUS("PG-13");
        dvd07.setReleaseDate("2013");
        dvd07.setDirectorName("Shane Black");
        dvd07.setStudioName("Marvel Studios");
        dvd07.setCoverArt("iron-man-3.jpg");
        dvd07.setUserRating(0);
        addEntry(dvd07);

        Dvd dvd08 = new Dvd();
        dvd08.setTitle("Thor: The Dark World");
        dvd08.setRatingUS("PG-13");
        dvd08.setReleaseDate("2013");
        dvd08.setDirectorName("Alan Taylor");
        dvd08.setStudioName("Marvel Studios");
        dvd08.setCoverArt("thor-the-dark-world.jpg");
        dvd08.setUserRating(0);
        addEntry(dvd08);

        Dvd dvd09 = new Dvd();
        dvd09.setTitle("Captain America: The Winter Soldier");
        dvd09.setRatingUS("PG-13");
        dvd09.setReleaseDate("2014");
        dvd09.setDirectorName("Anthony and Joe Russo");
        dvd09.setStudioName("Marvel Studios");
        dvd09.setCoverArt("captain-america-winter-soldier.jpg");
        dvd09.setUserRating(0);
        addEntry(dvd09);

        Dvd dvd10 = new Dvd();
        dvd10.setTitle("Guardians of the Galaxy");
        dvd10.setRatingUS("PG-13");
        dvd10.setReleaseDate("2014");
        dvd10.setDirectorName("James Gunn");
        dvd10.setStudioName("Marvel Studios");
        dvd10.setCoverArt("guardians-of-the-galaxy.jpg");
        dvd10.setUserRating(0);
        addEntry(dvd10);

        Dvd dvd11 = new Dvd();
        dvd11.setTitle("Avengers: Age of Ultron");
        dvd11.setRatingUS("PG-13");
        dvd11.setReleaseDate("2015");
        dvd11.setDirectorName("Joss Whedon");
        dvd11.setStudioName("Marvel Studios");
        dvd11.setCoverArt("avengers-age-of-ultron.jpg");
        dvd11.setUserRating(0);
        addEntry(dvd11);

        Dvd dvd12 = new Dvd();
        dvd12.setTitle("Ant-Man");
        dvd12.setRatingUS("PG-13");
        dvd12.setReleaseDate("2015");
        dvd12.setDirectorName("Peyton Reed");
        dvd12.setStudioName("Marvel Studios");
        dvd12.setCoverArt("ant-man.jpg");
        dvd12.setUserRating(5);
        addEntry(dvd12);

        Dvd dvd13 = new Dvd();
        dvd13.setTitle("Captain America: Civil War");
        dvd13.setRatingUS("PG-13");
        dvd13.setReleaseDate("2016");
        dvd13.setDirectorName("Anthony and Joe Russo");
        dvd13.setStudioName("Marvel Studios");
        dvd13.setCoverArt("captain-america-civil-war.jpg");
        dvd13.setUserRating(0);
        addEntry(dvd13);
        
        return allEntries;
    } // </editor-fold>
    
}
