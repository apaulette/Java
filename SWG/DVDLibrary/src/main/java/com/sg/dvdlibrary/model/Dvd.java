package com.sg.dvdlibrary.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Dvd implements Comparable<Dvd> {
    private int libId;

    @NotEmpty(message="Please enter a DVD title")
    @Length(max=80,message="DVD Title may not exceed 80 characters")
    private String title;
    
    private String ratingUS;
    
    @Length(max=4,message="Release Year may not exceed 4 characters")
    private String releaseDate;
    
    @Length(max=50,message="Director Name may not exceed 50 characters")
    private String directorName;
    
    @Length(max=50,message="Studio Name may not exceed 50 characters")
    private String studioName;
    
    private int userRating;
    
    @Length(max=200,message="User Comment may not exceed 200 characters")
    private String userComment;
    
    @Length(max=50,message="Cover Art may not exceed 50 characters")
    private String coverArt;
    
    
    
    public int getLibId() {
        return libId;
    }
    public void setLibId(int libId) {
        this.libId = libId;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getRatingUS() {
        return ratingUS;
    }
    public void setRatingUS(String ratingUS) {
        this.ratingUS = ratingUS;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudioName() {
        return studioName;
    }
    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public int getUserRating() {
        return userRating;
    }
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserComment() {
        return userComment;
    }
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
    
    public String getCoverArt() {
        return coverArt;
    }
    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.libId;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.ratingUS);
        hash = 37 * hash + Objects.hashCode(this.releaseDate);
        hash = 37 * hash + Objects.hashCode(this.directorName);
        hash = 37 * hash + Objects.hashCode(this.studioName);
        hash = 37 * hash + Objects.hashCode(this.userRating);
        hash = 37 * hash + Objects.hashCode(this.userComment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (this.libId != other.libId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.ratingUS, other.ratingUS)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.studioName, other.studioName)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        if (!Objects.equals(this.userComment, other.userComment)) {
            return false;
        }
        if (!Objects.equals(this.coverArt, other.coverArt)) {
            return false;
        }

        return true;
    }
    
    @Override
    public int compareTo(Dvd o) {
        String thisComparator, oComparator;
        thisComparator = this.title + this.releaseDate;
        oComparator = o.title+o.releaseDate;
        
        return thisComparator.compareToIgnoreCase(oComparator); 
    }

}
