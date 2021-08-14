package JupiterNotebook;

public class RecuresiveCall {
    /**
     * 재귀용법(재귀호출)
     * 함수안에서 함수를 호출하는 형태
     * 재귀함수는 스택 형태로 관리가 된다.
     * */
    //데이터 n의 들어왔을 때 !n의 값을 구해보기.
    public int FactorialFunc(int n){
        System.out.println("What is n??>"+n);
        if(n <= 1){
            return 1;
        }

        return n * FactorialFunc(n-1);
    }

    public static void main(String[] args){
        RecuresiveCall test = new RecuresiveCall();

        System.out.println(test.FactorialFunc(3));

    }
}
