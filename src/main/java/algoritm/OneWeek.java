package algoritm;

public class OneWeek {
    //기본 자료형 선언, 배열 등 기본적인거 복습개념.
    public static void main(String[] args) {
        int[] a = new int[5];

        a[1] = 37;
        a[2] = 51;
        a[4] = a[1] * 2;

        for(int i=0; i<a.length; i++){
            System.out.println("a["+i+"]="+a[i]);
        }
    }
}
