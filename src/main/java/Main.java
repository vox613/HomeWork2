import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        NewMap newMap = new NewMap(16);
        System.out.println("\n>>>  Empty map  <<<");
        System.out.println(newMap.toString());

        System.out.println("\n>>>  Put test  <<<");
        newMap.put(22, "22");
        newMap.put(5, "1");
        newMap.put(543, "1");
        newMap.put("egwg", 1);
        newMap.put(5.4f, "1");
        newMap.put(543L, 1);
        newMap.put("rg2g", 0);
        newMap.put("mtm", 4);
        newMap.put("4t", 9);
        newMap.put("rg74", 81);
        newMap.put(0, 0);
        newMap.put("9g4/", 4);
        newMap.put(0, "1");
        newMap.put(null, "nope");
        System.out.println(newMap.toString());


        System.out.println("\n>>>  Contains test  <<<");
        System.out.println("Have value for Key " + "rg74 -  " + newMap.containsKey("rg74"));
        System.out.println("Have value for Key " + "0    -  " + newMap.containsKey(0));
        System.out.println("Have value for Key " + "9g4  -  " + newMap.containsKey("9g4/"));
        System.out.println("Have value for Key " + "null -  " + newMap.containsKey(null));
        System.out.println("Have value for Key " + "58   -  " + newMap.containsKey(58));
        System.out.println("Have value for Key " + "egwg -  " + newMap.containsKey("egwg"));
        System.out.println(newMap.toString());


        System.out.println("\n>>>  Size test  <<<");
        System.out.println(">>>>> Map size = " + newMap.size());
        System.out.println("Put new pair = " + newMap.put("newEl", 159) + " size = " + newMap.size());
        System.out.println("Put new pair = " + newMap.put("852", 466) + " size = " + newMap.size());
        System.out.println("Put new pair = " + newMap.put(null, 466) + " size = " + newMap.size());
        System.out.println("Put same pair = " + newMap.put("newEl", 852) + " size = " + newMap.size());
        System.out.println("Remove same pair = " + newMap.remove("newEl") + " size = " + newMap.size());

        System.out.println("\n>>>  Get test  <<<");
        System.out.println("Get pair = " + newMap.get("newEl"));
        System.out.println("Get pair = " + newMap.get("852"));
        System.out.println("Get pair = " + newMap.get(null));
        System.out.println("Get pair = " + newMap.get("newEl") );
        System.out.println("Remove pair = " + newMap.remove("newEl"));

        System.out.println("\n>>>  Remove test  <<<");
        System.out.println("Map before removing :");
        System.out.println(newMap.toString());
        newMap.remove(22);
        newMap.remove(5);
        newMap.remove(543);
        newMap.remove("egwg");
        newMap.remove(5.4f);
        newMap.remove(543L);
        newMap.remove("rg2g");
        newMap.remove("mtm");
        newMap.remove("4t");
        newMap.remove("rg74");
        newMap.remove(0);
        newMap.remove("9g4/");
        newMap.remove("852");
        newMap.remove(0);
        newMap.remove(null);
        System.out.println("\nMap after removing :");
        System.out.println(newMap.toString());

   /*     Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            newMap.put(rand.nextInt(5000), rand.nextInt(100));
            System.out.println("Map   - " + newMap.toString());
        }
*/

        System.out.println("\nSize   - " + newMap.size());

    }
}
