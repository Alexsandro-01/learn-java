## Concessionária de automóveis

A classe instanciável chamada `OperacoesVeiculos` contém os seguintes métodos:

1. `<T> int numVeiculosDiferentesVendidos(Stream<T> veiculosVendidos)`
Essa operação recebe um `Stream` de veículos vendidos, e confiando no `equals()` do tipo `Veiculo`, mesmo sem conhecê-lo, para dizer **quantos veículos diferentes foram vendidos** nesse conjunto.

2. `<T> Stream<String> obterRepresentacao(Stream<T> veiculos)`
Essa operação recebe um `Stream` de veículos, e o método retorna um `Stream` do mesmo tamanho, mas de `String`, em que cada item é a representação de um veículo através da chamada do `toString()`. Todos os objetos em Java possuem o método `toString()`.

3. `<T> List<T> obterLista(Stream<T> veiculos)`
A operação `obterLista` apenas retorna um `List` com os mesmos elementos do `Stream` passado como parâmetro.

---