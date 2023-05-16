import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe para gerar arquivos de senha.
 */
public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // TROQUE O CAMINHO PARA O DIRETORIO DE DESTINO DOS SEUS ARQUIVOS
  public static final String DIRETORIO_DESTINO = "/home/alexsandro/Documentos/exer-java/"
      + "3-Input-output-file/acc-java-08-exercises-gerador-senhas/src/main/"
      + "java/com/trybe/acc/java/geradorsenhas";

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    GeradorSenhas gerador = new GeradorSenhas();

    for (int i = 0; i < NUM_SENHAS; i++) {

      File arquivo = new File(DIRETORIO_DESTINO + File.separator + "arquivo_" + i + ".txt");
      String senha = gerador.gerarSenhaCompleta(i);

      try {
        gerador.escreverSenhaNoArquivo(senha, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Recebe uma senha e a escreve em arquivo.
   */
  public void escreverSenhaNoArquivo(String senha, File arquivo) throws IOException {

    FileWriter writer;
    BufferedWriter bufferedWriter;

    try {
      writer = new FileWriter(arquivo);
      bufferedWriter = new BufferedWriter(writer);

      bufferedWriter.write(senha);
      bufferedWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gera senha completa a partir do índice.
   */
  public String gerarSenhaCompleta(int indice) {
    String[] correspondence = new String[]{
      "A5$2", "B55S", "CFFG", "D&54", "EEDF", "FEGG", "G15E", "H123", "I81F", "JWEF"
    };
    String defaulPatern = "####";

    if (correspondence.length <= indice + 1) {
      return correspondence[indice] + defaulPatern;
    }

    if (correspondence.length < indice) {
      return defaulPatern + defaulPatern;
    }

    return correspondence[indice] + correspondence[indice + 1];
  }
}
