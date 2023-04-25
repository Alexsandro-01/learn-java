import static java.lang.System.out;

public class PrimitiveTypes {
    public static void main(String[] args) {
        short num = 300;

        short numbFormattedUnderscore = 20_000;

        out.println(num);
        out.println(numbFormattedUnderscore);
        out.println(numbFormattedUnderscore - num);
    }
}
