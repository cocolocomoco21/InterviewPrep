import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        Item item1 = new Item("coffee", 3);
        Item item2 = new Item("milk", 4);
        Item item3 = new Item("bread", 5);
//        System.out.println(solution.view()); // coffee
        Item item4 = new Item("candy", 1);
//        System.out.println(solution.view()); // coffee
//        System.out.println(solution.view()); // milk
        Item item5 = new Item("stick", 5);
        Item item6 = new Item("string", 5);

        Queue<Item> maxHeap = new PriorityQueue<Item>((o1, o2) ->
                o1.getItemCost() < o2.getItemCost()
                        ? 1
                        : o1.getItemCost() > o2.getItemCost()
                            ? -1
                            : o1.getItemName().compareTo(o2.getItemName()));

        maxHeap.add(item1);
        maxHeap.add(item2);
        maxHeap.add(item3);
        maxHeap.add(item4);
        maxHeap.add(item5);
        maxHeap.add(item6);

        System.out.println(maxHeap.poll().getItemName());
        System.out.println(maxHeap.poll().getItemName());
        System.out.println(maxHeap.poll().getItemName());
        System.out.println(maxHeap.poll().getItemName());
        System.out.println(maxHeap.poll().getItemName());
        System.out.println(maxHeap.poll().getItemName());


    }
}


class Item {
    private String itemName;
    private int itemCost;

    public Item(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public int getItemCost() {
        return itemCost;
    }

    public String getItemName() {
        return itemName;
    }
}