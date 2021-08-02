package com.niit.java8Features;

public class Route implements Comparable<Route>
{
    private String from;
    private String to;
    private String distance;
    private String time;
    private String airFare;

    public Route(String from, String to, String distance, String time, String airFare) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.time = time;
        this.airFare = airFare;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

    public String getAirFare() {
        return airFare;
    }

    @Override
    public String toString() {
        return "Route{" +
                "From='" + from + '\'' +
                ", To='" + to + '\'' +
                ", Distance in km=" + distance +
                ", Travel Time='" + time + '\'' +
                ", Air Fare='" + airFare + '\'' +
                '}';
    }

    @Override
    public int compareTo(Route route) {
        return this.to.compareTo(route.getTo());
    }
}
