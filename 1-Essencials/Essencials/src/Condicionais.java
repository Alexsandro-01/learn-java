public class Condicionais {

  public static void main(String[] args) {
    // Cria um array com os inscritos
    String[] subscribers = { "MARCOS", "ALINE", "LUCAS", "PATRICIA", "JOAO", "FELIPE", "LUCIA", "ANTONIO", "FERNANDA",
      "MARCELA", "VITOR", "BEATRIZ", "JORGE", "JULIA" };

    // Determina o número máximo de vagas
    final int vacanciesNumber = 10;
    // A palavra `final` determina que o valor dessa variável não é alterável, ele
    // passa a ser uma constante!

    // Criamos um vetor vazio com espaço igual ao número de vagas. Não se preocupe
    // se não entender a sintaxe 100% — em breve entenderá!
    String[] vacancies = new String[vacanciesNumber];

    // Determinamos quantas vagas já foram preenchidas
    int currentVacancy = 0;

    // Percorremos todos inscritos e adicionamos nas vagas até que o número
    // total de vagas seja preenchido
    String subscriber = "Indefinido";
    String log;

    while (currentVacancy < vacanciesNumber) {
      subscriber = subscribers[currentVacancy];

      log = "Adicionando a inscrição " + subscriber + " Na vaga: "
        + (currentVacancy + 1) + "\n";

      vacancies[currentVacancy] = subscriber;
      currentVacancy += 1;

      System.out.println(log);
    }
  }
}
