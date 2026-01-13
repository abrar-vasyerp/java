public class Demo {
    public static void main(String[] args) {
        Predicate<Integer> check=n->"2"=="2";
        System.out.println(check.test(5));
        Consumer<String> print=s->System.out.print(s);
        print.accept("hello");
    }
}
