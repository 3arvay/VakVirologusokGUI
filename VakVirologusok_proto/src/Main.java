import javax.lang.model.element.VariableElement;
import java.io.Console;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

    public static Map<Object, String> nameMap = new HashMap<>();
    public static Map<String, Object> varMap = new HashMap<>();

    public static Agent agentSwitch(String agentName){
        switch(agentName.charAt(0))
        {
            case 's':
                return (Stun) varMap.get(agentName);
            case 'd':
                return (Dance) varMap.get(agentName);
            case 'a':
                return (Amnesia) varMap.get(agentName);
            default:
                return (Immunity) varMap.get(agentName);
        }
    }

    public static Gear gearSwitch(String gearName){
        switch (gearName.charAt(0)){
            case'c':
                return (Cloak) varMap.get(gearName);
            case'b':
                return (Bag) varMap.get(gearName);
            case'a':
                return (Axe) varMap.get(gearName);
            default:
                return (Gloves) varMap.get(gearName);
        }
    }
    //  Lehet majd megcsinálom ezzel
    public <T> boolean checkEquals(T actual, T []expected) {
        for(T value : expected) {
            if(value.equals(actual)) {
                return true;
            }
        }
        return false;
    }
    /*
        Vagy ezzel
     if (Stream.of(b, c, d).anyMatch(x -> x.equals(a))) {
    // ... do something ...
}
    */
    public static void helperStatSet(String type, String varName) throws IllegalArgumentException{
        if(varName.matches("f\\d+_\\d")){ ((Field)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("l\\d+_\\d")){  ((Laboratory)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("w\\d+_\\d")){  ((Warehouse)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("sh\\d+_\\d")){ ((Shelter)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("c\\d+_\\d")){  ((Cloak)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("v\\d+_\\d")){  ((Virologist)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("s\\d+_\\d")){  ((Stun)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("d\\d+_\\d")){  ((Dance)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("i\\d+_\\d")){  ((Immunity)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("a\\d+_\\d")){  ((Amnesia)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("bm\\d+_\\d")){ ((BearMode)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("st\\d+_\\d")){ ((Stunned)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("di\\d+_\\d")){ ((Dancing)varMap.get(varName)).listAttributes(varMap);}
        else if(varName.matches("im\\d+_\\d")){ ((Immune)varMap.get(varName)).listAttributes(varMap);}
        else{ throw new IllegalArgumentException(); }
    }

    public static boolean containsVars (String[] vars) throws IllegalArgumentException{
        for (String _var : vars){
            if (!varMap.containsKey(_var)){
                return false;
            }
        }
        return true;
    }

    public static void order( String orderText)  {
        String[] orderElements = orderText.split("[ ]");
        try {
            switch (orderElements[0]) {
                case "add":
                    try {
                        if(orderElements.length<3){
                            throw new IllegalArgumentException();
                        }
                        varMap.put(orderElements[2], Class.forName(orderElements[1]).getDeclaredConstructor(new Class[]{}).newInstance());
                        System.out.println(varMap.get(orderElements[2]).getClass().getSimpleName());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Hibás osztálytípust adtál meg.");
                    } catch (InstantiationException e ) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    return;
                case "place":
                    try {
                        if (!containsVars(new String[]{orderElements[1], orderElements[2]}))
                            throw new IllegalArgumentException();
                        if (orderElements[1].matches("v\\d+_\\d")) {
                            Field f = (Field) varMap.get(orderElements[2]);
                            f.standsHere.add((Virologist) varMap.get(orderElements[1]));
                        } else if (orderElements[1].matches("b\\d+_\\d") || orderElements[1].matches("c\\d+_\\d") ||
                                orderElements[1].matches("ax\\d+_\\d") || orderElements[1].matches("g\\d+_\\d")) {
                            Shelter s = (Shelter) varMap.get(orderElements[2]);
                            Gear g = gearSwitch(orderElements[1]);
                            s.SetGear(g);
                        } else if (orderElements[1].matches("s\\d+_\\d") || orderElements[1].matches("d\\d+_\\d") ||
                                orderElements[1].matches("a\\d+_\\d") || orderElements[1].matches("i\\d+_\\d")) {
                            Laboratory l = (Laboratory) varMap.get(orderElements[2]);
                            Agent g = agentSwitch(orderElements[1]);
                            l.SetAgent(g);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg.\n" + orderElements[1] + " hibás formátum");
                    }
                    return;
                case "neighbour":
                    try {
                        if ((orderElements[1].matches("f\\d_\\d") || orderElements[1].matches("s\\d+_\\d") ||
                            orderElements[1].matches("l\\d+_\\d")) || orderElements[1].matches("w\\d+_\\d") &&
                            (orderElements[2].matches("f\\d_\\d") || orderElements[2].matches("s\\d+_\\d") ||
                            orderElements[2].matches("l\\d+_\\d")) || orderElements[2].matches("w\\d+_\\d")) {
                            Field f1 = (Field) varMap.get(orderElements[1]);
                            Field f2 = (Field) varMap.get(orderElements[2]);
                            f1.AddNeighbour(f2);
                            f2.AddNeighbour(f1);
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "move":
                    try {
                        if ((orderElements[2].matches("f\\d+_\\d") || orderElements[2].matches("s\\d+_\\d") ||
                            orderElements[2].matches("l\\d+_\\d")) || orderElements[2].matches("w\\d+_\\d")) {
                            Field f = (Field) varMap.get(orderElements[1]);
                            Virologist v = (Virologist) varMap.get(orderElements[2]);
                            f.AddVirologist(v);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "attack":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") && orderElements[2].matches("v\\d+_\\d") &&
                            (orderElements[3].matches("s\\d+_\\d") || orderElements[3].matches("d\\d+_\\d") ||
                            orderElements[3].matches("a\\d+_\\d") || orderElements[3].matches("i\\d+_\\d"))) {

                            Virologist v1 = (Virologist) varMap.get(orderElements[1]);
                            Virologist v2 = (Virologist) varMap.get(orderElements[2]);
                            //Ez egy kicsit kérdéses, hogy működik-e, de szerintem mennie kell

                            v1.UseAgent(agentSwitch(orderElements[3]), v2);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "steal":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") && orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("material") || orderElements[2].matches("gear"))) {
                            Virologist v1 = (Virologist) varMap.get(orderElements[1]);
                            Virologist v2 = (Virologist) varMap.get(orderElements[2]);
                            if (orderElements[2].matches("material")) {
                                v1.Steal(v1, "material");
                            } else {
                                v1.Steal(v1, "gear");
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "learn":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("s\\d+_\\d") || orderElements[2].matches("d\\d+_\\d") ||
                                        orderElements[2].matches("a\\d+_\\d") || orderElements[2].matches("i\\d+_\\d"))) {
                            Virologist v = (Virologist) varMap.get(orderElements[1]);
                            v.LearnGeneticCode(agentSwitch(orderElements[2]));
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "give":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("s\\d+_\\d") || orderElements[2].matches("d\\d+_\\d") ||
                                        orderElements[2].matches("a\\d+_\\d") || orderElements[2].matches("i\\d+_\\d"))) {
                            Virologist v = (Virologist) varMap.get(orderElements[1]);
                            //v.RecieveAgent(agentSwitch(orderElements[2])); <-- kéne egy ilyen függvény, mert az agentList az privát
                        } else if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("b\\d+_\\d") || orderElements[2].matches("c\\d+_\\d") ||
                                        orderElements[2].matches("ax\\d+_\\d") || orderElements[2].matches("g\\d+_\\d"))) {
                            Virologist v = (Virologist) varMap.get(orderElements[1]);
                            v.ReceiveGear(gearSwitch(orderElements[2]));
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "set":
                    try {
                        // egyelőre nem. :D
                        helperStatSet("set",orderElements[1]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");}
                    return;
                case "craft":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("s\\d+_\\d") || orderElements[2].matches("d\\d+_\\d") ||
                                        orderElements[2].matches("a\\d+_\\d") || orderElements[2].matches("i\\d+_\\d"))) {
                            Virologist v = (Virologist) varMap.get(orderElements[1]);
                            v.CraftAgent(v, agentSwitch(orderElements[2]));
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "stat":
                    try {
                        if (!containsVars(new String[]{orderElements[1]})) {
                            throw new IllegalArgumentException();
                        }
                        // egyelőre nem. :D
                        helperStatSet("stat", orderElements[1]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "step":
                    try{
                        if (orderElements[1].matches("v\\d+_\\d")){
                            Virologist v = (Virologist) varMap.get(orderElements[1]);
                            v.Time();
                        }
                        else{throw new IllegalArgumentException();}
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e){
            System.out.println("Hibás parancsot adtál meg"); }
    }

    /**
    * Leírás: 
    * szekvencia diagram kiíró függvény.
    * @param level
    * @param callAnswer
    * @param caller
    * @param function
    * @param parameters
    */
    public static void printSeq(int level, String callAnswer, String caller, String function, String[] parameters) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        if (callAnswer.equals("call")) {
            System.out.print("->");
        } else if (callAnswer.equals("answer")) {
            System.out.print("<-");
        }
        System.out.print(caller + "." + function + "(");
        for (int i = 0; i < parameters.length; i++) {
            if (i < parameters.length - 1) {
                System.out.print(parameters[i] + ",");
            } else {
                System.out.println(parameters[i] + ")");
            }
        }
    }

    public static void main(String[] args) {
        //Testing
        /*order("add Field f1");
        Shelter s = new Shelter();
        varMap.put("s1_1",s);
        Field f = (Field) varMap.get("s1_1");
        Field[] fields = new Field[]{s,f};
        System.out.println(varMap.get("s1_1").getClass().getSimpleName());*/
        Scanner scanner = new Scanner(System.in);
        String orderRow=scanner.nextLine();
        while(orderRow!="end"){
            order(orderRow);
            orderRow= scanner.nextLine();
        }

        //Testing end
    }
}
