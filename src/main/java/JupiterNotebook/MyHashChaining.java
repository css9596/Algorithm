package JupiterNotebook;

public class MyHashChaining {
    public MyHashChaining.Slot[] hashTable;

    /**Chaining기법
     * 개방해쉬 / Open Hashing 기법 중 하나: 해슁 기법 중 하로 테이블 저장공간 외
     * 공간을 활용한다.
     * 충돌이 일어날 경우 링크드리스트를 이용하여 계속하여 뒤에 연결해서 사용.
     * */
    public MyHashChaining(Integer size) {
        this.hashTable = new MyHashChaining.Slot[size];
    }

    private class Slot {
        String key;
        String value;
        Slot next; //Pointer를 지칭하기 위해 추가.
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot  = this.hashTable[address];
            Slot prevSlot  = this.hashTable[address];
            while (findSlot != null){
                if(findSlot.key == key){
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
           Slot findSlot = this.hashTable[address];
           while (findSlot != null){
               if(findSlot.key == key){
                   return findSlot.value;
               } else {
                   findSlot = findSlot.next;
               }
           }
        } else {
            return null;
        }
        return  null;
    }

    public static void main(String[] args){
        MyHashChaining test = new MyHashChaining(20);

        test.saveData("SungSikAge", "27");
        test.saveData("Ah-Ha", "165");
        test.saveData("Ok", "Choi");
        test.saveData("Ok1", "zzz");


        System.out.println(test.getData("Ok1"));
    }



}
