package datastructure.hashtable;

public class SimpleHashTable {
    private Slot[] hashtable;

    public SimpleHashTable(int size){
        hashtable = new Slot[size];
    }

    public int hashFunc(String key){
        return (int)key.charAt(0) % hashtable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = hashFunc(key);
        if(hashtable[address] != null){
            hashtable[address].value = value;
        }else{
            hashtable[address] = new Slot(value);
        }
        return true;
    }
    public String getData(String key){
        Integer address = hashFunc(key);
        if(hashtable[address] != null){
            return hashtable[address].value;
        }
        return null;
    }
    public class Slot{
        private String value;
        public Slot(String data){
            value = data;
        }
    }

    public static void main(String[] args) {
        SimpleHashTable hashTable = new SimpleHashTable(5);
        hashTable.saveData("a", "h");
        hashTable.saveData("b", "h1");
        hashTable.saveData("c", "h2");
        System.out.println(hashTable.getData("a"));
        System.out.println(hashTable.getData("b"));
        System.out.println(hashTable.getData("c"));
    }
}
