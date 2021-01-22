package Data_Structures;

//import pck.p;

public class heap {

    private int size;

    private int maxSize;

    private int[] heap;

    private static int front = 1;

    // this is just the constructor function
    public heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;

    }

    // now lets make the function which returns the parent
    // node index

    private int parent(int pos) {
        // normally it is n-1/2 but currently we are
        // using the index method and hence use n/2

        int index = pos / 2;

        return index;

    }

    private int rightChild(int pos) {
        int index = pos * 2 + 1;
        return index;

    }

    private int leftChild(int pos) {
        int index = pos * 2;
        return index;
    }

    private void swap(int one, int two) {
        int temp = heap[one];
        heap[one] = heap[two];
        heap[two] = temp;

    }

    private boolean isLeaf(int pos) {

        if (pos >= size / 2)
            return true;
        return false;
    }

    // now one of the main function tha we re going to create is
    // Heapify()

    // code till now will be common for both Min heap nd
    // Max Heap

    // now here we will be using the property of Min Heap

    // if non leaf node is greater than its either child
    // OR
    // if either child is smaller than its parent node than
    // we will swap and recursively call the function

    private void heapify(int pos) {
        if (!isLeaf(pos)) {

            if (heap[parent(pos)] > heap[leftChild(pos)] || heap[parent(pos)] > heap[rightChild(pos)]) {

                if (heap[parent(pos)] > heap[leftChild(pos)]) {
                    swap(parent(pos), leftChild(pos));
                    heapify(leftChild(pos));
                } else {
                    swap(parent(pos), rightChild(pos));
                    heapify(rightChild(pos));
                }
            }

        }
    }

    public void insert(int element) {
        if (size >= maxSize)
            return;

        heap[++size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));

        }

    }

    public void minHeap() {
        for (int pos = (size) / 2; pos >= 1; pos--) {
            heapify(pos);
        }
    }

    public int remove() {
        int popped = heap[front];
        heap[front] = heap[size--];
        heapify(front);
        return popped;
    }

}
// function to build the min heap using the heapify()
