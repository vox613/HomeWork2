import java.security.Key;

public class Node {
    private Object key;
    private Object value;
    private int keyHashCode;
    Node next = null;
    private static int objCounter = 0;


    // впоследствии добаваить классы Key и Value для хранения разных типов (без/с дженериками)
    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
        if(key == null){
            this.keyHashCode = 0;
        }else{
            this.keyHashCode = key.hashCode();
        }
        objCounter++;
        System.out.println("Create new Node: " + objCounter);
    }


    public String toString(){
        return "[" + key + ":" + value + "]";
    }



    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }


    public void setNext(Node next) {
        this.next = next;
    }


    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }


    public int getKeyHashCode() {
        return keyHashCode;
    }
}
