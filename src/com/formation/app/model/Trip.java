package com.formation.app.model;

public class Trip {
    private Long Id;
    private Long departure;
    private Long destination;
    private Float price;


    public Trip(Long id, Long departure, Long destination, Float price) {
        this.Id = id;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }

    public Trip(Long departure, Long destination, Float price) {
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }


    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDeparture() {
        return departure;
    }

    public void setDeparture(Long departure) {
        this.departure = departure;
    }

    public Long getDestination() {
        return destination;
    }

    public void setDestination(Long destination) {
        this.destination = destination;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
