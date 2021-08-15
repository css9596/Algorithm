package JupiterNotebook;

public class DynamicProgramming {
    /**
     * 동적계획법
     * DP라고 많이 부르며 입력 크기가 작은 부분 문제들을 해결한 후, 해당 부분 문제의 해를
     * 활용하여 보다 큰 크기의 부분 문제를 해결, 최정적으로 전체 문제를 해결하는 알고리즘이다.
     * 상향식 접근법으로, 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서
     * 상위 문제를 풀어가는 방식.
     *
     * Memoization 기법을 활용
     *  Memoization(메모이제이션)이란?
     *      프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여
     *      다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 기술(피보나치 수열)
     *
     * */
    public int fibonacci(int n){
        int answer = 0;
        if(n==0 || n==1){
            answer = n;
        }else if(n>1){
            answer =  recursiveCallFunc(n);
        }
        return answer;
    }

    //재귀호출을 이용한 프로그래밍
    public int recursiveCallFunc(int n){
        if(n<=1){
            return n;
        }
        return recursiveCallFunc(n-1) + recursiveCallFunc(n-2);
    }

    //동적 계획법 활용.
    public int dynamiaFunc(int n){
        Integer[] cache = new Integer[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int index=2; index<n+1;index++){
            cache[index] = cache[index-1] + cache[index-2];
        }
        return cache[n];
    }

    public static void main(String[] args){
        DynamicProgramming test = new DynamicProgramming();

        System.out.println(test.fibonacci(3));
        System.out.println(test.dynamiaFunc(3));
    }

}
