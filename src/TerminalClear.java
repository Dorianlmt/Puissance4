import java.io.IOException;

public class TerminalClear {

    public void clearTerminal() {
        String os = System.getProperty("os.name").toLowerCase();

        ProcessBuilder processBuilder;

        try {
            if (os.contains("win")) {
                // pour windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // pour linux/mac
                processBuilder = new ProcessBuilder("clear");
            }

            // execution
            processBuilder.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
