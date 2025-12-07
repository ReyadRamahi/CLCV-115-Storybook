import java.util.Scanner;

public class Avernus {
    Orpheus orpheus;
    public Avernus(Orpheus orpheus) {
        this.orpheus = orpheus;
    }
    private void boughCheck() {
        if(orpheus.getGoldenBough()) {
            System.out.println(
                    """
            You reach the entrance to the Underworld. The cave feels cold and quiet, and living people do not normally pass through this place.
            
            You lift the Golden Bough and hold it in the open. The leaves shine with a soft light and nearby spirits stop moving when they see it. They recognize the branch and do not block you.
            
            With the Bough in your hand, the gate opens without trouble. Nothing tries to stop you or slow your steps. It feels as if a very old rule is being followed.
            
            You descend safely into the Underworld until you reach a quiet river. A ferryman waits with a wooden boat.
            """
            );

        } else {
            System.out.println(
                    """
            You reach the entrance to the Underworld, but the gate does not open for you. The air grows colder and shadows gather around you. Spirits stand nearby and watch you closely.
            
            A guardian appears and explains that only someone with the sacred branch may enter while still alive. You look through your belongings, but the Golden Bough is not there.
            
            The gate remains shut. You return to the altar where you first chose your items, hoping to find the branch again. It is gone and no one answers your questions.
            
            Without the Golden Bough, you cannot continue your journey. Your story ends before you descend any farther.
            """
            );
        }
    }
}
