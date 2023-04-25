# Tipos primitivos em Java

| Tipo    | Primitivo | 	Valor padrão de inicialização	 | Tamanho | 	Limite de armazenamento                                  |
|---------|-----------|---------------------------------|---------|-----------------------------------------------------------|
 | byte    | 	0        | 	1                              | byte    | 	-128 até 127                                             |
| short   | 	0	       | 2                               | byte	   | -32,768 até 32,767                                        |
| int     | 	0        | 	4                              | byte    | 	-2,147,483,648 até 2,147,483, 647                        |
| long    | 	0L       | 	8                              | byte    | 	-9,223,372,036,854,775,808 até 9,223,372,036,854,775,807 |
| float	  | 0.0f      | 	4                              | byte    | 	-1.4E-45 até 3.4028235E38                                |
| double  | 	0.0d     | 	8                              | byte    | 	-4.9E-324 até 1.7976931348623157E308                     |
 | char    | 	'\u0000' | 	2                              | byte    | 	0 até 65535                                              |
 | boolean | 	false    | 	1                              | bit	    | true ou false                                             |

#

A partir do Java 1.7 (2011), números podem conter o símbolo _ (underscore) para facilitar a leitura. É isso que estamos fazendo com a variável formatadaComUnderscore. Para saber mais sobre o uso do underscore, acesse Underscores in Numeric Literals.

```java
public class TiposPrimitivos {

    public static void main(String[] args) {
        short num = 300;
        short formatadaComUnderscore = 20_000; // variável 
        System.out.println(num);
        System.out.println(formatadaComUnderscore); // 20000
    }
}
```

## Concatenação de Strings

E você pensa: “Opa! Então quer dizer que podemos concatenar Strings apenas com o sinal de adição + e seguir em frente, certo!?” E a resposta é: não é bem assim! 🤭

Se liga na forma com que as Strings são armazenadas na memória: para cada concatenação, o Java vai criar um novo espaço em memória com o novo valor. Então, no caso do exemplo anterior, teremos 7 variáveis em memória para armazenar uma única frase — um baita desperdício, não acha?! Portanto, adicionar Strings não é uma prática recomendada. Isso vai fazer ainda mais sentido quando você estiver envolvido em projetos com Java.

“Ok, mas… como fazer, então?” Vamos utilizar uma classe especial, chamada String Builder! Veja uma nova versão do exemplo no código abaixo:

```java
public class ObjetosString {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String eu = "Eu";
        String ja = " já";
        String sei = " sei";
        String usar = " usar";
        String strings = " Strings";
        String em = " em";
        String java = " Java";

        String frase = stringBuilder.append(eu)
                .append(ja)
                .append(sei)
                .append(usar)
                .append(strings)
                .append(em)
                .append(java)
                .toString();
        System.out.println(frase); // Eu já sei usar Strings em Java
    }
}
```

A diferença aqui é o StringBuilder do pacote java.lang. O StringBuilder é uma classe especial para lidar com concatenação de Strings e, utilizando seu método append, conseguimos fazer isso sem desperdício de memória!