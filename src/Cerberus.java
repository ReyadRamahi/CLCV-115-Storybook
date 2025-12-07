import java.util.*;

public class Cerberus {
    private final Orpheus orpheus;
    private final Scanner scan;

    public Cerberus(Orpheus orpheus, Scanner scan) {
        this.orpheus = orpheus;
        this.scan = scan;
        encounterCerberus();
    }

    private void encounterCerberus() {
        System.out.println(
                """
                        You stand at the next gate of the Underworld. The passage is narrow and dark, and the sound of claws scraping stone echoes through the tunnel.
                        
                        At the end of the path you see Cerberus, the great hound who guards this place. Three heads watch you from the shadows. Each one growls softly, ready to block anyone who tries to pass.
                        """
        );

        showInventory();

        Map<Integer, String> actions = buildActions();

        if (actions.isEmpty()) {
            System.out.println(
                    """
                            You look at what you are carrying and realize you have nothing that might help you get past a guardian like this.
                            
                            Cerberus lowers his heads and blocks the entire passage. You cannot move forward and there is no safe way back.
                            
                            Your journey ends here.
                            """
            );
            return;
        }

        System.out.println("How will you try to get past Cerberus?");
        for (Map.Entry<Integer, String> entry : actions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        int choice = readIntChoice(actions.keySet());

        String action = actions.get(choice);
        resolveAction(action);
    }

    private void showInventory() {
        System.out.println();
        System.out.println("You check what you are carrying:");
        boolean hasAny = false;

        if (orpheus.hasSword()) {
            System.out.println("- Sword");
            hasAny = true;
        }
        if (orpheus.hasTorch()) {
            System.out.println("- Torch");
            hasAny = true;
        }
        if (orpheus.hasCoin()) {
            System.out.println("- Coin");
            hasAny = true;
        }
        if (orpheus.hasLyre()) {
            System.out.println("- Lyre");
            hasAny = true;
        }
        if (orpheus.getGoldenBough()) {
            System.out.println("- Golden Bough");
            hasAny = true;
        }
        if (orpheus.hasMirror()) {
            System.out.println("- Mirror");
            hasAny = true;
        }

        if (!hasAny) {
            System.out.println("- Nothing helpful");
        }

        System.out.println();
    }

    private Map<Integer, String> buildActions() {
        Map<Integer, String> actions = new LinkedHashMap<>();
        int option = 1;

        if (orpheus.getGoldenBough()) {
            actions.put(option++, "Show the Golden Bough and hope Cerberus respects it.");
        }

        if (orpheus.hasLyre()) {
            actions.put(option++, "Play the lyre to try to calm Cerberus.");
        }

        if (orpheus.hasTorch()) {
            actions.put(option++, "Raise the torch and try to scare Cerberus back.");
        }

        if (orpheus.hasMirror()) {
            actions.put(option++, "Hold up the mirror to distract Cerberus.");
        }

        if (orpheus.hasSword()) {
            actions.put(option++, "Draw your sword and try to fight your way past.");
        }

        return actions;
    }

    private int readIntChoice(Set<Integer> validChoices) {
        while (true) {
            System.out.print("Enter a choice number: ");
            String line = scan.nextLine().trim();

            int value;
            try {
                value = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            if (!validChoices.contains(value)) {
                System.out.println("That is not one of the options. Try again.");
                continue;
            }

            return value;
        }
    }

    private void resolveAction(String action) {
        System.out.println();

        if (action.startsWith("Show the Golden Bough")) {
            System.out.println(
                    """
                            You hold up the Golden Bough so that all three heads can see it. The leaves shine softly in the dark tunnel.
                            
                            Cerberus stops growling. The eyes of the great hound follow the light of the branch instead of your movements. After a long moment, the creature steps aside and leaves a clear opening in the passage.
                            
                            You walk past carefully, keeping the branch raised until the guardian is behind you.
                            """
            );
        } else if (action.startsWith("Play the lyre")) {
            System.out.println(
                    """
                            You lift the lyre and begin to play a slow, steady song. The notes echo through the tunnel and fill the space around you.
                            
                            The growling fades. The three heads of Cerberus tilt slightly as they listen. The hound lies down at the edge of the path, still watching, but no longer blocking the way.
                            
                            You keep playing as you move past, then let the last note fade once you are safely beyond the gate.
                            """
            );
        } else if (action.startsWith("Raise the torch")) {
            System.out.println(
                    """
                            You raise the torch high and bring the flame closer to Cerberus. The fire makes the shadows jump along the tunnel walls.
                            
                            The hound pulls back a little and narrows his eyes at the light. He does not like the fire, but he does not run from it either. After a tense moment, he shifts to the side just enough for you to slip by along the wall.
                            
                            You move quickly and keep the torch between you and the guardian until you are past him.
                            """
            );

        } else if (action.startsWith("Hold up the mirror")) {
            System.out.println(
                    """
                            You hold up the mirror so that Cerberus can see his own reflection. The three heads pause and stare at the image in the glass.
                            
                            The hound seems confused for a moment. The growling softens as he focuses on the strange double image of teeth and eyes. While he is distracted, you walk around the edge of the tunnel and pass by him as quietly as you can.
                            
                            Once you are safely past, you lower the mirror and keep moving forward.
                            """
            );

        } else if (action.startsWith("Draw your sword")) {
            System.out.println(
                    """
                            You draw your sword and step toward Cerberus. The three heads immediately bare their teeth and the growling becomes much louder.
                            
                            You swing once, but the hound is faster and stronger than you expected. The massive body slams you back against the stone. Your weapon falls from your hand and the tunnel spins around you.
                            
                            Your strength leaves you in a rush. The last thing you hear is the echo of the guardian's growl as the Underworld closes around you.
                            
                            Your journey ends here.
                            """
            );
        }
    }
}