package com.atyeti.collections.list.arrayList;
//Detect Cycles in a List of Dependencies
//Given a list of tasks and their dependencies (as pairs), detect if there's a cycle using ArrayList<List<Integer>>.


import java.util.*;

public class DependencyCycleDetector {
    public static boolean hasCycle(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        boolean[] recursionStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] stack) {
        if (stack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        stack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (dfs(neighbor, graph, visited, stack)) return true;
        }

        stack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 3; i++) graph.add(new ArrayList<>());
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);

        System.out.println("Has cycle: " + hasCycle(graph));
    }
}
