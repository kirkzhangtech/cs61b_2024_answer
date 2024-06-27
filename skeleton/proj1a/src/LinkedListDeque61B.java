import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<E> implements Deque61B<E> {


    private  Node first ;
    private  Node last ;


    private int size;


    private  class Node {

        private Node prev;

        private Node next;

        E element;



        public Node(Node previous , E elment , Node next ){
            this.prev = previous;
            this.element = elment;
            this.next = next;

        }

    }

    public  LinkedListDeque61B(){
            first = new Node(null,null,null);
            last = new Node(null,null,null);
            first.next = last;
            last.prev = first;

    }



    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(E x) {
        final Node f = first;
        final Node newNode = new Node(null, x, null);

        f.next.prev = newNode;
        newNode.next = f.next;
        f.next = newNode;
        newNode.prev = f;

        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(E x) {
        final Node l = last;
        final Node newNode = new Node(null, x , null);
        l.prev.next = newNode;
        newNode.prev = l.prev;
        l.prev = newNode;
        newNode.next = l;
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<E> toList() {
        ArrayList<E> arrayList = new ArrayList<>();


        for( Node current = first.next  ; current.next != null ; current = current.next ){
            arrayList.add(current.element);
//            current = current.next;
        }

        return arrayList;


    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
//        if(first.next == null);
//            return true;
        return (first.next == null)? true : false;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        int size=0;
        Node current = first;

        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public E removeFirst() {
        return null;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public E removeLast() {
        return null;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public E getRecursive(int index) {
        return null;
    }






}
