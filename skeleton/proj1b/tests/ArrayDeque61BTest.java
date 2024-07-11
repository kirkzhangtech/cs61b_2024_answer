import jh61b.utils.Reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }

    @Test
    @DisplayName("ArrayDeque addFirst function test without resize")
    public void  testAddFirst(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addFirst("my");
        ad.addFirst("name");
        ad.addFirst("is");
        ad.addFirst("kirk");

        assertThat(ad.toList()).containsExactly("kirk","is","name","my").inOrder(); 
        // (["my","name","is","kirk"]);
        // assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();


    }
    @Test
    @DisplayName("ArrayDeque addLast function test without resize")
    public void  testAddLast(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addLast("my");
        ad.addLast("name");
        ad.addLast("is");
        ad.addLast("kirk");

        assertThat(ad.toList()).containsExactly("my","name","is","kirk").inOrder(); 
 


    }

    @Test
    @DisplayName("addFirst addLast  mix function test without resize")
    public void  testAddFirstLast(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addLast("my");
        ad.addFirst("name");
        ad.addLast("is");
        ad.addFirst("kirk");


        
        assertThat(ad.toList()).containsExactly("kirk","name","my","is").inOrder(); 
 


    }

    @Test
    @DisplayName("test get() function without resize")
    public void  testGet(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addLast("my");
        ad.addLast("name");
        ad.addLast("is");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");
        ad.addLast("kirk");


        assertThat(ad.get(1)).isEqualTo("name"); 
 


    }

        @Test
    public void testRemoveFirst() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Assertions.assertEquals(1, deque.removeFirst());
        Assertions.assertEquals(2, deque.removeFirst());
        Assertions.assertEquals(3, deque.removeFirst());
        Assertions.assertTrue(deque.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Assertions.assertEquals(3, deque.removeLast());
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(1, deque.removeLast());
        Assertions.assertTrue(deque.isEmpty());
    }

    @Test
    public void testGetRecursive() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);
        
        // 测试索引在有效范围内的情况
        Assertions.assertEquals(10, deque.getRecursive(0));
        Assertions.assertEquals(20, deque.getRecursive(1));
        Assertions.assertEquals(30, deque.getRecursive(2));
        Assertions.assertEquals(40, deque.getRecursive(3));
        
        // 测试索引超出有效范围的情况
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.getRecursive(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            deque.getRecursive(4);
        });
    }

}
