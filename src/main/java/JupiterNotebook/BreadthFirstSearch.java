package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BreadthFirstSearch {
    /**
     * 너비 우선 탐색(Breadth-Frist Search)
     * 정점(Vertex)들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색하는 방식
     * HashMap, ArrayList로 구현 가능
     * 시간 복잡도
     *  노드 수 : V
     *  간선 수 : E
     *  O(V + E)
     * */

    public static void main(String[] arags){
        BreadthFirstSearch test = new BreadthFirstSearch();
        //test.bfsTest();

        HashMap<String, ArrayList<String >> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A","G","H","I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        System.out.println(test.bfsFunc(graph, "A"));
    }

    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode){
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);

        while (needVisit.size() > 0){
            String node = needVisit.remove(0);

            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public void bfsTest(){
        // 기본 선언 HashMap<키타입, 값타입> 변수 = new HashMap<키타입, 값타입>();
        HashMap<String, Integer> mapData1 = new HashMap<String, Integer>();
        HashMap<String, Integer> mapData2 = new HashMap<>(mapData1);
        HashMap<String, Integer> mapData3 = new HashMap<>(10);
        HashMap<String, ArrayList<String>> mapData4 = new HashMap<String,ArrayList<String>>();

        // HashMap 데이터 추가
        mapData1.put("A", 1);
        mapData1.put("B", 2);

        // HashMap 데이터 읽기
        System.out.println(mapData1);
        System.out.println(mapData1.get("A"));

        // HashMap 데이터 수정
        mapData1.put("B", 3);
        System.out.println(mapData1);

        // HashMap 데이터 삭제
        mapData1.remove("A");
        System.out.println(mapData1);
    }








}
