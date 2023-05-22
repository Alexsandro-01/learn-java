## Tratando erro ao ler arquivo

Dentro da classe `FileReaderUtils` existe o método `getLines()`, que faz a abertura e leitura de um arquivo que não existe. Esse método lança a exceção `FileNotFoundException`. Esse método foi preparado para, em vez de lançar a exceção, tratar esse erro e retornar um valor do tipo `String` contendo "Arquivo não existe".
