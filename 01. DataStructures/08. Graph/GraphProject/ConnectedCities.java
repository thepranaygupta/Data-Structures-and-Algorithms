package com.DataStructures_And_Algorithms.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class City {
    int index;
    String name;
    String code;
    LinkedList<City> connectedCity = new LinkedList<>();

    public City(int i, String name, String code) {
        index = i;
        this.name = name;
        this.code = code;
    }
}

public class GraphProject {

    int size =0;
    List<City> cities = new ArrayList<>();

    void addCity(String code, String name){
        int i = size++;
        City city = new City(i,name, code);
        cities.add(city);
    }

    City cityLookup(String code){
        for(City c:cities){
            if(c.code.equalsIgnoreCase(code)){
                return c;
            }
        }
        return null;
    }

    void connectCity(String code1, String code2){
        City c1 = cityLookup(code1);
        City c2 = cityLookup(code2);
        if( c1 == null || c2 == null){
            System.out.println("Cannot connect, Invalid city code.");
            return;
        }
        c1.connectedCity.add(c2);
    }
    
    private void findBFSpath(String code) {
        boolean[] visited = new boolean[size];
        City city = cityLookup(code);
        System.out.println("\n printing BFS path from city "+ city.name);
        LinkedList<City> linkedCity = new LinkedList<>();
        linkedCity.add(city);
        visited[city.index] = true;

        while(!linkedCity.isEmpty()){
            City currentCity = linkedCity.poll();
            System.out.println(" >> "+ currentCity.name);

            for(City cc:currentCity.connectedCity){
                if(!visited[cc.index]){
                    visited[cc.index] = true;
                    linkedCity.add(cc);
                }
            }
        }

    }

    private void findDFSpath(String code) {
        boolean[] visited = new boolean[size];
        City city = cityLookup(code);
        System.out.println("printing DFS path from city "+ city.name);
        DFS(city, visited);
    }

    private void DFS(City city, boolean[] visited) {
        visited[city.index] = true;
        for(City c :city.connectedCity){
            if(!visited[c.index]){
                DFS(c,visited);
            }
        }
        System.out.println(" >> "+city.name);
    }
    public static void main(String[] args) {
        
        GraphProject g = new GraphProject();
        
        //Adding cities
        g.addCity("LR", "Larkana");
        g.addCity("SK", "Sukkur");
        g.addCity("NW" , "Nawabshah");
        g.addCity("JM", "Jamshoro");

        //Connecting cities
        g.connectCity("LR", "SK");
        g.connectCity("SK", "NW");
        g.connectCity("NW", "JM");
        
        g.addCity("HY", "Hyderabad");
        g.addCity("KR", "Karachi");
        g.addCity("IS","Islamabad");
        g.addCity("RP", "Rawalpindi");

        g.connectCity("HY", "KR");
        g.connectCity("KR", "IS");
        g.connectCity("IS", "RP");
        
        // finding DFS path from Larkana
        g.findDFSpath("LR");
        
        // finding BFS path from Hyder 
        g.findBFSpath("HY");


    }
}