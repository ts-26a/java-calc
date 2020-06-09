package calc;

public class Parser {
    private final Source src;

    public Parser(Source src) {
        this.src = src;
    }

    private final int number() {
        StringBuilder sb = new StringBuilder();
        int ch;
        for (; ;) {
            ch = this.src.peek();
            if (ch == -1 || !Character.isDigit(ch)) break;
            sb.append((char)ch);
            this.src.next();
        }
        String s = sb.toString();
        return Integer.parseInt(s);
    }

    private final int addsub() {
        int x = timediv();
        for (; ;) {
            switch (this.src.peek()) {
                case '+':
                    this.src.next();
                    x += timediv();
                    continue;
                case '-':
                    this.src.next();
                    x -= timediv();
                    continue;
            }
            break;
        }
        return x;
    }

    private final int timediv() {
        int x = factor();
        for (; ;) {
            switch (this.src.peek()) {
                case '*':
                    this.src.next();
                    x *= factor();
                    continue;
                case '/':
                    this.src.next();
                    x /= factor();
                    continue;
            }
            break;
        }
        return x;
    }

    private final int factor() {
        space();
        if (this.src.peek() == '(') {
            this.src.next();
            int ret = expr();
            if (this.src.peek() == ')') this.src.next();
            space();
            return ret;
        }
        space();
        return number();
    }

    private void space() {
        while (this.src.peek() == ' ') this.src.next();
    }

    public final int expr() {
        return addsub();
    }
}

