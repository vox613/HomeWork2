import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("First commit");

        /*Map<Integer, String> maps = new HashMap<Integer, String>();
        maps.put(1,"1");
        maps.put(2,"2");
        maps.put(3,"3");
        maps.put(4,"4");

        System.out.println(maps.containsKey(2));
        System.out.println(maps.containsKey(7));
        System.out.println(maps.containsKey(0));
        System.out.println(maps.containsKey(null));
*/


        NewMap newMap = new NewMap(16);
        newMap.toString();
        System.out.println(">>>>> Map size = " + newMap.size());



        newMap.put(22,"22");
        newMap.put(5,"1");
        newMap.put(543,"1");
        newMap.put("egwgwg",1);
        newMap.put(5.4f,"1");
        newMap.put(543L,1);
        newMap.put("rg2g",0);
        newMap.put("mtm",4);
        newMap.put("4t",9);
        newMap.put("rg74",81);
        newMap.put(0,0);
        newMap.put("9g4/",4);
        newMap.put(0,"1");
        //newMap.put(null,"nope");

        System.out.println(newMap.toString());

        System.out.println(newMap.get(22));
        System.out.println(newMap.get(5));
        System.out.println(newMap.get(543));
        System.out.println(newMap.get("egwgwg"));
        System.out.println(newMap.get(5.4f));
        System.out.println(newMap.get(543L));
        System.out.println(newMap.get("rg2g"));
        System.out.println(newMap.get("mtm"));
        System.out.println(newMap.get("4t"));
        System.out.println(newMap.get("rg74"));
        System.out.println(newMap.get(0));
        System.out.println(newMap.get("9g4/"));
        System.out.println(newMap.get(0));
        System.out.println(newMap.get(null));
        System.out.println(newMap.get(85));
        System.out.println(newMap.get("jftjr"));
        System.out.println(newMap.get("373"));
        System.out.println(newMap.get(0.23));
        System.out.println(newMap.get(852));

        System.out.println(newMap.toString());

        System.out.println(newMap.containsKey(22));
        System.out.println(newMap.containsKey(5));
        System.out.println(newMap.containsKey(543));
        System.out.println(newMap.containsKey("egwgwg"));
        System.out.println(newMap.containsKey(5.4f));
        System.out.println(newMap.containsKey(543L));
        System.out.println(newMap.containsKey("rg2g"));
        System.out.println(newMap.containsKey("mtm"));
        System.out.println(newMap.containsKey("4t"));
        System.out.println(newMap.containsKey("rg74"));
        System.out.println(newMap.containsKey(0));
        System.out.println(newMap.containsKey("9g4/"));
        System.out.println(newMap.containsKey(0));
        System.out.println(newMap.containsKey(null));
        System.out.println(newMap.containsKey(85));
        System.out.println(newMap.containsKey("jftjr"));
        System.out.println(newMap.containsKey("373"));
        System.out.println(newMap.containsKey(0.23));
        System.out.println(newMap.containsKey(852));

        System.out.println(newMap.size());








/*
        System.out.println(newMap.get(22));
        System.out.println(newMap.get(0));
        System.out.println(newMap.get(543));
        System.out.println(newMap.get(8));
        System.out.println(newMap.get(null));
        System.out.println(newMap.get("mtm"));




        System.out.println(">>>>> Map size = " + newMap.size());
        newMap.put(null,"null");
        System.out.println(">>>>> Map size = " + newMap.size());


        System.out.println(newMap.get(22));
        System.out.println(newMap.get(0));
        System.out.println(newMap.get(543));
        System.out.println(newMap.get(8));
        System.out.println(newMap.get(null));
        System.out.println(newMap.get("mtm"));

        newMap.put(22,22);
        newMap.put(null,"1");
        newMap.put(5,5);
        newMap.put(543,543);
        newMap.put("egwgwg","egwgwg");
        newMap.put(5.4f,"5.4f");
        newMap.put(543L,"543L");
        newMap.put("rg2g","rg2g");
        newMap.put("mtm","mtm");
        newMap.put("4t","4t");
        newMap.put("rg74","rg74");
        newMap.put(null,"2");
        newMap.put(0,5);
        newMap.put("9g4/",5);
        newMap.put(0,"done");
        newMap.put(null,null);

        System.out.println(">>>>> Map size = " + newMap.size());


        System.out.println(newMap.get(22));
        System.out.println(newMap.get(0));
        System.out.println(newMap.get(543));
        System.out.println(newMap.get(8));
        System.out.println(newMap.get(null));
        System.out.println(newMap.get("mtm"));



        System.out.println(newMap.containsKey(22));
        System.out.println(newMap.containsKey(0));
        System.out.println(newMap.containsKey(543));
        System.out.println(newMap.containsKey(8));
        System.out.println(newMap.containsKey(null));
        System.out.println(newMap.containsKey("mtm"));










*/
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            newMap.put(rand.nextInt(500), rand.nextInt(47));

            System.out.println(">>>>> Map size = " + newMap.size());
            System.out.println("Map = {" + newMap.toString() + "}");
        }
        newMap.toString();
        System.out.println(">>>>> Map size = " + newMap.size());
        System.out.println("Map = {" + newMap.toString() + "}");

        newMap.put(null,"nope");
        System.out.println(newMap.toString());
        System.out.println(newMap.size());


        //Node node1 = new Node(key1, value1);
        //String str = node1.getClass().toString().split(" ")[1];         // костыль
        //System.out.println(str);
    }
}
