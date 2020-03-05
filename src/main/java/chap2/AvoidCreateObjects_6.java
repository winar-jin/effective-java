package chap2;

public class AvoidCreateObjects_6 {

    private static long sum_low_performance() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static long sum_high_performance() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
//        final long sumResult = sum_low_performance(); // almost 9s
        final long sumResult = sum_high_performance();  // about 1s
        System.out.println(sumResult);
    }
}
