import java.util.Scanner;

public class Hades {
    private Orpheus orpheus;
    private Scanner scan;

    public Hades(Orpheus orpheus, Scanner scan) {
        this.orpheus = orpheus;
        this.scan = scan;
        encounterHades();
    }

    private void encounterHades() {
        System.out.println(
                """
You enter a wide stone hall inside the Underworld. At the far end sit Hades and Persephone on dark thrones. The air is quiet and heavy and every step you take seems to echo.

You do the only thing you truly know how to do. You raise your voice and begin to sing. Your song tells the story of Eurydice, of your life together, and of how quickly she was taken from you.

The music fills the hall. Spirits grow still. Even the guards listen. When you finish, the room stays silent for a long moment.
"""
        );

        System.out.println(
                """
Hades finally speaks. He says your song is strong and honest. He says very few living people have ever reached this place and even fewer have moved his court to listen.

As a sign of respect, he offers you a small dish of food from his table. The fruit looks simple, but the scent is strong and sweet. He tells you that you may eat if you wish.
"""
        );

        int choice = askFoodChoice();

        if (choice == 1) {
            eatFoodOutcome();
        } else {
            refuseFoodOutcome();
        }
    }

    private int askFoodChoice() {
        System.out.println(
                """
What will you do?

1: Eat the food that Hades offers.
2: Refuse the food and ask only for Eurydice.
"""
        );

        while (true) {
            System.out.print("Enter 1 or 2: ");
            String line = scan.nextLine().trim();

            int value;
            try {
                value = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            if (value == 1 || value == 2) {
                return value;
            } else {
                System.out.println("That is not a valid choice. Try again.");
            }
        }
    }

    private void eatFoodOutcome() {
        System.out.println(
                """
You accept the dish and eat the food from Hades' table. The taste is rich and strange. For a moment, it makes you feel calm and heavy at the same time.

Hades watches you closely and then nods. He explains that anyone who eats the food of the Underworld is tied to this realm. The choice cannot be undone.

Your body will not return to the world above. Your music and your story now belong to the land of the dead. Eurydice remains here as well, but you will not walk beside her in the light again.

Your journey is over. You are now one more soul in the kingdom below.
"""
        );
    }

    private void refuseFoodOutcome() {
        System.out.println(
                """
You bow your head and refuse the food. You explain that you do not want any reward or comfort. You want only a chance to bring Eurydice back to the world of the living.

Hades studies your face. Persephone watches quietly. After a moment, they agree to your request. They will allow Eurydice to follow you out of the Underworld, but there is one condition.

You must walk in front of her on the way back. You must trust that she is behind you and you must not look back at her until both of you have stepped into the world above. If you turn around too soon, she will remain here forever.
"""
        );

        orpheus.setEurydice(true);
    }
}
