package application;

import java.util.Scanner;

public class TestSimpleList  extends Exercise{
    public TestSimpleList(Scanner scanner){
        super(scanner);
    }
    @Override
    protected void exerciseLogic() {

        System.out.println("1 - SimpleArrayList");
        System.out.println("2 - SimpleLinkedList");

        String op = scanner.nextLine();

        listModule.SimpleList<Integer> list;

        if (op.equals("1")) {
            list = new listModule.SimpleArrayList<>();
        } else if (op.equals("2")) {
            list = new listModule.SimpleLinkedList<>();
        } else{stop();return;}

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Original List:");
        print(list);

        list.add(1, 99);
        System.out.println("Insert 99 in index 1:");
        print(list);

        list.remove(1);
        System.out.println("Remove index 1:");
        print(list);

        list.set(1, 50);
        System.out.println("Set index 1 a 50:");
        print(list);

        list.remove((Integer)50);
        System.out.println("Remove element 50:");
        print(list);

        list.clear();
        System.out.println("Clear:");
        print(list);

        stop();
    }

    private void print(listModule.SimpleList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
