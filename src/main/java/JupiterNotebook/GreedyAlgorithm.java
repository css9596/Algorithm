package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    /**
     * 탐욕 알고리즘
     *  최적의 해에 가까운 합을 구하기 위해 사용됨
     *  여러 경우 중 하나를 결정해야할 때마다, 매 순간 최적이라고 생각되는 경우를 선택하는 방식을
     *  진행해서, 최종적인 값을 구하는 방식
     * */

    public static void main(String[] args){
        GreedyAlgorithm test = new GreedyAlgorithm();
        //test.coinFunc(4720, new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1)));

        Integer[][] objectList = {{10, 10},{15, 12},{20, 10}, {25, 8}, {30, 5}};
        test.knapsackFunc(30.0, objectList);

    }

    /**
     * 동전 문제
     *  지불해야 하는 값이 4720원 일 때 1원, 50원, 100원, 500원 동전으로 동전의 수가 가장
     *  적게 지불하시오.
     *   - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현
     *   - 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택하면 됨.
     * */
    public void coinFunc(Integer price, ArrayList<Integer> coinList){
        Integer totalCoinCount = 0;
        Integer coinNum =0;
        ArrayList<Integer> details = new ArrayList<>();

        for(int index = 0; index<coinList.size(); index++){
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원: " + coinNum + " 개");
        }
        System.out.println("총 동전 갯수: " + totalCoinCount);
    }

    /**
     * 부분 배낭 문제(Fractional Knapsack Problem)
     *  무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
     *   - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
     *   - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음. 그래서 Fractional
     *     Knapsack Problem 부름
     *      - Fractional Knapsack Problem 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함
     *        (0/1 Knapsack Problem 부른다.)
     * */
    //2차원 배열로 작성하기.
    public void knapsackFunc(Double capacity, Integer[][] objectList){
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[1] / o2[0]) - (o1[1] / o1[0]);
            }
        });

        for(int index = 0; index<objectList.length; index++){
            if(capacity - (double)objectList[index][0] > 0){
                capacity -= (double)objectList[index][0];
                totalValue +=(double) objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" +
                        objectList[index][1]);
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double) objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" +
                        objectList[index][1] + ", 비율:"+fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치:" + totalValue);
    }
}
