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
    private List<String> history;

    public SimpleController() {
        history = new ArrayList<>();
    }

    public void setnext(final String s) {
        Objects.requireNonNull(s);
        this.next = s;
    }

    public String getnext() {
        return this.next;
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void print() {
        if (this.next.equals(null)) {
            throw new IllegalStateException();
        } 
        history.add(this.next);
        System.out.println(this.next);
    }
}
