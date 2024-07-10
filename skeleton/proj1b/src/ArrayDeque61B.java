import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>  {


   

    private int size = 0;

    private double resizeFactor = 0.75;

    private int nextFirst = 0;

    private int nextLast = 0;

    private T[] items = null;

    private int InitializationCap = 8;

    public ArrayDeque61B(){
          items = (T[]) new Object[InitializationCap];
          size = 0;
          nextFirst = 3;
          nextLast = 4;
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
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1) % items.length;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (isFull()){
            throw new IllegalStateException("array is full");
        }
        items[nextLast] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    @Override
    public List<T> toList() {

        List<T> returnList = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < size; i++) {
            index = adjustIndex(index);
            returnList.add(items[index]);
            index += 1;
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
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }


}
