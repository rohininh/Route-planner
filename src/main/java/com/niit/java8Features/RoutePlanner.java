package com.niit.java8Features;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoutePlanner
{

    int k=0;
    //Read Data form the file and Display the Routes
    public List<Route> displayRecord(String fileName)
    {
        List<Route> routeList=new ArrayList<>();
        try
        {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String data;

            while((data=bufferedReader.readLine())!=null)
            {
                String[] details=data.split(",");

                routeList.add(new Route(details[0],details[1],details[2],details[3],details[4]));
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
        catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return routeList;
    }

    //Direct Flight from the Source city
    public List<Route> directFlight(List<Route> routeList, String source)
    {
        List<Route> directRoute = routeList.stream().filter(route -> route.getFrom().equalsIgnoreCase(source)).collect(Collectors.toList());
        return directRoute;
    }

    //Sort the Direct Flights from the Source city
    public List<Route> sortDirectFlights(List<Route> routeList)
    {
        Collections.sort(routeList);
        return routeList;
    }

    //Display direct and Indirect Flight from the Source City to Destination city
    public void showAllConnection(List<Route> routeList, String sourceCity, String destinationCity)
    {
        if(k==0)
        {
            System.out.println("..............Direct and Indirect Routes..................");
            List<Route> allDirectFlight=directFlight(routeList,sourceCity);
            allDirectFlight.stream().filter(route -> route.getTo().trim().equalsIgnoreCase(destinationCity)).forEach(route -> System.out.format("\n%-20s %-20s %-20s %-20s %s",
                    route.getFrom(), route.getTo(), route.getDistance(), route.getTime(), route.getAirFare()));
            k++;
        }
        for(Route route:routeList)
        {
            String temp=route.getTo().trim();
            if(route.getFrom().equalsIgnoreCase(sourceCity) && !temp.equalsIgnoreCase(destinationCity))
            {
                routeList.stream().filter(indirectRoute->indirectRoute.getFrom().equalsIgnoreCase(temp) && indirectRoute.getTo().trim().equalsIgnoreCase(destinationCity))
                        .forEach(indirectRoute -> System.out.format("\n\n%-20s %-20s %-20s %-20s %s\n%-20s %-20s %-20s %-20s %s",
                                route.getFrom(), route.getTo(), route.getDistance(), route.getTime(), route.getAirFare(),
                                indirectRoute.getFrom(), indirectRoute.getTo(), indirectRoute.getDistance(), indirectRoute.getTime(), indirectRoute.getAirFare()));

                showAllConnection(routeList,temp,destinationCity);
            }
        }
    }
}

