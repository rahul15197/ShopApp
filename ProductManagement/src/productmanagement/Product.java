/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Objects;
import static productmanagement.Rating.*;

/**
 *
 * @author rahulmaheshwari
 */
public abstract class Product implements Rateable<Product>,Serializable {

    private int id;
    private String name;
    private BigDecimal price;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private Rating rating;

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * Calculates discount based on discount rate
     *
     *
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    @Override
    public Rating getRating() {
        return rating;
    }

    /**
     * public abstract Product applyRating(Rating newRating);{ return new
     * Product(this.id, this.name, this.price, newRating);
    }*
     */
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating.getStars();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Product) {
            final Product other = (Product) obj;
            return this.id == other.id;// && Objects.equals(this.name, other.name);
        }

        return false;
    }

}
