import javax.lang.model.element.VariableElement;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<Object, String> nameMap = new HashMap<>();
    public static Map<String, Object> varMap = new HashMap<>();

    public static void order(String orderText)  {
        String[] orderElements = orderText.split("[ ]");
        switch (orderElements[0]){
            case "add":
                try {
                    Class variable = Class.forName(orderElements[1]);
                    varMap.put(orderElements[2], variable);
                }
                catch(ClassNotFoundException e)
                {
                    System.out.println("Hibás osztálytípust adtál meg.");
                    e.printStackTrace();
                }
                return;
            case "place":
                try
                {
                    if(orderElements[1].equals("v\\d+"))
                    {

                    }
                    else if(orderElements[1].equals("b\\d+")&&orderElements[1].equals("c\\d+")&&orderElements.equals("a\\d+")&&orderElements.equals(""))
                    {

                    }
                }
                catch(IllegalArgumentException e)
                {

                }
            case "neighbour":
            case "move":
            case "attack":
            case "steal":
            case "learn":
            case "give":
            case "set":
            case "craft":
            case "stat":
            case "step":
            default:
        }
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
        order("add Field f1");

        int answer;
        while (true) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("\n>----------------------------------------------------------------------------------<");
            System.out.println("\n" +
                    "1:Virologist moves to empty field\n" +
                    "2:Virologist moves to laboratory containing Stun\n" +
                    "3:Virologist moves to laboratory containing Dance\n" +
                    "4:Virologist moves to laboratory containing Immunity\n" +
                    "5:Virologist moves to laboratory containing Amnesia\n" +
                    "6:Virologist moves to shelter containing Gloves\n" +
                    "7:Virologist moves to shelter containing Cloak\n" +
                    "8:Virologist moves to shelter containing Bag\n" +
                    "9:Virologist moves to warehouse\n" +
                    "10:Dancemove\n" +
                    "11:Virologist crafts agent Stun\n" +
                    "12:Virologist crafts agent Dance\n" +
                    "13:Virologist crafts agent Immunity\n" +
                    "14:Virologist crafts agent Amnesia\n" +
                    "15:Virologist attacks with Stun\n" +
                    "16:Virologist attacks with Dance\n" +
                    "17:Virologist attacks with Immunity\n" +
                    "18:Virologist attacks with Amnesia\n" +
                    "19:Virologist attacks glove user\n" +
                    "20:Virologist attacks cloak user\n" +
                    "21:Virologist attacks immune virologist\n" +
                    "22:Virologist steals Gloves\n" +
                    "23:Virologist steals Cloak\n" +
                    "24:Virologist steals Bag\n" +
                    "25:Virologist steals material\n" +
                    "26:Dancing duration time runs out\n" +
                    "27:Stunned duration time runs out\n" +
                    "28:Immune duration time runs out\n" +
                    "29:Stun use time runs out\n" +
                    "30:Dance use time runs out\n" +
                    "31:Immunity use time runs out\n" +
                    "32:Amnesia use time runs out\n" +
                    "\nAdd meg a szekvencia diagram számát: ");

            answer = Integer.parseInt(myObj.nextLine());  // Read user input

            switch (answer) {
                case 1: // Virologist moves to empty field
                    Virologist v1 = new Virologist();
                    nameMap.put(v1, "v1");
                    Main.printSeq(0, "call", Main.nameMap.get(v1), v1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(v1), v1.getClass().getSimpleName(), new String[]{""});
                    Field f1 = new Field();
                    nameMap.put(f1, "f1");
                    Main.printSeq(0, "call", Main.nameMap.get(f1), f1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f1), f1.getClass().getSimpleName(), new String[]{""});
                    Field f2 = new Field();
                    nameMap.put(f2, "f2");
                    Main.printSeq(0, "call", Main.nameMap.get(f2), f2.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f2), f2.getClass().getSimpleName(), new String[]{""});
                    f1.AddNeighbour(f2);
                    f2.AddNeighbour(f1);
                    v1.SetInitialField(f1);

                    System.out.println();

                    v1.Move(f2);
                    break;
                case 2: // Virologist moves to laboratory containing Stun
                    Virologist v2 = new Virologist();
                    nameMap.put(v2, "v2");
                    Main.printSeq(0, "call", Main.nameMap.get(v2), v2.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(v2), v2.getClass().getSimpleName(), new String[]{""});
                    Field f3 = new Field();
                    nameMap.put(f3, "f3");
                    Main.printSeq(0, "call", Main.nameMap.get(f3), f3.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f3), f3.getClass().getSimpleName(), new String[]{""});
                    Laboratory f4 = new Laboratory();
                    nameMap.put(f4, "f4");
                    Main.printSeq(0, "call", Main.nameMap.get(f4), f4.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f4), f4.getClass().getSimpleName(), new String[]{""});
                    Stun s1 = new Stun();
                    nameMap.put(s1, "s1");
                    Main.printSeq(0, "call", Main.nameMap.get(s1), s1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(s1), s1.getClass().getSimpleName(), new String[]{""});
                    f4.SetAgent(s1);
                    f3.AddNeighbour(f4);
                    f4.AddNeighbour(f3);
                    v2.SetInitialField(f3);

                    System.out.println();

                    v2.Move(f4);
                    break;
                case 3: // Virologist moves to laboratory containing Dance
                    Virologist v3 = new Virologist();
                    nameMap.put(v3, "v3");
                    Main.printSeq(0, "call", Main.nameMap.get(v3), v3.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(v3), v3.getClass().getSimpleName(), new String[]{""});
                    Field f5 = new Field();
                    nameMap.put(f5, "f5");
                    Main.printSeq(0, "call", Main.nameMap.get(f5), f5.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f5), f5.getClass().getSimpleName(), new String[]{""});
                    Laboratory f6 = new Laboratory();
                    nameMap.put(f6, "f6");
                    Main.printSeq(0, "call", Main.nameMap.get(f6), f6.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f6), f6.getClass().getSimpleName(), new String[]{""});
                    Dance d1 = new Dance();
                    nameMap.put(d1, "d1");
                    Main.printSeq(0, "call", Main.nameMap.get(d1), d1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(d1), d1.getClass().getSimpleName(), new String[]{""});
                    f6.SetAgent(d1);
                    f5.AddNeighbour(f6);
                    f6.AddNeighbour(f5);
                    v3.SetInitialField(f5);

                    System.out.println();

                    v3.Move(f6);
                    break;
                case 4: // Virologist moves to laboratory containing Immunity
                    Virologist v4 = new Virologist();
                    nameMap.put(v4, "v4");
                    Main.printSeq(0, "call", Main.nameMap.get(v4), v4.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(v4), v4.getClass().getSimpleName(), new String[]{""});
                    Field f7 = new Field();
                    nameMap.put(f7, "f7");
                    Main.printSeq(0, "call", Main.nameMap.get(f7), f7.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f7), f7.getClass().getSimpleName(), new String[]{""});
                    Laboratory f8 = new Laboratory();
                    nameMap.put(f8, "f8");
                    Main.printSeq(0, "call", Main.nameMap.get(f8), f8.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f8), f8.getClass().getSimpleName(), new String[]{""});
                    Immunity i1 = new Immunity();
                    nameMap.put(i1, "i1");
                    Main.printSeq(0, "call", Main.nameMap.get(i1), i1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(i1), i1.getClass().getSimpleName(), new String[]{""});
                    f8.SetAgent(i1);
                    f7.AddNeighbour(f8);
                    f8.AddNeighbour(f7);
                    v4.SetInitialField(f7);

                    System.out.println();

                    v4.Move(f8);
                    break;
                case 5: // Virologist moves to laboratory containing Amnesia
                    Virologist v5 = new Virologist();
                    nameMap.put(v5, "v5");
                    Main.printSeq(0, "call", Main.nameMap.get(v5), v5.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(v5), v5.getClass().getSimpleName(), new String[]{""});
                    Field f9 = new Field();
                    nameMap.put(f9, "f9");
                    Main.printSeq(0, "call", Main.nameMap.get(f9), f9.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f9), f9.getClass().getSimpleName(), new String[]{""});
                    Laboratory f10 = new Laboratory();
                    nameMap.put(f10, "f10");
                    Main.printSeq(0, "call", Main.nameMap.get(f10), f10.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(f10), f10.getClass().getSimpleName(), new String[]{""});
                    Amnesia a1 = new Amnesia();
                    nameMap.put(a1, "a1");
                    Main.printSeq(0, "call", Main.nameMap.get(a1), a1.getClass().getSimpleName(), new String[]{""});
                    Main.printSeq(0, "answer", Main.nameMap.get(a1), a1.getClass().getSimpleName(), new String[]{""});
                    f10.SetAgent(a1);
                    f9.AddNeighbour(f10);
                    f10.AddNeighbour(f9);
                    v5.SetInitialField(f9);

                    System.out.println();

                    v5.Move(f10);
                    break;
                case 6:

                    Field f12 = new Field();
                    Shelter f13 = new Shelter();
                    Gloves g12 = new Gloves();
                    Virologist v12 = new Virologist();

                    nameMap.put(v12, "v12");
                    printSeq(0, "call", nameMap.get(v12), v12.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(v12), v12.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f12, "f12");
                    printSeq(0, "call", nameMap.get(f12), f12.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f12), f12.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f13, "f13");
                    printSeq(0, "call", nameMap.get(f13), f13.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f13), f13.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(g12, "g12");
                    printSeq(0, "call", nameMap.get(g12), g12.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(g12), g12.getClass().getSimpleName(), new String[]{""});

                    f13.SetGear(g12);
                    f12.AddNeighbour(f13);
                    f13.AddNeighbour(f12);
                    v12.SetInitialField(f12);

                    System.out.println();

                    v12.Move(f13);

                    break;
                case 7:
                    Field f14 = new Field();
                    Shelter f15 = new Shelter();
                    Cloak c14 = new Cloak();
                    Virologist v14 = new Virologist();

                    nameMap.put(v14, "v14");
                    printSeq(0, "call", nameMap.get(v14), v14.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(v14), v14.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f14, "f14");
                    printSeq(0, "call", nameMap.get(f14), f14.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f14), f14.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f15, "f15");
                    printSeq(0, "call", nameMap.get(f15), f15.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f15), f15.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(c14, "c14");
                    printSeq(0, "call", nameMap.get(c14), c14.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(c14), c14.getClass().getSimpleName(), new String[]{""});

                    f15.SetGear(c14);
                    f14.AddNeighbour(f15);
                    f15.AddNeighbour(f14);
                    v14.SetInitialField(f14);

                    System.out.println();

                    v14.Move(f15);
                    break;
                case 8:
                    Field f16 = new Field();
                    Shelter f17 = new Shelter();
                    Bag b16 = new Bag();
                    Virologist v16 = new Virologist();

                    nameMap.put(v16, "v16");
                    printSeq(0, "call", nameMap.get(v16), v16.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(v16), v16.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f16, "f16");
                    printSeq(0, "call", nameMap.get(f16), f16.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f16), f16.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f17, "f17");
                    printSeq(0, "call", nameMap.get(f17), f17.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f17), f17.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(b16, "b16");
                    printSeq(0, "call", nameMap.get(b16), b16.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(b16), b16.getClass().getSimpleName(), new String[]{""});

                    f17.SetGear(b16);
                    f16.AddNeighbour(f17);
                    f17.AddNeighbour(f16);
                    v16.SetInitialField(f16);

                    System.out.println();

                    v16.Move(f17);
                    break;
                case 9:
                    Field f18 = new Field();
                    Warehouse f19 = new Warehouse(50, "aminoacid");
                    Virologist v18 = new Virologist();

                    nameMap.put(v18, "v18");
                    printSeq(0, "call", nameMap.get(v18), v18.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(v18), v18.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f18, "f18");
                    printSeq(0, "call", nameMap.get(f18), f18.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f18), f18.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f19, "f19");
                    printSeq(0, "call", nameMap.get(f19), f19.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f19), f19.getClass().getSimpleName(), new String[]{""});

                    f18.AddNeighbour(f19);
                    f19.AddNeighbour(f18);
                    v18.SetInitialField(f18);

                    System.out.println();

                    v18.Move(f19);
                    break;
                case 10:
                    Virologist v20 = new Virologist();
                    Field f20 = new Field();
                    Field f21 = new Field();
                    Field f22 = new Field();
                    Dance d20 = new Dance();

                    nameMap.put(v20, "v20");
                    printSeq(0, "call", nameMap.get(v20), v20.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(v20), v20.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f20, "f20");
                    printSeq(0, "call", nameMap.get(f20), f20.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f20), f20.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f21, "f21");
                    printSeq(0, "call", nameMap.get(f21), f21.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f21), f21.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(f22, "f22");
                    printSeq(0, "call", nameMap.get(f22), f22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(f22), f22.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(d20, "d20");
                    printSeq(0, "call", nameMap.get(d20), d20.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", nameMap.get(d20), d20.getClass().getSimpleName(), new String[]{""});

                    f20.AddNeighbour(f21);
                    f20.AddNeighbour(f22);
                    f21.AddNeighbour(f20);
                    f21.AddNeighbour(f22);
                    f22.AddNeighbour(f20);
                    f22.AddNeighbour(f21);
                    v20.SetInitialField(f20);
                    v20.UnderAttack(d20, v20);

                    v20.Move(f21);


                    break;
                case 11:
                    Virologist v22 = new Virologist();
                    nameMap.put(v22, "v22");
                    printSeq(0, "call", Main.nameMap.get(v22), v22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v22), v22.getClass().getSimpleName(), new String[]{""});
                    Stun s22 = new Stun();
                    nameMap.put(s22, "s22");
                    printSeq(0, "call", Main.nameMap.get(s22), s22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s22), s22.getClass().getSimpleName(), new String[]{""});
                    v22.LearnGeneticCode(s22);
                    v22.MaterialPickedUp("nukleotid", 100);
                    System.out.println();
                    v22.CraftAgent(v22, s22);
                    break;
                case 12:
                    Virologist v23 = new Virologist();
                    nameMap.put(v23, "v23");
                    printSeq(0, "call", Main.nameMap.get(v23), v23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v23), v23.getClass().getSimpleName(), new String[]{""});
                    Dance d23 = new Dance();
                    nameMap.put(d23, "d23");
                    printSeq(0, "call", Main.nameMap.get(d23), d23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(d23), d23.getClass().getSimpleName(), new String[]{""});
                    v23.LearnGeneticCode(d23);
                    v23.MaterialPickedUp("nukleotid", 100);
                    System.out.println();
                    v23.CraftAgent(v23, d23);
                    break;
                case 13:
                    Virologist v24 = new Virologist();
                    nameMap.put(v24, "v24");
                    printSeq(0, "call", Main.nameMap.get(v24), v24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v24), v24.getClass().getSimpleName(), new String[]{""});
                    Immunity i24 = new Immunity();
                    nameMap.put(i24, "i24");
                    printSeq(0, "call", Main.nameMap.get(i24), i24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(i24), i24.getClass().getSimpleName(), new String[]{""});
                    v24.LearnGeneticCode(i24);
                    v24.MaterialPickedUp("nukleotid", 100);
                    System.out.println();
                    v24.CraftAgent(v24, i24);
                    break;
                case 14:
                    Virologist v25 = new Virologist();
                    nameMap.put(v25, "v25");
                    printSeq(0, "call", Main.nameMap.get(v25), v25.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v25), v25.getClass().getSimpleName(), new String[]{""});
                    Amnesia a25 = new Amnesia();
                    nameMap.put(a25, "a25");
                    printSeq(0, "call", Main.nameMap.get(a25), a25.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(a25), a25.getClass().getSimpleName(), new String[]{""});
                    v25.LearnGeneticCode(a25);
                    v25.MaterialPickedUp("nukleotid", 100);
                    System.out.println();
                    v25.CraftAgent(v25, a25);
                    break;
                case 15: // Virologist attacks with Stun
                    Virologist v30 = new Virologist();
                    nameMap.put(v30, "v30");
                    printSeq(0, "call", Main.nameMap.get(v30), v30.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v30), v30.getClass().getSimpleName(), new String[]{""});
                    Virologist v31 = new Virologist();
                    nameMap.put(v31, "v31");
                    printSeq(0, "call", Main.nameMap.get(v31), v31.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v31), v31.getClass().getSimpleName(), new String[]{""});
                    Stun s15 = new Stun();
                    nameMap.put(s15, "s15");
                    printSeq(0, "call", Main.nameMap.get(s15), s15.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s15), s15.getClass().getSimpleName(), new String[]{""});
                    v30.MaterialPickedUp("nukleotid", 100);
                    v30.CraftAgent(v30, s15);

                    System.out.println();
                    v30.UseAgent(s15, v31);
                    break;
                case 16: // Virologist attacks with Dance
                    Virologist v32 = new Virologist();
                    nameMap.put(v32, "v32");
                    printSeq(0, "call", Main.nameMap.get(v32), v32.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v32), v32.getClass().getSimpleName(), new String[]{""});
                    Virologist v33 = new Virologist();
                    nameMap.put(v33, "v33");
                    printSeq(0, "call", Main.nameMap.get(v33), v33.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v33), v32.getClass().getSimpleName(), new String[]{""});
                    Dance d16 = new Dance();
                    nameMap.put(d16, "d16");
                    printSeq(0, "call", Main.nameMap.get(d16), d16.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(d16), d16.getClass().getSimpleName(), new String[]{""});
                    v32.MaterialPickedUp("nukleotid", 100);
                    v32.CraftAgent(v32, d16);

                    System.out.println();
                    v32.UseAgent(d16, v33);
                    break;
                case 17: // Virologist attacks with Immunity
                    Virologist v34 = new Virologist();
                    nameMap.put(v34, "v34");
                    printSeq(0, "call", Main.nameMap.get(v34), v34.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v34), v34.getClass().getSimpleName(), new String[]{""});
                    Virologist v35 = new Virologist();
                    nameMap.put(v35, "v35");
                    printSeq(0, "call", Main.nameMap.get(v35), v35.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v35), v34.getClass().getSimpleName(), new String[]{""});
                    Immunity i17 = new Immunity();
                    nameMap.put(i17, "i17");
                    printSeq(0, "call", Main.nameMap.get(i17), i17.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(i17), i17.getClass().getSimpleName(), new String[]{""});

                    v34.MaterialPickedUp("nukleotid", 100);
                    v34.CraftAgent(v34, i17);

                    System.out.println();
                    v34.UseAgent(i17, v34);
                    break;
                case 18: // Virologist attacks with Amnesia
                    Virologist v36 = new Virologist();
                    nameMap.put(v36, "v36");
                    printSeq(0, "call", Main.nameMap.get(v36), v36.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v36), v36.getClass().getSimpleName(), new String[]{""});
                    Virologist v37 = new Virologist();
                    nameMap.put(v37, "v37");
                    printSeq(0, "call", Main.nameMap.get(v37), v37.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v37), v36.getClass().getSimpleName(), new String[]{""});
                    Amnesia a18 = new Amnesia();
                    nameMap.put(a18, "a18");
                    printSeq(0, "call", Main.nameMap.get(a18), a18.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(a18), a18.getClass().getSimpleName(), new String[]{""});

                    v36.MaterialPickedUp("nukleotid", 100);
                    v36.CraftAgent(v36, a18);

                    System.out.println();
                    v36.UseAgent(a18, v37);
                    break;
                case 19: // Virologist attacks glove user
                    Virologist v38 = new Virologist();
                    nameMap.put(v38, "v38");
                    printSeq(0, "call", Main.nameMap.get(v38), v38.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v38), v38.getClass().getSimpleName(), new String[]{""});
                    Virologist v39 = new Virologist();
                    nameMap.put(v39, "v39");
                    printSeq(0, "call", Main.nameMap.get(v39), v39.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v39), v38.getClass().getSimpleName(), new String[]{""});
                    Gloves g19 = new Gloves();
                    nameMap.put(g19, "g19");
                    printSeq(0, "call", Main.nameMap.get(g19), g19.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(g19), g19.getClass().getSimpleName(), new String[]{""});
                    Stun s19 = new Stun();
                    nameMap.put(s19, "s19");
                    printSeq(0, "call", Main.nameMap.get(s19), s19.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s19), s19.getClass().getSimpleName(), new String[]{""});

                    v38.MaterialPickedUp("nukleotid", 100);
                    v38.CraftAgent(v38, s19);
                    v39.ReceiveGear(g19);

                    System.out.println();
                    v38.UseAgent(s19, v39);
                    break;
                case 20: // Virologist attacks cloak user
                    Virologist v40 = new Virologist();
                    nameMap.put(v40, "v40");
                    printSeq(0, "call", Main.nameMap.get(v40), v40.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v40), v40.getClass().getSimpleName(), new String[]{""});
                    Virologist v41 = new Virologist();
                    nameMap.put(v41, "v41");
                    printSeq(0, "call", Main.nameMap.get(v41), v41.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v41), v40.getClass().getSimpleName(), new String[]{""});
                    Cloak c20 = new Cloak();
                    nameMap.put(c20, "c20");
                    printSeq(0, "call", Main.nameMap.get(c20), c20.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(c20), c20.getClass().getSimpleName(), new String[]{""});
                    Stun s20 = new Stun();
                    nameMap.put(s20, "s20");
                    printSeq(0, "call", Main.nameMap.get(s20), s20.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s20), s20.getClass().getSimpleName(), new String[]{""});

                    v40.MaterialPickedUp("nukleotid", 100);
                    v40.CraftAgent(v40, s20);
                    v41.ReceiveGear(c20);

                    System.out.println();
                    v40.UseAgent(s20, v41);
                    break;
                case 21: // Virologist attacks immune virologist
                    Virologist v42 = new Virologist();
                    nameMap.put(v42, "v42");
                    printSeq(0, "call", Main.nameMap.get(v42), v42.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v42), v42.getClass().getSimpleName(), new String[]{""});
                    Virologist v43 = new Virologist();
                    nameMap.put(v43, "v43");
                    printSeq(0, "call", Main.nameMap.get(v43), v43.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v43), v42.getClass().getSimpleName(), new String[]{""});
                    Stun s21 = new Stun();
                    nameMap.put(s21, "s21");
                    printSeq(0, "call", Main.nameMap.get(s21), s21.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s21), s21.getClass().getSimpleName(), new String[]{""});
                    Immunity i21 = new Immunity();
                    nameMap.put(i21, "i21");
                    printSeq(0, "call", Main.nameMap.get(i21), i21.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(i21), i21.getClass().getSimpleName(), new String[]{""});

                    v42.MaterialPickedUp("nukleotid", 100);
                    v42.CraftAgent(v42, s21);
                    v43.UnderAttack(i21, v42);

                    System.out.println();
                    v42.UseAgent(s21, v43);
                    break;
                case 22: //Virologist steals Gloves
                    Virologist v1_22 = new Virologist();
                    nameMap.put(v1_22, "v1_22");
                    printSeq(0, "call", Main.nameMap.get(v1_22), v1_22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v1_22), v1_22.getClass().getSimpleName(), new String[]{""});

                    Virologist v2_22 = new Virologist();
                    nameMap.put(v2_22, "v2_22");
                    printSeq(0, "call", Main.nameMap.get(v2_22), v2_22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v2_22), v2_22.getClass().getSimpleName(), new String[]{""});

                    Gloves gear_22 = new Gloves();
                    nameMap.put(gear_22, "gloves_22");
                    printSeq(0, "call", Main.nameMap.get(gear_22), gear_22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(gear_22), gear_22.getClass().getSimpleName(), new String[]{""});

                    Stun s_22 = new Stun();
                    nameMap.put(s_22, "s_22");
                    printSeq(0, "call", Main.nameMap.get(s_22), s_22.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s_22), s_22.getClass().getSimpleName(), new String[]{""});
                    v2_22.UnderAttack(s_22, v2_22);
                    v2_22.ReceiveGear(gear_22);

                    System.out.println();

                    v1_22.Steal(v2_22, "Gear");
                    break;
                case 23: // Virologist steals Cloak
                    Virologist v1_23 = new Virologist();
                    nameMap.put(v1_23, "v1_23");
                    printSeq(0, "call", Main.nameMap.get(v1_23), v1_23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v1_23), v1_23.getClass().getSimpleName(), new String[]{""});

                    Virologist v2_23 = new Virologist();
                    nameMap.put(v2_23, "v2_23");
                    printSeq(0, "call", Main.nameMap.get(v2_23), v2_23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v2_23), v2_23.getClass().getSimpleName(), new String[]{""});

                    Cloak gear_23 = new Cloak();
                    nameMap.put(gear_23, "cloak_23");
                    printSeq(0, "call", Main.nameMap.get(gear_23), gear_23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(gear_23), gear_23.getClass().getSimpleName(), new String[]{""});

                    Stun s_23 = new Stun();
                    nameMap.put(s_23, "s_23");
                    printSeq(0, "call", Main.nameMap.get(s_23), s_23.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s_23), s_23.getClass().getSimpleName(), new String[]{""});
                    v2_23.UnderAttack(s_23, v2_23);
                    v2_23.ReceiveGear(gear_23);

                    System.out.println();


                    v1_23.Steal(v2_23, "Gear");
                    break;
                case 24: //Virologist steals Bag
                    Virologist v1_24 = new Virologist();
                    nameMap.put(v1_24, "v1_24");
                    printSeq(0, "call", Main.nameMap.get(v1_24), v1_24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v1_24), v1_24.getClass().getSimpleName(), new String[]{""});

                    Virologist v2_24 = new Virologist();
                    nameMap.put(v2_24, "v2_24");
                    printSeq(0, "call", Main.nameMap.get(v2_24), v2_24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v2_24), v2_24.getClass().getSimpleName(), new String[]{""});

                    Bag gear_24 = new Bag();
                    nameMap.put(gear_24, "bag_24");
                    printSeq(0, "call", Main.nameMap.get(gear_24), gear_24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(gear_24), gear_24.getClass().getSimpleName(), new String[]{""});

                    Stun s_24 = new Stun();
                    nameMap.put(s_24, "s_24");
                    printSeq(0, "call", Main.nameMap.get(s_24), s_24.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s_24), s_24.getClass().getSimpleName(), new String[]{""});
                    v2_24.UnderAttack(s_24, v2_24);
                    v2_24.ReceiveGear(gear_24);

                    System.out.println();

                    v1_24.Steal(v2_24, "Gear");
                    break;
                case 25: // Virologist steal material
                    Virologist v1_25 = new Virologist();
                    nameMap.put(v1_25, "v1_25");
                    printSeq(0, "call", Main.nameMap.get(v1_25), v1_25.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v1_25), v1_25.getClass().getSimpleName(), new String[]{""});
                    v1_25.SetAmountNucleotid(69);
                    v1_25.SetAmountAminoacid(21);

                    Virologist v2_25 = new Virologist();
                    nameMap.put(v2_25, "v2_25");
                    printSeq(0, "call", Main.nameMap.get(v2_25), v2_25.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v2_25), v2_25.getClass().getSimpleName(), new String[]{""});
                    v2_25.SetAmountNucleotid(69);
                    v2_25.SetAmountAminoacid(21);
                    Stun s_25 = new Stun();
                    nameMap.put(s_25, "s_25");
                    printSeq(0, "call", Main.nameMap.get(s_25), s_25.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s_25), s_25.getClass().getSimpleName(), new String[]{""});

                    v2_25.UnderAttack(s_25, v1_25);

                    System.out.println();

                    v1_25.Steal(v2_25, "Material");

                    break;
                case 26: //Dancing duration times out
                    Virologist v_26 = new Virologist();
                    Dancing da_26 = new Dancing();
                    nameMap.put(v_26, "v_26");
                    printSeq(0, "call", Main.nameMap.get(v_26), v_26.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v_26), v_26.getClass().getSimpleName(), new String[]{""});
                    nameMap.put(da_26, "da_26");
                    printSeq(0, "call", Main.nameMap.get(da_26), da_26.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(da_26), da_26.getClass().getSimpleName(), new String[]{""});
                    da_26.SetDurationTime(1);

                    System.out.println();

                    da_26.Time();
                    break;
                case 27: //Stunned duration times out
                    Virologist v_27 = new Virologist();
                    Stunned da_27 = new Stunned();
                    nameMap.put(v_27, "v_27");
                    printSeq(0, "call", Main.nameMap.get(v_27), v_27.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v_27), v_27.getClass().getSimpleName(), new String[]{""});

                    da_27.SetDurationTime(1);

                    System.out.println();

                    da_27.Time();
                    break;
                case 28: //Immune duration times out
                    Virologist v_28 = new Virologist();
                    Immune da_28 = new Immune();
                    nameMap.put(v_28, "v_28");
                    printSeq(0, "call", Main.nameMap.get(v_28), v_28.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v_28), v_28.getClass().getSimpleName(), new String[]{""});

                    da_28.SetDurationTime(1);

                    System.out.println();

                    da_28.Time();
                    break;
                case 29:
                    Virologist v58 = new Virologist();
                    nameMap.put(v58, "v58");
                    printSeq(0, "call", Main.nameMap.get(v58), v58.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v58), v58.getClass().getSimpleName(), new String[]{""});
                    Stun s58 = new Stun();
                    nameMap.put(s58, "s58");
                    printSeq(0, "call", Main.nameMap.get(s58), s58.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(s58), s58.getClass().getSimpleName(), new String[]{""});
                    v58.CraftAgent(v58, s58);
                    System.out.println();
                    v58.Time();
                    break;
                case 30:
                    Virologist v60 = new Virologist();
                    nameMap.put(v60, "v60");
                    printSeq(0, "call", Main.nameMap.get(v60), v60.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v60), v60.getClass().getSimpleName(), new String[]{""});
                    Dance d60 = new Dance();
                    nameMap.put(d60, "d60");
                    printSeq(0, "call", Main.nameMap.get(d60), d60.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(d60), d60.getClass().getSimpleName(), new String[]{""});
                    v60.CraftAgent(v60, d60);
                    System.out.println();
                    v60.Time();
                    break;
                case 31:
                    Virologist v62 = new Virologist();
                    nameMap.put(v62, "v62");
                    printSeq(0, "call", Main.nameMap.get(v62), v62.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v62), v62.getClass().getSimpleName(), new String[]{""});
                    Immunity i62 = new Immunity();
                    nameMap.put(i62, "i62");
                    printSeq(0, "call", Main.nameMap.get(i62), i62.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(i62), i62.getClass().getSimpleName(), new String[]{""});
                    v62.CraftAgent(v62, i62);
                    System.out.println();
                    v62.Time();
                    break;
                case 32:
                    Virologist v64 = new Virologist();
                    nameMap.put(v64, "v64");
                    printSeq(0, "call", Main.nameMap.get(v64), v64.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(v64), v64.getClass().getSimpleName(), new String[]{""});
                    Amnesia a64 = new Amnesia();
                    nameMap.put(a64, "a64");
                    printSeq(0, "call", Main.nameMap.get(a64), a64.getClass().getSimpleName(), new String[]{""});
                    printSeq(0, "answer", Main.nameMap.get(a64), a64.getClass().getSimpleName(), new String[]{""});
                    v64.CraftAgent(v64, a64);
                    System.out.println();
                    v64.Time();
                    break;
                default:
                    System.out.println("Rossz számot adtál meg");
                    break;
            }
        }
    }
}
