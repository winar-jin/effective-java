package chap2;

// Cleaner class works at Java9: https://docs.oracle.com/javase/9/docs/api/java/lang/ref/Cleaner.html
public class AutoCloseableRoom_8 implements AutoCloseable {

//    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("cleaning room");
            this.numJunkPiles = 0;
        }
    }

    private final State state;

//    private final Cleaner.Cleanable cleanable;

    public AutoCloseableRoom_8(int numJunkPiles) {
        state = new State(numJunkPiles);
//        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
//        cleanable.clean();
    }
}
