package Section8;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Michael on 11/30/2016.
 */
public class FlightPlanner extends ConsoleProgram {

    private String currentLocation;
    private ArrayList<String> route;
    private HashMap<String, ArrayList<String>> flightData;

    public void run() {
        try {
            readDataFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        welcomeUser();
        planRoute();
        displayRoute();
    }
    private void printCities() {
        for(String city : flightData.keySet()) {
            println(city);
        }
    }
    private void welcomeUser() {
        println("Welcome to Flight Planner!");
        println("Here's a list of all the cities in our database:");
        printCities();
        println("Let's plan a round-trip route!");

    }

    private void planRoute() {
        route = new ArrayList<>();
        currentLocation = null;
        getFirstCity();
        while(true) {
            getNextCity();
            if(currentLocation.equals(route.get(0))) break;
        }

    }
    private void getNextCity() {
        println("From " + currentLocation + " you can fly directly to:");
        printConnections(currentLocation);
        String nextCity = readLine("Where do you want to go from " + currentLocation + "? ");
        if(!checkForError(currentLocation, nextCity)) {
            println("There is no connecting flight to " + nextCity + ".");
            getNextCity();
        }
        route.add(nextCity);
        currentLocation = nextCity;
    }
    private boolean checkForError(String start, String end) {
        if(!flightData.get(start).contains(end)) return false;
        return true;
    }
    private void printConnections(String current) {
        flightData.get(current).forEach(this::println);
    }
    private String getFirstCity() {
        String firstCity = readLine("Enter the starting city: ");
        if(!flightData.containsKey(firstCity)) {
            System.out.println(firstCity + flightData.keySet());
            println("Please enter a city in the database.");
            firstCity = getFirstCity();
        }
        route.add(firstCity);
        currentLocation = firstCity;
        return firstCity;
    }
    private void displayRoute() {
        println("The route you've chosen is:");
        for(int i = 0; i < route.size(); i++) {
            print(route.get(i) + " ");
            if(i != route.size() - 1) print("-> ");
        }
        println("");
    }

    private void readDataFile() throws IOException {
        flightData = new HashMap<>();
        System.setIn(new FileInputStream("C:\\Users\\Michael\\IntelliJProjects\\Stanford106A\\data\\flightdata.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(in);
        while(scan.hasNext()) {
            String data = scan.nextLine();
            String[] cities = data.split("->");
            String origin = cities[0].trim();
            String destination = cities[1].trim();
            if(!flightData.containsKey(origin)) {
                flightData.put(origin, new ArrayList<>());
            }
            flightData.get(origin).add(destination);
        }
    }
}
