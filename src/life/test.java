package life;

public class test {

    public static void modify(StringBuilder string) {
        string.append("хуй");
    }

    public static void main(String[] args) {

        StringBuilder string = new StringBuilder("Яйцо");
        modify(string);
        System.out.println(string);
    }
}
