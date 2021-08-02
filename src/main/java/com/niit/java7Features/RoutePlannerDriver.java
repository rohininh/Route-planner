package com.niit.java7Features;

import java.util.Scanner;

public class RoutePlannerDriver
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String fileName="H:\\Git Repository\\c4s7_project1-route-planner\\src\\main\\resources\\routes.csv";
            ReadRouteFromFile route=new ReadRouteFromFile();

            //read file and display details of route of the flight
            int count=route.displayRecord(fileName);
            Route[] routes=route.readData(fileName,count);


        System.out.println("\n\nEnter From city to check available  Direct Flights to destination city : ");
        String fromCity=scanner.next();

            DirectFilght directFilght=new DirectFilght();

            //Direct Flight method to display direct route from the given source city
            Route[] directFlight=directFilght.showDirectFlights(routes,fromCity);
            System.out.println("Direct Flights from the city "+fromCity);
                if(directFlight.length==0)
                {
                    System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from Amsterdam.");
                }
                else
                {
                    for(Route dF:directFlight)
                    {
                        System.out.format("\n%-20s %-20s %-20s %-20s %s",dF.getFrom(),dF.getTo(),dF.getDistance(),dF.getTime(),dF.getAirFare());
                    }
                }

                //Sort the array of Route by destination and display
            Route[] sortedByDestination=directFilght.sortDirectFlights(directFlight);
             System.out.println("\n\nSorted by Destination city... From the city "+fromCity);
                for (Route sortedList:sortedByDestination)
                {
                    System.out.format("\n%-20s %-20s %-20s %-20s %s",sortedList.getFrom(),sortedList.getTo(),sortedList.getDistance(),sortedList.getTime(),sortedList.getAirFare());
                }


        System.out.println("\n\nEnter Source City : ");
        String source=scanner.next();
        System.out.println("Enter Destination City : ");
        String destination=scanner.next();

        directFilght.showAllConnection(routes, source,destination);
    }
}
