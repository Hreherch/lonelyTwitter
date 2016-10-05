package ca.ualberta.cs.lonelytwitter;

/**
 * A happier implementation of the Mood class. Typically users ignore this type of Mood because
 * it does not need as much attention as a SadMood however it also seems to carry some emotional
 * baggage.
 * @see SadMood
 */
public class HappyMood extends Mood {

    /**
     * Returns a string representation of a happy mood.
     *
     * @return a string representation that represents all HappyMoods
     */
    public String expressMood() {
        return "I'm happy, I guess...";
    }

}
