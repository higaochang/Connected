package com.fenics.interview;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        if (args.length < 3){
            System.out.println("please run the program using params as \"filename fromCity toCity\"");
            return;
        }

        CityGraph<City> graph = CityGraph.newInstance();

        String fileName = args[0];
        String line = null;
        try {
            FileReader fileReader = new FileReader("./" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                graph.addEdge(new City(arr[0].trim()), new City(arr[1].trim()));
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        if (graph.isConnected(new City(args[1]), new City(args[2]))){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }


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
