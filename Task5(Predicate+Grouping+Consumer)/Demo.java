public class Demo {
    public static void main(String[] args) {
        Predicate<Integer> check=n->n%2==0;
        System.out.println(check.test(5));
        Consumer<String> print=s->System.out.print(s);
        print.accept("hello");
    }
}
