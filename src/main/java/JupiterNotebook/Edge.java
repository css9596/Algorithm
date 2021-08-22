package JupiterNotebook;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    // 정렬 기준 정의하기
    // 정렬을 위해서는 정렬 기준이 있어야 함
    // 객체간 정렬을 위해서는 정렬 기준을 먼저 정의해줘야 함
        /*
        Integer[] iArray = new Integer[]{1, 10, 4, 3, 2};
        Arrays.sort(iArray);
        Arrays.toString(iArray);
        */

    public Integer distans;
    public String vertex;

    public Edge(Integer distans, String vertex) {
        this.distans = distans;
        this.vertex = vertex;
    }

    /**
     * Comparable과 Comparator 인터페이스
     * - Comparable 인터페이스는 compareTo() 메서드를 override 해서 구현
     * 일반적으로 정렬할 객체에 Implements 로 Comparable 인터페이스를 추가하여 구현
     * - Comparator 인터페이스는 compare() 메서드를 override 해서 구현
     * 일반적으로는 별도 클래스를 정의해서 구현하며, 동일 객체에 다양한 정렬 기준을
     * 가진 클래스를 작성 가능
     */
    @Override
    public int compareTo(Edge e) {
        return this.distans - e.distans;
    }

    public static void main(String[] args){
        comparableTest();
        comparatorTest();
    }


    public static void comparableTest(){
        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(13, "A");
        Edge[] edges = new Edge[]{edge1, edge2, edge3};
        Arrays.sort(edges);
        for (int index = 0; index < edges.length; index++) {
            System.out.println(edges[index].distans);
        }
    }

    public static void comparatorTest(){
        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(13, "A");
        Edge[] edges = new Edge[]{edge1, edge2, edge3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                /*
                * Edge 객체에 Comparable 인터페이스가 정의되어 있다하더라도,
                * Comparator 클래스의 정렬 기준으로 정렬이 됨.
                * */

                return o2.distans - o1.distans;
            }
        });
        for (int index = 0; index < edges.length; index++) {
            System.out.println(edges[index].distans);
        }
    }
}
