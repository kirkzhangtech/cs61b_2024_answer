
import java.util.Set;



public class BSTMap<K , V>  implements  Map61B<K,V> {

    class Entry {

        public void  Entry {}

    }
    /** Associates the specified value with the specified key in this map.
     *  If the map already contains the specified key, replaces the key's mapping
     *  with the value specified. */
    public void put(K key, V value){

    };

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
    public V get(K key){
      
        return null;
    };

    /** Returns whether this map contains a mapping for the specified key. */
    public boolean containsKey(K key){ return false;};

    /** Returns the number of key-value mappings in this map. */
    public int size(){ return 0;};

    /** Removes every mapping from this map. */
    public void clear(){};

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() { return null ;};

    /** Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){ return null ;};


}
