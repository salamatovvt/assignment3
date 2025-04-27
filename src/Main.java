import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();


        Random rand = new Random();


        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            String name = "Name" + rand.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, "Value" + i);
        }


        System.out.println("Number of elements in each bucket:");
        for (int i = 0; i < table.getChainArrayLength(); i++) {
            int count = 0;
            var head = table.getChainArrayNode(i);
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
