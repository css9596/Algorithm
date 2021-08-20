package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BreadthFirstSearch {
    /**
     * 너비 우선 탐색(Breadth-Frist Search)
     * 정점(Vertex)들과 같은 레벨에 있는 노드들(형제 노드들)을 먼저 탐색하는 방식
     * HashMap, ArrayList로 구현 가능
     * */

    public static void main(String[] arags){
        BreadthFirstSearch test = new BreadthFirstSearch();
        //test.bfsTest();
        test.bfsFunc();
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

    public void bfsFunc(){
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A",new ArrayList<String>(Arrays.asList("B","C")));
        graph.put("B",new ArrayList<String>(Arrays.asList("A","D")));
        graph.put("C",new ArrayList<String>(Arrays.asList("A","G", "H", "I")));
        graph.put("D",new ArrayList<String>(Arrays.asList("B","D", "E")));
        graph.put("E",new ArrayList<String>(Arrays.asList("D")));
        graph.put("F",new ArrayList<String>(Arrays.asList("D")));
        graph.put("H",new ArrayList<String>(Arrays.asList("C")));
        graph.put("I",new ArrayList<String>(Arrays.asList("C","J")));
        graph.put("J",new ArrayList<String>(Arrays.asList("I")));

        System.out.println(graph);
    }





}
