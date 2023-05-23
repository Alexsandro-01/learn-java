# Praticando a criação de *streams*

Para poder transformar a entrada em *streams*, temos a classe utilitária pública e instanciável chamada `CriadorStream`.

Essa classe tem os seguintes métodos:

1. `<T> Stream<T> criarDoItem(T item)`
2. `<T> Stream<T> criarDoArray(T[] array)`
3. `<T> Stream<T> criarDaLista(List<T> lista)`

Para cada método, há um `Stream` de acordo com o parâmetro recebido. Os *generics* definidos na própria assinatura do método são para que o `Stream` de retorno tenha o mesmo tipo do objeto que é passado como parâmetro.

---
