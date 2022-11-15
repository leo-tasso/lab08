package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String next;
    private final List<String> history;

    /**
     * construcotr to initialize the history.
     */
    public SimpleController() {
        history = new ArrayList<>();
    }

    @Override
    public void setnext(final String s) {
        Objects.requireNonNull(s);
        this.next = s;
    }

    @Override
    public String getnext() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void print() {
        if (this.next == null) {
            throw new IllegalStateException();
        }
        history.add(this.next);
        System.out.println(this.next); // NOPMD
    }
}
