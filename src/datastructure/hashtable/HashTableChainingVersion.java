package datastructure.hashtable;

public class HashTableChainingVersion {
    private Slot[] hashTable;

    public HashTableChainingVersion(int size) {
        this.hashTable = new Slot[size];
    }

    public boolean saveData(String key, String value){
        Integer address = hashFunc(key);
        if(hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key.equals(key)){
                    findSlot.value = value;
                    return true;
                }else{
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        }else{
            hashTable[address] = new Slot(key, value);
        }
        return true;
    }
    public int hashFunc(String key){
        return ((int)key.charAt(0)) % hashTable.length;
    }

    public String getData(String key){
        int address = hashFunc(key);
        if(hashTable[address] != null){
            Slot slot = hashTable[address];
            while(slot != null){
                if(slot.key.equals(key)){
                    return slot.value;
                }else{
                    slot = slot.next;
                }
            }
        }
        return null;
    }

    private class Slot {
        private String key;
        private String value;
        private Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        HashTableChainingVersion mainObject = new HashTableChainingVersion(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(mainObject.getData("DaveLee"));
    }
}
