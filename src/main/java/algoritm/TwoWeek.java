package algoritm;

import java.util.Scanner;

public class TwoWeek {
    //2주차 검색알고리즘 연습.
    //선형 검색, 이진 검색
    public static void main(String[] args) {
        TwoWeek tw = new TwoWeek();

        //선형 검색 : 배열에서 검색하는 가장 기본적인 알고리즘
        tw.returnSeqSearch();

        //이진 검색 : 정렬을 우선 수행 후 찾는 방법
        //tw.returnBinSearch();

    }

    //선형 검색
    static int seqSearch(int[]a, int n, int key){
        int i = 0;

        while (true){
            if(i == n)
                return -1;
            if(a[i] == key)
                return i;
            i++;
        }
    }

    //선형 검색
    private void returnSeqSearch(){
        //선형 검색 : 무작위로 늘여놓은 데이터 모임에서 검색을 수행.
        //이진 검색 : 일정한 규칙으로 늘어놓은 데이터 모임에서 아주 빠른 검색을 수행.
        //해시법   : 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색을 수행.
        //체인법 : 같은 해시 값의 데이터를 선형 리스트로 연결하는 방법
        //오픈 주소법 : 데이터를 위한 해시 값이 충돌할 때 재해시하는 방법..


        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();

        int[] x = new int[num];

        for(int i =0; i<num; i++){
            System.out.print("x["+i+"] : ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = seqSearch(x, num, ky);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }else{
            System.out.println(ky + "은(는) x["+idx+"]에 있습니다.");
        }
    }//-END returnSeqSearch

    //이진 검색
    private int binSearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n - 1;

        do{
            int pc = (pl + pr) / 2;
            if(a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        }while (pl <= pr);

        return -1;  //검색 실패
    }

    //이진 검색
    public void returnBinSearch(){
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = sc.nextInt();

        for(int i=1; i<num; i++){
            do{
                System.out.print("x[" + i +"] :");
                x[i] = sc.nextInt();
            }while (x[i] < x[i -1]);
        }

        System.out.print("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = binSearch(x, num, ky);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
    }

}//END TwoWeek
