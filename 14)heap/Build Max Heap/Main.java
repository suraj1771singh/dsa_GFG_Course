public class Main {
    public static void main(String[] args) {
        // MAX HEAP
        System.out.println("--------------MAX HEAP----------------");
        MaxHeap heap = new MaxHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(2);
        heap.insert(1);
        while (true) {
            int flag = heap.pop();
            if (flag == -1) {
                break;
            }
            System.out.print(flag + " ");
        }
        System.out.println();
        heap.insert(30);
        heap.insert(40);
        heap.insert(90);
        heap.insert(70);
        System.out.println("Max element is " + heap.getMax());
        System.out.println(heap.display());
        heap.set(0, 23);
        System.out.println("after insertion at pos 0");
        System.out.println(heap.display());
        System.out.println("index of value 40 is :" + heap.search(40));
        // MIN HEAP
        System.out.println("--------------MIN HEAP----------------");
        MinHeap heap2 = new MinHeap();
        heap2.insert(5);
        heap2.insert(3);
        heap2.insert(7);
        heap2.insert(2);
        heap2.insert(1);
        while (true) {
            int flag = heap2.pop();
            if (flag == -1) {
                break;
            }
            System.out.print(flag + " ");
        }
        System.out.println();
        heap2.insert(30);
        heap2.insert(40);
        heap2.insert(90);
        heap2.insert(70);
        System.out.println("Min element is " + heap2.getMin());
        System.out.println(heap2.display());
        heap2.set(0, 23);
        System.out.println("after insertion at pos 0");
        System.out.println(heap2.display());
        System.out.println("index of value 40 is :" + heap2.search(40));
    }

}
