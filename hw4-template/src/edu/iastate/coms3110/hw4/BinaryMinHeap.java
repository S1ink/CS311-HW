package edu.iastate.coms3110.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryMinHeap<T> extends PurePriorityQueue<T> {
    private ArrayList<T> heap = new ArrayList<T>();
    private HashMap<T, Integer> location = new HashMap<T, Integer>();

    public BinaryMinHeap(Comparator<T> comp) {
        super(comp);
    }

    /**
     * 
     *
     * @return The number of elements in the heap
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Adds an element to the heap.
     *
     * @param item An element not in the heap that will be added to it.
     */
    @Override
    public void add(T item) {
        this.heap.add(item);
        int i = heap.size() - 1;
        this.location.put(item, i);
        while(i > 0)
        {
            int parent_i = (i - 1) / 2;
            T a = this.heap.get(i), b = this.heap.get(parent_i);
            if(this.comp.compare(a, b) < 0)
            {
                this.heap.set(i, b);
                this.heap.set(parent_i, a);
                this.location.put(b, i);
                this.location.put(a, parent_i);
                i = parent_i;
                continue;
            }
            break;
        }
    }

    /**
     * 
     *
     * @return Returns the minimum element of the heap without removing it.
     */
    @Override
    public T getMin() {
        return heap.get(0);
    }

    /**
     * Removes the minimum element from the heap and returns it.
     *
     * @return The minimum element that was in the heap when the method was invoked.
     */
    @Override
    public T extractMin() {
        T ret = null;
        if(this.heap.size() > 0)
        {
            ret = this.heap.get(0);
            T moved = this.heap.get(this.heap.size() - 1);
            this.heap.set(0, moved);
            this.heap.removeLast();
            this.location.remove(ret);
            this.location.put(moved, 0);
            int n = this.heap.size();
            int i = 0;
            while(i < this.heap.size())
            {
                int ir = 2 * i + 1, il = 2 * i + 2, j = i;
                if(ir >= n) break;
                else if(il < n)
                {
                    j = this.comp.compare(this.heap.get(ir), this.heap.get(il)) < 0 ? ir : il;
                }
                else
                {
                    j = ir;
                }

                if(this.comp.compare(this.heap.get(j), this.heap.get(i)) < 0)
                {
                    T x = this.heap.get(j), y = this.heap.get(i);
                    this.heap.set(j, y);
                    this.heap.set(i, x);
                    this.location.put(y, j);
                    this.location.put(x, i);
                    i = j;
                    continue;
                }
                break;
            }
        }
        return ret;
    }

    /**
     * Anytime the key decreases for an element in the heap, this method must be
     * invoked to restored the heap property. Here, key refers to the value
     * determining the ordering of heap elements as used in the Comparator.
     *
     * @param item An item in the heap that has had its key decreased.
     */
    @Override
    public void keyDecreased(T item) {
        int i = this.location.get(item);
        while(i > 0)
        {
            int parent_i = (i - 1) / 2;
            T a = this.heap.get(i), b = this.heap.get(parent_i);
            if(this.comp.compare(a, b) < 0)
            {
                this.heap.set(i, b);
                this.heap.set(parent_i, a);
                this.location.put(b, i);
                this.location.put(a, parent_i);
                i = parent_i;
                continue;
            }
            break;
        }
    }
}
