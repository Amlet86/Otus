package multithreading.threadSafe;

public class ThreadSafe {

    static ThreadLocal<Integer> threadSafeVariable = new ThreadLocal<Integer>();

    public static void setThreadSafeVariable(Integer value) {
        threadSafeVariable.set(value);
        printVariable(threadSafeVariable.get());
    }

    public static Integer getThreadSafeVariable() {
        return threadSafeVariable.get();
    }

    public static void setToDefault() {
        threadSafeVariable.set(0);
        printVariable(threadSafeVariable.get());
    }

    private static void printVariable(Integer value) {
        System.out.println("Thread safe variable is " + value);
    }
}
