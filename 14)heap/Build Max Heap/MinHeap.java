import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    MinHeap() {
        heap = new ArrayList<Integer>();
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                // swap them
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);

            }
            index = parent;
        }
    }

    public int getMin() {
        return heap.get(0);
    }

    public int pop() {
        if (heap.size() == 0) {
            return -1;
        }
        int n = heap.size();
        int max = heap.get(0);
        heap.set(0, heap.get(n - 1));
        heap.remove(n - 1);
        min_heapify(0);
        return max;
    }

    public void set(int index, int value) {
        int curr_value = heap.get(index);
        if (value > curr_value) {
            decrease_key(index, value);
        } else if (value < curr_value) {
            increase_key(index, value);
        }
    }

    // heapify_up
    private void increase_key(int index, int value) {
        heap.set(index, value);
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) > heap.get(parent)) {
                // swap them
                int temp = heap.get(parent);
                heap.set(parent, heap.get(index));
                heap.set(index, temp);
            }
            index = parent;
        }
    }

    // heapify_down
    private void decrease_key(int index, int value) {
        heap.set(index, value);
        min_heapify(index);
    }

    public void min_heapify(int i) {
        int left_child = 2 * i + 1;
        int right_child = 2 * i + 2;
        int smallest = i;
        int n = heap.size();
        if (left_child < n && heap.get(left_child) < heap.get(smallest)) {
            smallest = left_child;
        }
        if (right_child < n && heap.get(right_child) < heap.get(smallest)) {
            smallest = right_child;
        }
        if (smallest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            min_heapify(smallest);
        }
    }

    public int search(int value) {
        return recursive_search(0, value);
    }

    public int recursive_search(int index, int value) {
        if (index >= heap.size())
            return -1;
        if (value < heap.get(index)) {
            return -1;
        } else if (value == heap.get(index)) {
            return index;
        } else {
            int left = recursive_search(2 * index + 1, value);
            int right = recursive_search(2 * index + 2, value);
            if (left != -1)
                return left;
            if (right != -1)
                return right;
            return -1;
        }

    }

    public String display() {
        return heap.toString();
    }

}