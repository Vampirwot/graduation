package com.alexander.graduation.model;

import java.time.LocalDate;

public class ResultVote{
    private Long count;
    private Long idRestaurant;
    private LocalDate date;

    public ResultVote(Long count, Long idRestaurant, LocalDate date) {
        this.count = count;
        this.idRestaurant = idRestaurant;
        this.date = date;
    }
}
