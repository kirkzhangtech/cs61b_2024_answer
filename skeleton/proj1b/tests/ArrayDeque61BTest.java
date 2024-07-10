import jh61b.utils.Reflection;
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
    public void  addFirstTest(){

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
    public void  addLastTest(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addLast("my");
        ad.addLast("name");
        ad.addLast("is");
        ad.addLast("kirk");

        assertThat(ad.toList()).containsExactly("my","name","is","kirk").inOrder(); 
 


    }

    @Test
    @DisplayName("addFirst addLast  mix function test without resize")
    public void  addFirstLastTest(){

        ArrayDeque61B ad  = new ArrayDeque61B<String>();

        ad.addLast("my");
        ad.addFirst("name");
        ad.addLast("is");
        ad.addFirst("kirk");


        
        assertThat(ad.toList()).containsExactly("kirk","name","my","is").inOrder(); 
 


    }


}
