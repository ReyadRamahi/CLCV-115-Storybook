import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Intro {
    Orpheus orpheus;
    Scanner scan;
    public Intro(int outcome, Orpheus orpheus, Scanner scan) {
        this.orpheus = orpheus;
        this.scan = scan;
        if (outcome == 1) {
            firstOutcome();
            orpheus.setEntrance("Mount Chelmos");
        } else if (outcome == 2) {
            secondOutcome();
            orpheus.setEntrance("Lake Avernus");
        }
    }

    private void firstOutcome() {
        System.out.println(
                """
        After a long, tiring climb, you reach the peak of Mount Chelmos.
        The air is thin and cold, and the sound of rushing water grows louder with every step.
        
        In front of you, a huge waterfall crashes down into a dark pool below. The mist soaks your clothes
        and clings to your skin, but you don’t turn back. You know this is one of the secret entrances to the Underworld.
        
        Behind the wall of water, you can see the outline of a narrow cave. That cave will take you down into the land of the dead.
        
        Before you step through the falls, you notice a flat stone altar nearby. On it, five objects are laid out as if they were waiting just for you:
        1: a sword, its blade chipped but still sharp
        2: a torch, bound with old cloth, ready to be lit
        3: a coin, heavy and stamped with the face of a stern man
        4: a lyre, simple but well-tuned
        5: A golden bough, a small branch preserved in glowing amber leaves\s
        6: a mirror, small and polished like still water
        
        A quiet voice seems to echo in your mind: "The living may not take much into the land of the dead. Choose only three."
        
        Which three do you take with you before you step through the waterfall and descend into the Underworld?
        
        (enter three numbers separated by spaces)
        1 = Sword, 2 = Torch, 3 = Coin, 4 = Lyre, 5 = Golden Bough, 6 = Mirror"""
        );
        selectItems();
    }
    private void secondOutcome() {
        System.out.println(
                """
        After leaving the chaos of the wedding behind, you travel for hours until the land grows quiet and the air turns heavy.
        The ground is dark and cracked, and the smell of sulfur hits your nose.
        
        At last, you arrive at Lake Avernus, a still, dark body of water that barely reflects the sky.
        A thin layer of mist floats over the surface, and the world feels strangely silent here, as if sound itself is afraid to move.
        
        Ancient stories say this lake is a gate to the Underworld. Standing on its shore, you finally believe them.
        Every part of you is telling you to go back, but you keep walking forward.
        
        Near the edge of the water, you see a low stone platform. On top of it, arranged in a neat line, are five objects:
        1: a sword, its blade chipped but still sharp
        2: a torch, bound with old cloth, ready to be lit
        3: a coin, heavy and stamped with the face of a stern man
        4: a lyre, simple but well-tuned
        5: A golden bough, a small branch preserved in glowing amber leaves
        6: a mirror, small and polished like still water
        
        The air around you seems to whisper: "Only the prepared may cross. The river takes what it wants, but you may carry only three."
        
        Somewhere out on the lake, you think you can hear the creak of a wooden oar. Your time to choose is running out.
        
        Which three items will you take with you before you call for passage and cross into the Underworld?
        
        (enter three numbers separated by spaces)
        1 = Sword, 2 = Torch, 3 = Coin, 4 = Lyre, 5 = Golden Bough, 6 = Mirror"""
        );
        selectItems();
    }

    private void selectItems() {
        Map<Integer, String> itemNames = new HashMap<>(Map.of(
                1, "Sword",
                2, "Torch",
                3, "Coin",
                4, "Lyre",
                5, "Golden Bough",
                6, "Mirror"
        ));

        while (true) {
            System.out.print("Enter three item numbers separated by spaces: ");
            String input = scan.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length != 3) {
                System.out.println("Please enter exactly three numbers.");
                continue;
            }

            orpheus.setSword(false);
            orpheus.setTorch(false);
            orpheus.setCoin(false);
            orpheus.setLyre(false);
            orpheus.setGoldenBough(false);
            orpheus.setMirror(false);

            StringBuilder picked = new StringBuilder("You picked: ");
            boolean valid = true;
            boolean[] used = new boolean[7];

            for (String p : parts) {
                int choice;

                try {
                    choice = Integer.parseInt(p);
                } catch (NumberFormatException e) {
                    System.out.println("Choices must be numbers between 1 and 6.");
                    valid = false;
                    break;
                }

                if (!itemNames.containsKey(choice)) {
                    System.out.println("Invalid choice: " + choice + ". Please use numbers 1–6.");
                    valid = false;
                    break;
                }

                if (used[choice]) {
                    System.out.println("You cannot pick the same item more than once.");
                    valid = false;
                    break;
                }
                used[choice] = true;

                picked.append(itemNames.get(choice)).append(", ");

                switch (choice) {
                    case 1 -> orpheus.setSword(true);
                    case 2 -> orpheus.setTorch(true);
                    case 3 -> orpheus.setCoin(true);
                    case 4 -> orpheus.setLyre(true);
                    case 5 -> orpheus.setGoldenBough(true);
                    case 6 -> orpheus.setMirror(true);
                }
            }

            if (!valid) {
                continue;
            }

            picked.setLength(picked.length() - 2);
            System.out.println(picked + ". Proceed? (Y/N)");

            String confirm = scan.nextLine().trim();
            if (confirm.equalsIgnoreCase("Y")) {
                break;
            } else {
                System.out.println("Okay, choose again.\n");
            }
        }
    }
}