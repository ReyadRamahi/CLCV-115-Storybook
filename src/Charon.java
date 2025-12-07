import java.util.Scanner;

public class Charon {
    Orpheus orpheus;

    public Charon(Orpheus orpheus) {
        this.orpheus = orpheus;
        encounterCharon();
    }

    private void encounterCharon() {

        System.out.println(
                """
                You stand upon the shore of a black and silent river. The water carries a slow current that seems to draw every voice downward into the darkness. Pale figures gather near you in long rows, each soul unable to pass without the ferryman’s approval. They are trapped between life and death with no path to either.
                
                A worn wooden boat floats upon the water and a solitary ferryman stands at the stern. His face is unreadable and his hands do not shake or tire. He watches you as if he has seen countless mortals arrive, each with different hopes for what lies beyond.
                """
        );

        if (!orpheus.hasCoin()) {
            System.out.println(
                    """
            You arrive at a dark river where a ferryman waits in a wooden boat. Many spirits stand all around you, waiting for someone to carry them across.
            
            You step toward the boat, but you do not have a coin to offer. The ferryman cannot take you without payment, and this rule has never changed.
            
            You cannot return to the world of the living and you cannot travel deeper into the Underworld. You remain on this shore with the spirits who wait without end.
            
            Your journey ends here.
            """
            );
            return;
        }
        System.out.println(
                """
        You hold out your golden coin. The ferryman accepts it and allows you to step into the boat. The river is quiet as he rows to the other side.
        
        When you reach the far bank, the stone passage grows darker. A deep growl rises from the tunnel. Three heads lift from the shadows and watch you closely.
        
        You have arrived before Cerberus, the guardian of the inner gate.
        """
        );

    }
}
