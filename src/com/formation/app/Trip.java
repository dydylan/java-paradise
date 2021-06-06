package com.formation.app;

public class Trip {
    private Long Id;
    private Place departure;
    private Place destination;
    private Float price;

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Place getDeparture() {
        return departure;
    }

    public void setDeparture(Place departure) {
        this.departure = departure;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
