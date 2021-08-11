package JupiterNotebook;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    private class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        System.out.println(address);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args){
        MyHash test = new MyHash(20);

        test.saveData("SungSikAge", "27");
        test.saveData("Ah-Ha", "165");
        test.saveData("Ok", "Choi");


        System.out.println(test.getData("Ok"));
    }


}