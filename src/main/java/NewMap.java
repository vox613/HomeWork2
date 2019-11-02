public class NewMap {
    private final int mapCapacity;
    private Bucket[] bucketMass;


    NewMap(int mapCapacity) {
        this.mapCapacity = mapCapacity;
        bucketMass = new Bucket[mapCapacity];
        for (int i = 0; i < mapCapacity; i++) {
            bucketMass[i] = new Bucket();
        }
    }


    Object put(Object key, Object value) throws ArrayIndexOutOfBoundsException {             // должен возвращать старое значение value или null
        if (key == null) {
            return bucketMass[0].putNullKey(new Node(key, value));
        } else {
            int bucketNum = getIndex(key);
            return bucketMass[bucketNum].add(new Node(key, value));
        }
        //if(bucketMass[getIndex(key)].takeNode(key).getNext() == null){ }
    }


    Object get(Object key) {
        if (containsKey(key)) {
            if (key == null) {
                return bucketMass[0].takeNode(key).getValue();
            } else {
                return bucketMass[getIndex(key)].takeNode(key).getValue();
            }
        }
        return null;
    }


    Object remove(Object key) {
        Object oldValue = null;
        int index = (key == null) ? 0 : getIndex(key);

        if (containsKey(key)) {
            oldValue = bucketMass[index].removeNode(key);
            return oldValue;
        } else {
            return null;
        }
    }


    boolean containsKey(Object key) {
        if (key == null) {
            return bucketMass[0].haveKey(key);
        } else {
            return bucketMass[getIndex(key)].haveKey(key);
        }
    }


    int size() {
        int size = 0;
        for (int i = 0; i < mapCapacity; i++) {
            size += bucketMass[i].getNumOfEntry();
        }
        return size;
    }


    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < mapCapacity; i++) {
            //System.out.println("Bucket " + i + " : " + bucketMass[i].toString());
            str.append("Bucket " + i + " : ");
            str.append(bucketMass[i].toString());
            str.append("\n");
        }
        return str.toString();
    }

    private int getIndex(Object key) {
        return newHash(key.hashCode());
    }

    private int newHash(int keyHashCode) {
        return (keyHashCode & (mapCapacity - 1));
    }

}
