import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>  {


    public ArrayDeque61B(){

    }

    private int size = 0;

    private int capactyFactor = 0;

    private int nextFirst = 0;

    private int nextLast = 0;

    private T[] item = null;

    private boolean  hasCell(){

        return item.length == size ? true : false ; 
        
    }


    @Override
    public void addFirst(T x) {
        if (hasCell()){
            
        }
    }

    @Override
    public void addLast(T x) {

    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
