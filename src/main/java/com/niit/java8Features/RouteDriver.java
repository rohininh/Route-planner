package com.niit.java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteDriver
{
    public  static void main(String[] args) throws NoSuchFlightsAreAvalible {
        Scanner scanner=new Scanner(System.in);

        List<Route> routeList=new ArrayList<>();
        String fileName="H:\\Git Repository\\c4s7_project1-route-planner\\src\\main\\resources\\routes.csv";
        RoutePlanner routePlanner=new RoutePlanner();

        //Read File and Display Routes Details
       routeList =routePlanner.displayRecord(fileName);
        System.out.format("%-20s %-20s %-20s %-20s %s","From City","To City","Distance in km","Travel Time","Typical Airfare");
      routeList.forEach(route ->System.out.format("\n%-20s %-20s %-20s %-20s %s",route.getFrom(),route.getTo(),route.getDistance(),route.getTime(),route.getAirFare()));

      //Display Direct Flight for given city
        System.out.println("\n\nEnter the Source City : ");
        String source = scanner.next();
        System.out.println("Direct Flights from the city "+source);
        List<Route> showDirectFlights=routePlanner.directFlight(routeList,source);
        if(showDirectFlights.size()==0)
        {
            throw  new NoSuchFlightsAreAvalible("We are sorry. At this point of time, we do not have any information on flights originating from Amsterdam.");
        }
        else
         {
            showDirectFlights.forEach(routeOne -> System.out.format("\n%-20s %-20s %-20s %-20s %s", routeOne.getFrom(), routeOne.getTo(), routeOne.getDistance(), routeOne.getTime(), routeOne.getAirFare()));
         }

        //Sort Direct Flights fro there destination City
        System.out.println("\n\nSorted by Destination city of the city "+source);
        List<Route> sortDirectFlights=routePlanner.sortDirectFlights(showDirectFlights);
        sortDirectFlights.forEach(route ->System.out.format("\n%-20s %-20s %-20s %-20s %s",route.getFrom(),route.getTo(),route.getDistance(),route.getTime(),route.getAirFare()));


        //Display Direct And Indirect Flight
        System.out.println("Enter the Source City : ");
        String sourceCity=scanner.next();
        System.out.println("Enter Destination City : ");
        String destinationCity=scanner.next();

        routePlanner.showAllConnection(routeList,sourceCity,destinationCity);
    }
}
