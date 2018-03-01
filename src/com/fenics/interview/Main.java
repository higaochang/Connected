package com.fenics.interview;

import sun.lwawt.macosx.CImage;

public class Main {

    public static void main(String[] args) {
	    // write your code here

    }

    public static void test(){
        CityGraph<City> graph = CityGraph.newInstance();
        graph.addEdge(new City("Philadelphia"), new City("Pittsburgh"));
        graph.addEdge(new City("Boston"), new City("New York"));
        graph.addEdge(new City("Philadelphia"), new City("New York"));
        graph.addEdge(new City("Los Angeles"), new City("San Diego"));
        graph.addEdge(new City("New York"), new City("Croton-Harmon"));

        System.out.println(graph.isConnected(new City("Boston"), new City("Pittsburgh")));
    }
}
