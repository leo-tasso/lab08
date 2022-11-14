package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File f = new File(HOME + File.separator + DEFAULT_FILE);

    public File getFile() {
        return f;
    }

    public void setFile(final File f) {
        this.f = f;
    }

    public String getPath() {
        return f.getPath();
    }

    public void write(String string) throws IOException {
        try (
                final BufferedWriter w = new BufferedWriter(new FileWriter(f))) {
            w.write(string);
            w.newLine();
        }
    }
}
