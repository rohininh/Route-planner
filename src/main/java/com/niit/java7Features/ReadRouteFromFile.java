package com.niit.java7Features;

import java.io.*;

public class ReadRouteFromFile
{
    public int displayRecord(String fileName)
    {
        int count=0;
        try
        {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String data;
            System.out.format("%-20s %-20s %-20s %-20s %s","From City","To City","Distance in km","Travel Time","Typical Airfare");
            while((data=bufferedReader.readLine())!=null)
            {
                count++;
                String[] details=data.split(",");
                System.out.format("\n%-20s %-20s %-20s %-20s %s",details[0],details[1],details[2],details[3],details[4]);
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
        return count;
    }

    public Route[] readData(String fileName, int count)
    {
        Route[] route=new Route[count];
        int i=0;
        try
        {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String data;


            while((data=bufferedReader.readLine())!=null)
            {
                String[] details=data.split(",");
                route[i]=new Route(details[0],details[1],details[2],details[3],details[4]);
               i++;
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
        return route;
    }
}
