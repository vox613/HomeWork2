

public class Bucket {
    private int numOfEntry = 0;
    private Node[] nodeMass;
    private int bucketCapacity = 20;

    Bucket() {
        nodeMass = new Node[bucketCapacity];
    }


    Object removeNode(Object key) {
        Object oldValue;

        if (key == null) {
            oldValue = nodeMass[0].getValue();
            numOfEntry--;
            nodeMass[0] = null;
            trimMass(0);
            return oldValue;
        } else {
            for (int i = 0; i < bucketCapacity; i++) {
                if ((nodeMass[i] != null) && (nodeMass[i].getKey() != null)) {
                    if (nodeMass[i].getKey().equals(key)) {
                        oldValue = nodeMass[i].getValue();
                        numOfEntry--;
                        trimMass(i);
                        return oldValue;
                    }
                }
            }
        }
        return null;
    }


    private void trimMass(int index) {
        if (index < bucketCapacity - 1) {
            for (int i = index + 1; i < bucketCapacity; i++) {                            // fix before - numOfEntry
                if (nodeMass[i] != null) {
                    nodeMass[i - 1] = nodeMass[i];
                    nodeMass[i] = null;
                } else {
                    nodeMass[i - 1] = null;
                    break;
                }
            }
        }
    }


    Object add(Node node) {
        Object temp;
        if (numOfEntry == 20) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = 0; i < bucketCapacity; i++) {
                if (nodeMass[i] != null) {
                    if (nodeMass[i].getKey() != null) {
                        if (node.getKeyHashCode() == nodeMass[i].getKeyHashCode()) {
                            if (node.getKey().equals(nodeMass[i].getKey())) {
                                temp = nodeMass[i].getValue();
                                nodeMass[i].setValue(node.getValue());
                                return temp;
                            }
                        }
                    }
                } else {
                    nodeMass[i] = node;
                    numOfEntry++;
                    return null;
                }
            }
        }
        return null;
    }


    Object putNullKey(Node node) {
        Object temp;
        if (numOfEntry == 20) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (nodeMass[0] != null) {
                if (nodeMass[0].getKey() == null) {
                    temp = nodeMass[0].getValue();
                    nodeMass[0].setValue(node.getValue());
                    return temp;
                } else {
                    for (int i = bucketCapacity - 1; i > 0; i--) {                            // fix before - numOfEntry
                        nodeMass[i] = nodeMass[i - 1];
                    }
                    nodeMass[0] = node;
                    numOfEntry++;
                    return null;
                }
            } else {
                nodeMass[0] = node;
                numOfEntry++;
                return null;
            }
        }

    }


    boolean haveKey(Object key) {
        if (key != null) {
            for (int i = 0; i < bucketCapacity; i++) {                                      // fix before - numOfEntry
                if ((nodeMass[i] != null) && (nodeMass[i].getKey() != null)) {
                    if (nodeMass[i].getKey().equals(key)) {
                        return true;
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


    Node takeNode(Object key) {
        if (key == null) {
            if (haveKey(null)) {
                return nodeMass[0];
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < bucketCapacity; i++) {                                     // fix before - numOfEntry
                if ((nodeMass[i] != null) && (nodeMass[i].getKey() != null)) {
                    if (nodeMass[i].getKey().equals(key)) {
                        return nodeMass[i];
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

    int getNumOfEntry() {
        return numOfEntry;
    }
}
