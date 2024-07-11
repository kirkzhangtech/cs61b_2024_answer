import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayDeque61B<T> implements Deque61B<T>  {


   

    private int size = 0;

    private double resizeFactor = 0.75;

    private int first = 0;

    private int last = 0;

    private T[] items = null;

    private int InitializationCap = 8;

    public ArrayDeque61B(){
          items = (T[]) new Object[InitializationCap];
          size = 0;
          first = 3;
          last = 3;
    }

    public boolean  isFull() {

        return size == items.length;

    }

    // private int adjustIndex(int index) {
    //     if (index == items.length) {
    //         index = 0;
    //     }
    //     return index;
    // }

    @Override
    public void addFirst(T x) {
        if (isFull()){
            throw new IllegalStateException("array is full");
        }
        
        first = (first - 1 + items.length) % items.length;
        items[first] = x;

        size++;
    }

    @Override
    public void addLast(T x) {
        if (isFull()){
            throw new IllegalStateException("array is full");
        }
        items[last] = x;
        last = (last + 1) % items.length;
        size++;
    }

    @Override
    public List<T> toList() {

        List<T> returnList = new ArrayList<>();
        int currentIndex = first;

        for(int  i = 0 ; i < size ; i++){
            returnList.add(items[currentIndex]);
            currentIndex = (currentIndex + 1 )  % items.length;

        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public int size() {

        return  this.size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular array deque is empty");
        }
        T removedElement = items[first];
        items[first] = null; // 可选，将移除的元素置为null，方便垃圾回收
        first = (first + 1) % items.length;
        size--;
        return removedElement;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular array deque is empty");
        }
        last = (last - 1 + items.length) % items.length;
        T removedElement = items[last];
        items[last] = null; // 可选，将移除的元素置为null，方便垃圾回收
        size--;
        return removedElement;

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T returnValue = null;
        int actualIndex = first + index;
        if (actualIndex > items.length - 1) {
            actualIndex = actualIndex - items.length;
        }
        returnValue = items[actualIndex];
        return returnValue;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }

    // size * RFACTOR     RFACTOR = 0.25 = size / length
    private void resize(int capacity) {

        T[] a = (T[])(new Object[capacity]);
        int index = first;
        for (int i = 0; i < size; i++) {
            // index = adjustIndex(index);
            if (index == items.length) {
                index = 0;
            }
            a[i] = items[index];
            index += 1;
        }
        items = a;
    }



}
