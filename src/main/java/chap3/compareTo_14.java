package chap3;

public class compareTo_14 {
    static class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
        private String content;

        CaseInsensitiveString(String content) {
            this.content = content;
        }

        @Override
        public int compareTo(CaseInsensitiveString o) {
            return String.CASE_INSENSITIVE_ORDER.compare(content, o.content);
        }
    }

    public static void main(String[] args) {
        final CaseInsensitiveString string = new CaseInsensitiveString("Hello");
        final int result = string.compareTo(new CaseInsensitiveString("hello"));
        System.out.println(result);
    }
}
