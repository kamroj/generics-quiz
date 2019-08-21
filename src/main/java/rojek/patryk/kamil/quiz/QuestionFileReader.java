package rojek.patryk.kamil.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import rojek.patryk.kamil.Main;

class QuestionFileReader {
  private final String fileName;
  private BufferedReader bufferedReader;

  QuestionFileReader(String fileName) {
    this.fileName = fileName;
    bufferedReader = new BufferedReader(getInputStreamReader());
  }

  String readLine() throws IOException {
    return bufferedReader.readLine();
  }

  private InputStreamReader getInputStreamReader() {
    InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream(fileName);
    return new InputStreamReader(Objects.requireNonNull(resourceAsStream), StandardCharsets.UTF_8);
  }
}
