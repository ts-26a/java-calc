import java.util.*;
import calc.*;


class Main {
    public static void test(String s) {
        Source src = new Source(s);
        Parser psr = new Parser(src);
        try {
            System.out.println(s + " = " + psr.expr());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static void main(String args[]) {
        test("(1+2  )*3");
        test("1+2* 3");
    }
}
