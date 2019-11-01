import org.jcp.xml.dsig.internal.SignerOutputStream;

public class NewMap {
    private int pairCounter = 0;
    private final int mapCapacity;
    private String keyType;
    private String valueType;
    private Bucket[] bucketMass;


    public NewMap(int mapCapacity) {
        this.mapCapacity = mapCapacity;
        bucketMass = new Bucket[mapCapacity];
        for (int i = 0; i < mapCapacity; i++) {
            bucketMass[i] = new Bucket();
        }
    }


    public void put(Object key, Object value) {             // должен возвращать старое значение value или null
        if(key == null) {
            System.out.println("\nbucketNum = " + 0 + "   key = " + key);
            bucketMass[0].putNullKey(new Node(key, value));
            System.out.println(bucketMass[0].toString());
        }else{
            int bucketNum = getIndex(key);
            System.out.println("\nbucketNum = " + bucketNum + "   key = " + key);
            bucketMass[bucketNum].add(new Node(key, value));
            System.out.println(bucketMass[bucketNum].toString());
        }

        //if(bucketMass[getIndex(key)].takeNode(key).getNext() == null){ }
    }



    public Object get (Object key){
        if(containsKey(key)){
            if(key == null){
                return bucketMass[0].takeNode(key).getValue();
            }else{
                return bucketMass[getIndex(key)].takeNode(key).getValue();
            }
        }
        return null;
    }




    public Object remove (Object key){
        Object oldValue = null;
        int index = (key == null) ? 0 : getIndex(key);

        if(containsKey(key)){
            oldValue = bucketMass[index].removeNode(key);
            System.out.println("Remove key: " + key + " return - " + oldValue);
            return  oldValue;
        }else{
            return null;
        }
    }




    public boolean containsKey (Object key){
        if(key == null){
            return bucketMass[0].haveKey(key);
        }else{
            return bucketMass[getIndex(key)].haveKey(key);
        }
    }





    public int size(){
        int size = 0;
        for (int i = 0; i < mapCapacity; i++) {
            size += bucketMass[i].getNumOfEntry();
            System.out.println("Bucket " + i + " size = " + bucketMass[i].getNumOfEntry());
        }
        return size;
    }


    public String toString(){
        StringBuilder str = new StringBuilder(" ");
        for (int i = 0; i < mapCapacity; i++) {
            //if(bucketMass[i] == null){
            //    System.out.println("Bucket " + i + " : " + "null");
            //    str.append("null");
            //}else{
                System.out.println("Bucket " + i + " : " + bucketMass[i].toString());
                str.append(bucketMass[i].toString());
            //}

        }
        return str.toString();
    }


    private int getIndex(Object key) {
        return newHash(key.hashCode());
    }

    private int newHash(int keyHashCode) {
        return (keyHashCode & (mapCapacity - 1));
    }


    public int getMapCapacity() {
        return mapCapacity;
    }

    public Bucket[] getBucketMass() {
        return bucketMass;
    }
}
