package masterclass;

public class BurgerTests {

    public static void main(String[] args) {
        Hamburger test1 = new Hamburger(true, true, false, true);
        Hamburger test2 = new Hamburger("brown rye", true, false, true, false, true);
        HealthyBurger test3 = new HealthyBurger(true, true, true, false, true, true);
        DeluxeBurger test4 = new DeluxeBurger("seeds", true);
        DeluxeBurger test5 = new DeluxeBurger();

        test1.whatIn();
        test1.check();
        System.out.println("*************");
        test2.whatIn();
        test2.check();
        System.out.println("*************");
        test3.whatIn();
        test3.check();
        System.out.println("*************");
        test4.whatIn();
        test4.check();
        System.out.println("*************");
        test5.whatIn();
        test5.check();

    }
}
