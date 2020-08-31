package com.alexander.graduation.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{
    private Integer price;
    private LocalDate date;

    private Long restaurantId;

    public Dish() {
    }

    public Dish(Long id, String name, Integer price, LocalDate date, Long restaurantId) {
        super(id, name);
        this.price = price;
        this.date = date;
        this.restaurantId = restaurantId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", date=" + date +
                ", restaurant=" + restaurantId +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
