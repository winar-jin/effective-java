package chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class equalsMethod_10 {
    public static class CaseInsensitiveString {
        private String content;

        CaseInsensitiveString(String content) {
            this.content = Objects.requireNonNull(content);
        }

        public boolean equalsBad(Object obj) {
            if (obj instanceof CaseInsensitiveString) {
                return content.equalsIgnoreCase(((CaseInsensitiveString) obj).content);
            }

            if (obj instanceof String) {
                return content.equalsIgnoreCase((String) obj); // broke symmetric
            }
            return false;
        }

        // right way
        @Override
        public boolean equals(Object obj) {
            return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).content.equalsIgnoreCase(content);
        }
    }

    public static void main(String[] args) {
        final CaseInsensitiveString hello = new CaseInsensitiveString("Hello");

        final boolean equal = hello.equals("hello");
        final boolean flipEqual = "hello".equals(hello);
        System.out.println(equal);
        System.out.println(flipEqual);

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(hello);
        boolean containHello = list.contains(hello);
        System.out.println(containHello);
    }
}
