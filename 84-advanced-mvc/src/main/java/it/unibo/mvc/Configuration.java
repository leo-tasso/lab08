package it.unibo.mvc;


/**
 * Encapsulates the concept of configuration.
 */
public final class Configuration {

    private  int max; 
    private  int min;
    private  int attempts;
    public Configuration(int max, int min, int attempts) {
        this.max = max;
        this.min = min;
        this.attempts = attempts;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public int getMax() {
        return max;
    }
    public int getMin() {
        return min;
    }
    public int getAttempts() {
        return attempts;
    }
    
}

