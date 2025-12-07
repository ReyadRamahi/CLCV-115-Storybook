import java.util.Scanner;

public class Conclusion {
    private Orpheus orpheus;
    private Scanner scan;

    public Conclusion(Orpheus orpheus, Scanner scan) {
        this.orpheus = orpheus;
        this.scan = scan;
        runEnding();
    }

    private void runEnding() {
        if (!orpheus.hasEurydice()) {
            System.out.println(
                    """
You leave the Underworld alone. The journey back feels quiet and long. The sunlight is bright when you reach the upper world, but it does not feel warm.

Eurydice remains where you could not reach her. Your story continues, but not the way you wished.
"""
            );
            return;
        }

        System.out.println(
                """
You walk out of the Underworld first and feel fresh air on your face. The ground beneath you feels real and solid again. For a moment, you stand still and listen carefully.

Eurydice steps out behind you. She is quiet and seems unsure where to place her feet. She has only just crossed the boundary into the world above. The light feels new and strange to her.
"""
        );

        System.out.println(
                """
You now have a decision to make.

1: Keep walking toward home so Eurydice can settle fully into the living world.
2: Turn back and run to hug Eurydice right away.
"""
        );

        int choice = readChoice();

        if (choice == 1) {
            successEnding();
        } else {
            failEnding();
        }
    }

    private int readChoice() {
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

    private void successEnding() {
        System.out.println(
                """
You continue walking toward home, even though every part of you wants to turn around and hold Eurydice as tightly as you can.

As you move forward, her footsteps grow stronger and more confident. She walks beside you instead of behind you. The Underworld has no hold on her anymore.

You do not rush. You take your time, step by step, until you reach familiar fields and roads. For the first time since her death, Eurydice walks freely in the sunlight.

You have done something that almost no one has ever done. You entered the Underworld and returned with someone you loved. Your story continues with her at your side.
"""
        );
    }

    private void failEnding() {
        System.out.println(
                """
You cannot stop yourself. The moment Eurydice steps into the light, you turn around and rush toward her to hug her.

But she has only just crossed the boundary. She is still at the very edge between two worlds. Your sudden movement surprises her and she loses her footing.

Her body fades backward into the darkness as if she were being pulled by a strong current. The ground where she stood becomes empty again. You reach out to grab her, but there is nothing to hold.

You are now alone in the world above. Eurydice remains in the Underworld, and the chance to save her has passed.
"""
        );
    }
}
