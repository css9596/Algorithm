package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepthFirstSearch {
    /**
     * DepthFirstSearch(깊이우선탐색)
     *  한 노드의 자식을 타고 끝까지 순회한 후 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함
     *  복잡도 계산
     *  노드 수 : V
     *  간선 수 : E
     *  while need_visit 은 V + E 번 만큼 수행하기 때문에
     *  시간 복잡도는 O(V + E)다.
     * */
    public static void main(String[] args) {
        DepthFirstSearch test = new DepthFirstSearch();
        DFSSearch test2 = new DFSSearch();

        HashMap<String, ArrayList<String>> dataList = new HashMap<>();
        dataList.put("A", new ArrayList<String>(Arrays.asList("B","C")));
        dataList.put("B", new ArrayList<String>(Arrays.asList("A","D")));
        dataList.put("C", new ArrayList<String>(Arrays.asList("A","G","H","I")));
        dataList.put("D", new ArrayList<String>(Arrays.asList("B","E","F")));
        dataList.put("E", new ArrayList<String>(Arrays.asList("D")));
        dataList.put("F", new ArrayList<String>(Arrays.asList("D")));
        dataList.put("G", new ArrayList<String>(Arrays.asList("C")));
        dataList.put("H", new ArrayList<String>(Arrays.asList("C")));
        dataList.put("I", new ArrayList<String>(Arrays.asList("C","J")));
        dataList.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(test2.dfsFunc(dataList, "A"));

        //test.DFSTest();
    }

    public void DFSTest(){
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("A");
        aList.add("B");
        String node = aList.remove(aList.size() - 1); //Stack POP()
        System.out.println(aList);
        System.out.println(node);
    }

    public static class DFSSearch{
        public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>>graph, String startNode){
            ArrayList<String> visited = new ArrayList<>();
            ArrayList<String> needVisit = new ArrayList<>();

            needVisit.add(startNode);

            while (needVisit.size() > 0)/*방문해야 할 노드가 존재하면*/{
                String node= needVisit.remove(needVisit.size() - 1);
                if(!visited.contains(node))/*해당 노드가 방문한적이 없다면*/{
                    visited.add(node);  /*방문*/
                    needVisit.addAll(graph.get(node)); /*해당 노드가 가지고 있는 자식들 추가.*/
                }
            }
            return visited;
        }
    }
}
