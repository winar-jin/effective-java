package chap3;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

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

    static class PhoneNumber implements Comparable<PhoneNumber> {
        private int prefix;
        private int areaCode;
        private int lineNum;

        private final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                .thenComparingInt(pn -> pn.prefix)
                .thenComparingInt(pn -> pn.lineNum);

        PhoneNumber(int prefix, int areaCode, int lineNum) {
            this.prefix = prefix;
            this.areaCode = areaCode;
            this.lineNum = lineNum;
        }

        @Override
        public int compareTo(PhoneNumber o) {
            return COMPARATOR.compare(this, o);
        }
    }

    public static void main(String[] args) {
        final CaseInsensitiveString string = new CaseInsensitiveString("Hello");
        final int result = string.compareTo(new CaseInsensitiveString("hello"));
        System.out.println(result);

        final PhoneNumber phoneNumber1 = new PhoneNumber(12, 20, 30);
        final PhoneNumber phoneNumber2 = new PhoneNumber(11, 20, 30);
        final int whichBigger = phoneNumber1.compareTo(phoneNumber2);
        System.out.println(whichBigger);
    }
}
