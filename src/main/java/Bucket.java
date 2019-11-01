

public class Bucket {
    private int numOfEntry = 0;
    private Node[] nodeMass;
    private int bucketCapacity = 20;

    public Bucket() {
        nodeMass = new Node[bucketCapacity];

    }


    public Object removeNode(Object key) {
        Object oldValue;

        if (key == null) {
            oldValue = nodeMass[0].getValue();
            numOfEntry--;
            nodeMass[0] = null;
            return oldValue;
        } else {
            for (int i = 0; i < bucketCapacity; i++) {
                if ((nodeMass[i] != null) && (nodeMass[i].getKey() != null)) {
                    if (nodeMass[i].getKey().equals(key)) {
                        oldValue = nodeMass[i].getValue();
                        numOfEntry--;
                        nodeMass[i] = null;
                        return oldValue;
                    }
                }
            }
        }
        return null;
    }


    public Object add(Node node) {
        Object temp;
        for (int i = 0; i < bucketCapacity; i++) {
            if (nodeMass[i] != null) {
                if (nodeMass[i].getKey() != null) {
                    if (node.getKeyHashCode() == nodeMass[i].getKeyHashCode()) {
                        System.out.println(">>> Hash == Hash <<<");
                        if (node.getKey().equals(nodeMass[i].getKey())) {
                            System.out.println(">>> Key == Key <<<");
                            System.out.println("oldVal = " + nodeMass[i].getValue() + " // newVal = " + node.getValue());
                            temp = nodeMass[i].getValue();
                            nodeMass[i].setValue(node.getValue());
                            return temp;
                        } else {
                            System.out.println(">>> Differents key <<<");
                        }
                    } else {
                        System.out.println(">>> Differents hCode <<<");
                    }
                }
            } else {
                System.out.println("numOfEntry < 20 = " + (numOfEntry < 20) + "  numOfEntry = " + numOfEntry);
                if (numOfEntry < bucketCapacity) {
                    System.out.println(">>> Add new object <<<");
                    nodeMass[i] = node;
                    numOfEntry++;
                    if (numOfEntry == bucketCapacity) {
                        System.out.println("!!! Bucket " + i + " OVERFLOW !!!");
                    }
                    return null;
                }
            }
        }
        return null;
    }


    public Object putNullKey(Node node) {
        System.out.println("here");
        Object temp;

        if (nodeMass[0] != null) {
            if (nodeMass[0].getKey() == null) {
                System.out.println("Zero pos have null key and vlue = " + nodeMass[0].getValue());
                temp = nodeMass[0].getValue();
                nodeMass[0].setValue(node.getValue());
                return temp;
            } else {
                System.out.println("Zero pos have NOT null key");
                System.out.println(nodeMass[0].toString());
                if (bucketCapacity - numOfEntry > 0) {
                    for (int i = bucketCapacity - 1; i > 0; i--) {                            // fix before - numOfEntry
                        nodeMass[i] = nodeMass[i - 1];
                    }
                    nodeMass[0] = node;
                    numOfEntry++;
                    return null;
                } else {  // увеличение размеа массива в бакете
                    System.out.println("!!! Max length bucket !!!");
                }
            }
        } else {
            nodeMass[0] = node;
            numOfEntry++;
            return null;
        }
        return null;
    }


    public boolean haveKey(Object key) {
        if (key != null) {
            for (int i = 0; i < bucketCapacity; i++) {                                      // fix before - numOfEntry
                if (nodeMass[i] != null) {
                    if (nodeMass[i].getKey() != null) {
                        if (nodeMass[i].getKey().equals(key)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (nodeMass[0] != null) {
                return (nodeMass[0].getKey() == null);
            }
        }
        return false;
    }


    public Node takeNode(Object key) {
        if (key == null) {
            if (haveKey(null)) {
                return nodeMass[0];
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < bucketCapacity; i++) {                                     // fix before - numOfEntry
                if (nodeMass[i] != null) {
                    if (nodeMass[i].getKey() != null) {
                        if (nodeMass[i].getKey().equals(key)) {
                            return nodeMass[i];
                        }
                    }
                }
            }
        }
        return null;
    }


    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < bucketCapacity; i++) {
            if (nodeMass[i] != null) {
                str.append(nodeMass[i].toString());
                str.append(" ");
            } else {
                str.append("null ");
            }
        }
        return str.toString();
    }




    public Node[] getNodeMass() {
        return nodeMass;
    }

    public int getBucketCapacity() {
        return bucketCapacity;
    }

    public int getNumOfEntry() {
        return numOfEntry;
    }

    public void setNumOfEntry(int numOfEntry) {
        this.numOfEntry = numOfEntry;
    }
}
