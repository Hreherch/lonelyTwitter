package ca.ualberta.cs.lonelytwitter;

/**
 * A sad implementation of the abstract base class Mood. This mood carries more than the regular
 * amount of emotional baggage as noted by the ellipse in the abstract method.
 * @see Mood
 */
public class SadMood {

    /**
     * SadMood implementation of the abstract expressMood which returns a string expressing SadMood.
     *
     * @return the string that specifically expresses SadMood.
     */
    public String expressMood() {
        return "I'm sad, I guess...";
    }
}
