/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 *
 * @author rahulmaheshwari
 */
public final class Drink extends Product {

    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }

    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return (now.isAfter(LocalTime.of(17, 30)) && now.isBefore(LocalTime.of(18, 30))) ? super.getDiscount() : BigDecimal.ZERO;

    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Drink(getId(), getName(), getPrice(), newRating);
    }

}
