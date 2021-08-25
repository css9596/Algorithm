package JupiterNotebook;

public class MyHashLinearProbing {
    /*
    * 빈번한 충돌을 개선하는 법
    * 해쉬 테이블 저장공간을 확대 및 해쉬 함수 재정를 하자!
    * Ex1)
    * String name = "ChoiSungSik";
    * int key = 0;
    * for(int i = 0; i < name.length(); i++){
    *   key += name.charAt(i);
    * }
    *
    * System.out.println((int)(key) % 200);
    * */
    /**
     * Linear Probing 기법
     * 폐쇄 해슁 또는 Close Hashing 기법 중 하나로 해쉬 테이블 저장공간 안에서
     * 충돌 문제를 해결하는 기법이다.
     * 충돌이 일어나면, 해당 Hash Address의 다음 Address 부터 맨 처음 나오는
     * 빈 공간에 저장하는 기법이다.
     * */
    public Slot[] hashTable;

    public MyHashLinearProbing(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            if(this.hashTable[address].key == key){
                this.hashTable[address].value = value;
                return true;
            }else{
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null){
                    if(this.hashTable[currAddress].key == key){
                        this.hashTable[currAddress].value = value;
                        return true;
                    }else{
                        currAddress++;
                        if(currAddress >= this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        }else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            if(this.hashTable[address].key == key){
                return this.hashTable[address].value;
            }else{
                Integer currAddress = address + 1;
                while(this.hashTable[address]!=null){
                    if(this.hashTable[currAddress].key == key){
                        return this.hashTable[currAddress].value;
                    }else{
                        currAddress++;
                        if(currAddress>=this.hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashLinearProbing test = new MyHashLinearProbing(20);
        test.saveData("ChoiSungSik", "01012345678");
        test.saveData("ChoSungSik", "01012345678");
        test.saveData("ChiSungSik", "01012345678");
        test.saveData("CiSungSik", "01012345678");
        test.saveData("CSungSik", "01012345678");
        test.saveData("hoiSungSik", "01012345678");

        System.out.println(test.getData("hoiSungSik"));

    }

}
