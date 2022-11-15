package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File f = new File(HOME + File.separator + DEFAULT_FILE);

    /**
     * @return the selected file
     */
    public File getFile() {
        return f;
    }

    /**
     * sets the selected file.
     * 
     * @param f the file to set
     */
    public void setFile(final File f) {
        this.f = f;
    }

    /**
     * @return the selected path
     */
    public String getPath() {
        return f.getPath();
    }

    /**
     * writes the string to file.
     * 
     * @param string the string to save
     */
    public void write(final String string) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(f, StandardCharsets.UTF_8))) {
            w.write(string);
            w.newLine();
        }
    }
}
