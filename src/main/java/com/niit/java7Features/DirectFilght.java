package com.niit.java7Features;

public class DirectFilght
{
    int k=0;
    //Display All Direct flights from the city
    public Route[] showDirectFlights(Route[] route, String fromCity)
    {
        Route[] directFlight;
        int j=0;
        int count=0;
        for (int i=0;i<route.length;i++)
        {
            if(fromCity.equals(route[i].getFrom()))
            {
                count++;
            }
        }
        directFlight=new Route[count];
            for (int i=0;i<route.length;i++)
            {
                if(fromCity.equals(route[i].getFrom()))
                {
                    directFlight[j]=route[i];
                    j++;
                }
            }
            return directFlight;
    }

    //Sort routes according to destination city for the all direct routes
    public Route[] sortDirectFlights(Route directFlights[])
    {
        for (int i=0;i<directFlights.length;i++)
        {
            for(int j=0;j<directFlights.length-1-i;j++)
            {
                String firstWord=directFlights[j].getTo();
                String secondWord=directFlights[j+1].getTo();
                int compare=firstWord.compareToIgnoreCase(secondWord);
                if(compare>0)
                {
                    Route temp=directFlights[j];
                    directFlights[j]=directFlights[j+1];
                    directFlights[j+1]=temp;
                }
            }
        }
        return directFlights;
    }

    //Display all direct and Indirect Flights as per the source city and destination city
    public void showAllConnection(Route[] routes, String fromCity, String toCity)
    {
        if(k==0)
        {
            Route[] allDirectFlight=showDirectFlights(routes,fromCity);
            for (Route route : allDirectFlight) {
                if (toCity.equalsIgnoreCase(route.getTo().trim())) {
                    System.out.println("\n......Direct and Indirect Flights Flights.......\n" + route.getFrom() + "\t" + route.getTo() + "\t" + route.getDistance() + "\t" + route.getTime() + "\t" + route.getAirFare());
                }
            }
            k++;
        }

        for(int i=0;i< routes.length;i++)
        {
            String temp=routes[i].getTo().trim();
            if(routes[i].getFrom().equalsIgnoreCase(fromCity) && !temp.equalsIgnoreCase(toCity))
            {
                for(int j=0;j< routes.length;j++)
                {
                    if(temp.equalsIgnoreCase(routes[j].getFrom()) && routes[j].getTo().trim().equalsIgnoreCase(toCity))
                    {
                        System.out.println("\n"+routes[i].getFrom()+"\t"+routes[i].getTo()+"\t"+routes[i].getDistance()+"\t"+routes[i].getTime()+
                               "\t"+routes[i].getAirFare());
                        System.out.println(routes[j].getFrom()+"\t"+routes[j].getTo()+"\t"+routes[j].getDistance()+"\t"+routes[j].getTime()+"\t"+routes[j].getAirFare());
                        showAllConnection(routes,temp,toCity);
                    }
                }
            }
        }
    }
}
