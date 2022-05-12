
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<Object, String> nameMap = new HashMap<>();
    public static Map<String, Object> varMap = new HashMap<>();
    public static String outPut = "";
    /**
     * Leírás:
     * Parancs segédfüggvény, visszad egy specitikus ágenst a kapott paraméter alapján
     * @param agentName Az adott
     * @return gear
     */
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
    /**
     * Leírás:
     * Visszaadja a virológus felszerelését
     * @param gearName
     * @return gear
     */
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
    /**
     * Leírás:
     * Visszaadja a virológus felszerelését
     * @param id
     * @return gear
     */
    public static VAttribute attributeSwitch(String attributeName){
        switch (attributeName.charAt(0)){
            case'b':
                return (BearMode) varMap.get(attributeName);
            case'i':
                return (Immune) varMap.get(attributeName);
            case's':
                return (Stunned) varMap.get(attributeName);
            default:
                return (Dancing) varMap.get(attributeName);
        }
    }
    /**
     * Leírás:
     * Visszaadja a virológus felszerelését
     * @param id
     * @return gear
     */
    public static void helperStatSet(String[] params) throws IllegalArgumentException{
        if(params[1].matches("f\\d+_\\d")){
            if(params[0].equals("stat")) ((Field)varMap.get(params[1])).listAttributes(varMap);}
        else if(params[1].matches("l\\d+_\\d")){
            if(params[0].equals("stat")) {((Laboratory)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                try{
                    if(params[2].equals("infecting")){
                        ((Laboratory)varMap.get(params[1])).setter(params[3]);
                    }
                    else{ throw new IllegalArgumentException();}
                }catch(IllegalArgumentException e){
                    System.out.println("Hibás paramétert adtál meg");
                }
            }
        }
        else if(params[1].matches("w\\d+_\\d")) {
            if(params[0].equals("stat")){((Warehouse) varMap.get(params[1])).listAttributes(varMap);}
            else if (params[0].equals("set")) {
                try {
                    if (params[2].equals("material") || params[2].equals("amount")) {
                        ((Warehouse) varMap.get(params[1])).setter(params[2], params[3]);
                    } else {
                        throw new IllegalArgumentException();
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Hibás argumentumot adtál meg");
                }
            }
        }
        else if(params[1].matches("sh\\d+_\\d")){
            if(params[0].equals("stat")) ((Shelter)varMap.get(params[1])).listAttributes(varMap);}
        else if(params[1].matches("c\\d+_\\d")){
            if(params[0].equals("stat")) {
                ((Cloak)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                try{
                    if(params[2].equals("chance")){
                        ((Cloak)varMap.get(params[1])).setter(params[3]);
                    }
                }
                catch(IllegalArgumentException e){
                    System.out.println("Hibás argumentumot adtál meg");
                }
            }
        }

        else if(params[1].matches("ax\\d+_\\d")){
            if(params[0].equals("stat")) {
                ((Axe)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                try{
                    if(params[2].equals("durability")){
                        ((Axe)varMap.get(params[1])).setter(params[3]);
                    }
                }
                catch(IllegalArgumentException e){
                    System.out.println("Hibás argumentumot adtál meg");
                }
            }
        }

        else if(params[1].matches("g\\d+_\\d")){
            if(params[0].equals("stat")) {
                ((Gloves)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                try{
                    if(params[2].equals("durability")){
                        ((Gloves)varMap.get(params[1])).setter(params[3]);
                    }
                }
                catch(IllegalArgumentException e){
                    System.out.println("Hibás argumentumot adtál meg");
                }
            }
        }

        else if(params[1].matches("v\\d+_\\d")) {
            if (params[0].equals("stat")) {
                ((Virologist) varMap.get(params[1])).listAttributes(varMap);
            } else if (params[0].equals("set")) {
                try {
                    if (params[2].equals("amountAminoacid") || params[2].equals("amountNucleotid") ||
                            params[2].equals("maxAmount")) {
                        ((Virologist) varMap.get(params[1])).setter(params[2], params[3]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Hibás argumentumot adtál meg");
                }
            }
        }
        else if(params[1].matches("s\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Stun)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                if(params[2].equals("useTime")){
                    ((Stun)varMap.get(params[1])).setter(params[3]);
                }
            }
        }

        else if(params[1].matches("d\\d+_\\d")) {
            if (params[0].equals("stat")) {
                ((Dance) varMap.get(params[1])).listAttributes(varMap);
            }
            else if (params[0].equals("set")) {
                if (params[2].equals("useTime")) {
                    ((Dance) varMap.get(params[1])).setter(params[3]);
                }
            }
        }
        else if(params[1].matches("a\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Amnesia)varMap.get(params[1])).listAttributes(varMap);
            }
            else if(params[0].equals("set")){
                if(params[2].equals("useTime")){
                    ((Amnesia)varMap.get(params[1])).setter(params[3]);
                }
            }
        }
        else if(params[1].matches("i\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Immunity)varMap.get(params[1])).listAttributes(varMap);
            }
            else if(params[0].equals("set")){
                if(params[2].equals("useTime")){
                    ((Immunity)varMap.get(params[1])).setter(params[3]);
                }
            }
        }
        else if(params[1].matches("im\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Immune)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                if(params[2].equals("durationTime")){
                    ((Immune)varMap.get(params[1])).setter(params[3]);
                }
            }
        }
        else if(params[1].matches("bm\\d+_\\d")){
            if(params[0].equals("stat")){
                ((BearMode)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                if(params[2].equals("durationTime")){
                    ((BearMode)varMap.get(params[1])).setter(params[3]);
                }
            }
        }
        else if(params[1].matches("st\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Stunned)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                if(params[2].equals("durationTime")){
                    ((Stunned)varMap.get(params[1])).setter(params[3]);
                }
            }}
        else if(params[1].matches("di\\d+_\\d")){
            if(params[0].equals("stat")){
                ((Dancing)varMap.get(params[1])).listAttributes(varMap);}
            else if(params[0].equals("set")){
                if(params[2].equals("durationTime")) {
                    ((Dancing) varMap.get(params[1])).setter(params[3]);
                }
            }
        }

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
                        //System.out.println(varMap.get(orderElements[2]).getClass().getSimpleName());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Hibás osztálytípust adtál meg.");
                    } catch (InstantiationException | IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    return;
                case "place":
                    try {
                        if (!containsVars(new String[]{orderElements[1], orderElements[2]}))
                            throw new IllegalArgumentException();
                        if (orderElements[1].matches("v\\d+_\\d")) {
                            //Field f =
                            ((Virologist) varMap.get(orderElements[1])).SetInitialField((Field) varMap.get(orderElements[2]));
                            //f.standsHere.add((Virologist) varMap.get(orderElements[1]));
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
                        if ((orderElements[1].matches("f\\d+_\\d") || orderElements[1].matches("s\\d+_\\d") ||
                            orderElements[1].matches("l\\d+_\\d")) || orderElements[1].matches("w\\d+_\\d") &&
                            (orderElements[2].matches("f\\d+_\\d") || orderElements[2].matches("s\\d+_\\d") ||
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
                        if ((orderElements[2].matches("f\\d+_\\d") || orderElements[2].matches("sh\\d+_\\d") ||
                            orderElements[2].matches("l\\d+_\\d")) || orderElements[2].matches("w\\d+_\\d")) {
                            ((Virologist) varMap.get(orderElements[1])).Move((Field) varMap.get(orderElements[2]));
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
                        if (orderElements[1].matches("v\\d+_\\d") && orderElements[2].matches("v\\d+_\\d") &&
                                (orderElements[3].matches("material") || orderElements[3].matches("gear"))) {
                            Virologist v1 = (Virologist) varMap.get(orderElements[1]);
                            Virologist v2 = (Virologist) varMap.get(orderElements[2]);
                            if (orderElements[3].matches("material")) {
                                v1.Steal(v2, "material");
                            } else {
                                v1.Steal(v2, "gear");
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
                            ((Virologist) varMap.get(orderElements[1])).ReceiveAgent(agentSwitch(orderElements[2]));
                        } else if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("b\\d+_\\d") || orderElements[2].matches("c\\d+_\\d") ||
                                        orderElements[2].matches("ax\\d+_\\d") || orderElements[2].matches("g\\d+_\\d"))) {
                            ((Virologist) varMap.get(orderElements[1])).ReceiveGear(gearSwitch(orderElements[2]));
                        } else if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("bm\\d+_\\d") || orderElements[2].matches("di\\d+_\\d") ||
                                        orderElements[2].matches("im\\d+_\\d") || orderElements[2].matches("st\\d+_\\d"))) {
                            ((Virologist) varMap.get(orderElements[1])).ReceiveAttribute(attributeSwitch(orderElements[2]));
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");
                    }
                    return;
                case "set":
                    try {
                        if (!containsVars(new String[]{orderElements[1]})) {
                            throw new IllegalArgumentException();
                        }
                        helperStatSet(orderElements);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hibás argumentumot adtál meg");}
                    return;
                case "craft":
                    try {
                        if (orderElements[1].matches("v\\d+_\\d") &&
                                (orderElements[2].matches("s\\d+_\\d") || orderElements[2].matches("d\\d+_\\d") ||
                                        orderElements[2].matches("a\\d+_\\d") || orderElements[2].matches("i\\d+_\\d"))) {
                            Virologist v = ((Virologist) varMap.get(orderElements[1]));
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
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PrintStream ps = new PrintStream(baos);
                        PrintStream old = System.out;
                        System.setOut(ps);
                        helperStatSet(orderElements);
                        System.out.flush();
                        System.setOut(old);
                        String newString = baos.toString();
                        System.out.print(newString);
                        if(outPut.length()==0){
                            outPut=newString;
                        }
                        else{
                            outPut=outPut+newString;
                        }

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

    public static void readFile(String fileAddress){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileAddress));
            String line = reader.readLine();
            while (line != null) {
                order(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compareOutput(String testName, String fileAddress){
        Path filePath = Path.of(fileAddress);
        try {
            String content = Files.readString(filePath);
            outPut = outPut.substring(0,outPut.length()-2);
            System.out.println("\n---------------------\n"+"Kimenet: \n"+outPut+"\n---------------------\n");
            System.out.println("Elvárt kimenet: \n"+content);
            if(content.equals(outPut)){
                System.out.println(testName+" teszt sikeres!");
            }
            else {
                System.out.println(testName+" teszt sikertelen");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String i = "12";
        if (args.length > 0) {
            switch (args[0]) {
                case "1":
                    readFile("input/AddVirologist-input.txt");
                    compareOutput("Add Virologist","output/AddVirologist-output.txt");
                    break;
                case "2":
                    readFile("input/PlaceAgentInLaboratory-input.txt");
                    compareOutput("Place agent in laboratory","output/PlaceAgentInLaboratory-output.txt");
                    break;
                case "3":
                    readFile("input/PlaceGearInShelter-input.txt");
                    compareOutput("Place gear in shelter","output/PlaceGearInShelter-output.txt");
                    break;
                case "4":
                    readFile("input/Neighbour-input.txt");
                    compareOutput("Neighbour","output/Neighbour-output.txt");
                    break;
                case "5":
                    readFile("input/MoveToField-input.txt");
                    compareOutput("Move to field","output/MoveToField-output.txt");
                    break;
                case "6":
                    readFile("input/MoveToLaboratory-input.txt");
                    compareOutput("Move to laboratory","output/MoveToLaboratory-output.txt");
                    break;
                case "7":
                    readFile("input/MoveToWarehouse-input.txt");
                    compareOutput("Move to warehouse","output/MoveToWarehouse-output.txt");
                    break;
                case "8":
                    readFile("input/MoveToShelter-input.txt");
                    compareOutput("Move to shelter","output/MoveToShelter-output.txt");
                    break;
                case "9":
                    readFile("input/DanceMove-input.txt");
                    compareOutput("Dance move","output/DanceMove-output.txt");
                    break;
                case "10":
                    readFile("input/BearMove-input.txt");
                    compareOutput("Bear move","output/BearMove-output.txt");
                    break;
                case "11":
                    readFile("input/BearMoveToWarehouse-input.txt");
                    compareOutput("Bear move to warehouse","output/BearMoveToWarehouse-output.txt");
                    break;
                case "12":
                    readFile("input/BearMoveNextToAxeUser-input.txt");
                    compareOutput("Bear move next to axe user","output/BearMoveNextToAxeUser-output.txt");
                    break;
                case "13":
                    readFile("input/AttackWithStun-input.txt");
                    compareOutput("Attack with stun","output/AttackWithStun-output.txt");
                    break;
                case "14":
                    readFile("input/AttackWithDance-input.txt");
                    compareOutput("Attack with dance","output/AttackWithDance-output.txt");
                    break;
                case "15":
                    readFile("input/AttackSelfWithImmunity-input.txt");
                    compareOutput("Attack self with immunity","output/AttackSelfWithImmunity-output.txt");
                    break;
                case "16":
                    readFile("input/AttackWithAmnesia-input.txt");
                    compareOutput("Attack with amnesia","output/AttackWithAmnesia-output.txt");
                    break;
                case "17":
                    readFile("input/AttackCloakUserProtected-input.txt");
                    compareOutput("Attack cloak user (protected)","output/AttackCloakUserProtected-output.txt");
                    break;
                case "18":
                    readFile("input/AttackCloakUserNotProtected-input.txt");
                    compareOutput("Attack cloak user (not protected)","output/AttackCloakUserNotProtected-output.txt");
                    break;
                case "19":
                    readFile("input/AttackGloveUser-input.txt");
                    compareOutput("Attack glove user","output/AttackGloveUser-output.txt");
                    break;
                case "20":
                    readFile("input/AttackGloveUserAsGloveUser-input.txt");
                    compareOutput("Attack glove user as glove user","output/AttackGloveUserAsGloveUser-output.txt");
                    break;
                case "21":
                    readFile("input/AttackImmuneVirologist-input.txt");
                    compareOutput("Attack immune virologist","output/AttackImmuneVirologist-output.txt");
                    break;
                case "22":
                    readFile("input/CraftAgent-input.txt");
                    compareOutput("Craft agent","output/CraftAgent-output.txt");
                    break;
                case "23":
                    readFile("input/StealMaterial-input.txt");
                    compareOutput("Steal material","output/StealMaterial-output.txt");
                    break;
                case "24":
                    readFile("input/StealBag-input.txt");
                    compareOutput("Steal bag","output/StealBag-output.txt");
                    break;
                case "25":
                    readFile("input/CraftedAgentUseTimeRunsOut-input.txt");
                    compareOutput("Crafted agent use time runs out","output/CraftedAgentUseTimeRunsOut-output.txt");
                    break;
                case "26":
                    readFile("input/VAttributeDurationTimeRunsOut-input.txt");
                    compareOutput("VAttribute duration time runs out","output/VAttributeDurationTimeRunsOut-output.txt");
                    break;
                case "27":
                    readFile("input/VirologistWins-input.txt");
                    compareOutput("Virologist wins","output/VirologistWins-output.txt");
                    break;
                case "28":
                    readFile("input/AddLaboratoryNotInfected-input.txt");
                    compareOutput("Add laboratory (not infected)","output/AddLaboratoryNotInfected-output.txt");
                    break;
                case "29":
                    readFile("input/AddLaboratoryInfected-input.txt");
                    compareOutput("Add laboratory (infected)","output/AddLaboratoryInfected-output.txt");
                    break;
                case "m":
                    Scanner scanner = new Scanner(System.in);
                    String orderRow = scanner.nextLine();
                    while (!orderRow.equals("end")) {
                        order(orderRow);
                        orderRow = scanner.nextLine();
                    }
                    break;
                default:
                    System.out.println("Not an option!");
                    break;
            }
        }
        /*
        Scanner scanner = new Scanner(System.in);
        String orderRow=scanner.nextLine();
        while(!orderRow.equals("end")) {
            order(orderRow);
            orderRow= scanner.nextLine();
        }
        */
    }
}
