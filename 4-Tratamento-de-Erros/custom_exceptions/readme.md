# Exceção customizada

A classe `Show`, trata diversas regras de negócio, entre as quais a permissão de entrada das pessoas no evento. Neste desafio, o show em questão só permite a entrada de pessoas maiores de 18 anos.

Dentro dela existe um método chamado `permitirEntrada`, que recebe um parâmetro do tipo `int` representando a idade da pessoa.

O desafio aqui é criar e lançar uma exceção customizada para tratar esse erro de forma específica. A exceçẽo é chamada de `PessoaMenorDeIdadeException`, que herda de `Exception` e é do tipo `checked`. Depois de criada a exceção, a classe `Show` é alterada, mudando o método `permitirEntrada` para que a exceção customizada seja lançada caso a pessoa seja menor de 18 anos.
