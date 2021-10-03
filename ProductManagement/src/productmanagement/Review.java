/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.io.Serializable;

/**
 *
 * @author rahulmaheshwari
 */
public class Review implements Comparable<Review>, Serializable{
    private Rating rating;
    private String comments;

    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Review{" + "rating=" + rating + ", comments=" + comments + '}';
    }

    @Override
    public int compareTo(Review other) {
        return other.rating.ordinal() - this.rating.ordinal();
    }
    
}
