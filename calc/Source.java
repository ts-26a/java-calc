package calc;

public class Source {
    private final String str;
    private int pos;

    public Source(String s) {
        this.str = s;
    }

    public final int peek() {
        if (this.pos < this.str.length()) {
            return this.str.charAt(this.pos);
        }
        return -1;
    }

    public final void next() {
        this.pos++;
    }
}

