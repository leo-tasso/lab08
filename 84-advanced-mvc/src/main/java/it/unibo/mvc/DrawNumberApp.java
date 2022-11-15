package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {
    private static final int MAXANDMINCHARS = 9;

    private final Configuration c = new Configuration(0, 100, 10);

    private final DrawNumber model;
    private final List<DrawNumberView> views;

    /**
     * @param views
     *              the views to attach
     * @throws IOException
     * @throws FileNotFoundException
     * @param path the path of the config
     */
    public DrawNumberApp(final String path, final DrawNumberView... views) throws FileNotFoundException, IOException {
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream(path), StandardCharsets.UTF_8))) {
            String[] s = new String[3];
            for (int i = 0; i < 3; i++) {
                s[i] = r.readLine();
                if (s[i].startsWith("minimum: ")) {
                    c.setMin(Integer.parseInt(s[i].substring(MAXANDMINCHARS)));
                } else if (s[i].startsWith("maximum: ")) {
                    c.setMax(Integer.parseInt(s[i].substring(MAXANDMINCHARS)));
                } else if (s[i].startsWith("attempts: ")) {
                    c.setAttempts(Integer.parseInt(s[i].substring(10)));
                } else {
                    throw new IllegalStateException("config file content not recognized");
                }
            }
        }
        /*
         * Side-effect proof
         */
        this.views = Arrays.asList(Arrays.copyOf(views, views.length));
        for (final DrawNumberView view : views) {
            view.setObserver(this);
            view.start();
        }
        this.model = new DrawNumberImpl(c.getMin(), c.getMax(), c.getAttempts());
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view : views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view : views) {
                view.numberIncorrect();
            }
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        /*
         * A bit harsh. A good application should configure the graphics to exit by
         * natural termination when closing is hit. To do things more cleanly, attention
         * should be paid to alive threads, as the application would continue to persist
         * until the last thread terminates.
         */
        System.exit(0);
    }

    /**
     * @param args
     *             ignored
     * @throws IOException
     */
    public static void main(final String... args) throws IOException {

        new DrawNumberApp("config.yml", new DrawNumberViewImpl(), new DrawNumberViewImpl(),
                new PrintStreamView(System.out), new PrintStreamView("output.log"));
    }

}
