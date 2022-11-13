package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setnext(String nexString);

    public String getnext();

    public List<String> getHistory();

    public void print();

}
