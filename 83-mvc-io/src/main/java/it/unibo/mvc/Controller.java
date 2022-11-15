package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * sets next string to print.
     * @param nexString the string to print.
     */
     void setnext(String nexString);
     /**
      * returns the next string to print.
      * @return the next strig to print.
      */
     String getnext();
    /**
     * returns a list of the printed strings.
     * @return a list of the printed strings.
     */
     List<String> getHistory();

     /**
      * prints the staged string.
     */
     void print();

}
