import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe do desafio.
 */
public class FileReaderUtils {

  /**
   * Retorna a primeira linha de um arquivo.
   */
  public String getFirstLine() throws FileNotFoundException {
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new FileReader("arquivo_nao_existente.txt"));
      return reader.lines().findFirst().get();

    } catch (FileNotFoundException exception) {
      return "Arquivo não existe";

    } finally {
      if (reader != null) {
        try {
          reader.close();

        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }

}
