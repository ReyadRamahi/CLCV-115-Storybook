import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scan();
        System.out.println("The wedding party erupts in chaos. In the midst, of all the comotion you hear your father in law to be " +
                "saying something. \"Orpheus, Eurydice has fallen to a snakes venom!\". Without a second thought you make your way to the underworld" +
                "hoping to bargain for your lovers life back \n" + "How do you get there?");
        int options = 0;
        System.out.println("1: Mount Chelmos (Waterfall ");
        System.out.println("2: Lake Avernus (Volcanic River)");
        int answer = scan.nextInt();
        if(answer != 1 && answer != 2){
            System.out.println("The path you seek does not exist. Reconsider your actions");
        }

    }
}