package it.unibo.mvc;

/**
 * Encapsulates the concept of configuration.
 */
public final class Configuration {

    private int max;
    private int min;
    private int attempts;
/** 
 * Initilizes the configuration.
 * @param max the max
 * @param min the min
 * @param attempts the max number of attempts
 * 
*/
    public Configuration(final int max, final int min, final int attempts) {
        this.max = max;
        this.min = min;
        this.attempts = attempts;
    }
/**
 * sets the max.
 * @param max
 */
    public void setMax(final int max) {
        this.max = max;
    }
/**
 * Sets the min.
 * @param min
 */
    public void setMin(final int min) {
        this.min = min;
    }
/**
 * sets the attempts number.
 * @param attempts
 */
    public void setAttempts(final int attempts) {
        this.attempts = attempts;
    }
/**
 * 
 * @return the max.
 */
    public int getMax() {
        return max;
    }
/**
 * 
 * @return the min.
 */
    public int getMin() {
        return min;
    }
/**
 * 
 * @return the attempts.
 */
    public int getAttempts() {
        return attempts;
    }

}
