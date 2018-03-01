package com.fenics.interview;

import java.util.*;

public class CityGraph<C extends City> {
    private HashMap<C, Set<C>> adjList;

    private CityGraph() {
        this.adjList = new HashMap<>();
    }

    public static CityGraph newInstance(){
        return new CityGraph();
    }

    /**
     * add a city into graph, if already exits then ignore it.
     * @param c
     */
    private void addCity(C c){
        if (this.adjList.containsKey(c)){
//            System.out.println("already added");
            return;
        }
        this.adjList.put(c, new HashSet<>());
    }

    /**
     * is adjacent if go from c1 to c2 with one step
     * @param c1 from this city
     * @param c2 to this city
     * @return
     */
    private boolean isAdjacent(C c1, C c2){
        return this.adjList.get(c1).contains(c2);
    }

    /**
     * get all one step neighbors
     * @param from
     * @return
     */
    private Iterable<C> getNeighbors(C from){
        return this.adjList.get(from);
    }

    /**
     * add a edge form a city to another
     * @param from
     * @param to
     */
    public void addEdge(C from, C to){
        addCity(from);
        addCity(to);

        this.adjList.get(from).add(to);
        this.adjList.get(to).add(from);
    }

    /**
     * start from startCity, search destination
     * @param startCity
     * @param destination
     * @return
     */
    public boolean isConnected(C startCity, C destination){
        // do BFS to search
        final Queue<C> queue = new LinkedList<>();
        startCity.setVisited(true);
        queue.add(startCity);
        while (!queue.isEmpty()){
            C city = queue.remove();
//            System.out.println("visiting " + city.getName());
            if (this.isAdjacent(city, destination)){
                return true;
            }else {
                for (C child : getNeighbors(city)){
                    if(!child.isVisited()){
                        child.setVisited(true);
                        queue.add(child);
                    }
                }
            }
        }
        return false;
    }

}

