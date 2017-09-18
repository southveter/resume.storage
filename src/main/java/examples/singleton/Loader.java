package examples.singleton;

public class Loader {
    public static void main(String[] args) {
        LazySingleton ls = LazySingleton.getInstance();
        System.out.println(ls);
        LazySingleton ls1 = LazySingleton.getInstance();
        System.out.println(ls1);
        System.out.println(ls == ls1);
    }
}
