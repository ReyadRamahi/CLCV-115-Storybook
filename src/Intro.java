public class Intro {
    private int choice;
    public Intro(int choice){
        this.choice = choice;
    }
    public static void outcome(Intro i) {
        if(i.choice == 1) Intro.firstOutcome();;
        if(i.choice == 2) Intro.secondOutcome();;
    }
    private void firstOutcome() {
        System.out.println("Afer an Arduos journey you make your way to the peak of Mount Chelmos. Its mighty waterfall thunders down onto the rocks below. " +
                "It seems the gods have shared their favor with you. Before entering you see 6 objects. A sword, torch, coin, lyre, and mirror. Which do you choose? " +
                "\n 1: Sword \n 2: Torch \n 3: coin \n 4: Lyre
        )
    }
}
