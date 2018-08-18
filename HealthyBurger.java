package masterclass;

public class HealthyBurger extends Hamburger{

    private double basePrice = 7.39;
    private String name = "Healthy Bob's";

    private boolean hasJalapenos;
    private boolean hasGrilledTofu;

    public HealthyBurger(boolean hasLettuce, boolean hasTomato, boolean hasPickles, boolean hasCheddar, boolean hasJalapenos, boolean hasGrilledTofu) {
        super("brown rye", false, hasLettuce, hasTomato, hasPickles, hasCheddar);
        this.hasJalapenos = hasJalapenos;
        this.hasGrilledTofu = hasGrilledTofu;
    }

    @Override
    public void whatIn() {
        super.whatIn();
        System.out.println("...as well as " + hasJalapenos() + " and " + hasGrilledTofu());
    }

    @Override
    public void check() {
        super.check();
    }

//    @Override
//    public double checkAdds() {
//        double newAdds = 0;
//        double addTofu = 1.2;
//        double addHip = 0.3;
//        if(this.hasGrilledTofu) {
//            newAdds += addTofu;
//            System.out.println("+ Grilled tofu patty: $" + addTofu);
//        }
//        if(this.hasJalapenos) {
//            newAdds += addHip;
//            System.out.println("+ Jalapeno peppers: $" + addHip);
//        }
//        return super.checkAdds() + newAdds;
//    }
    @Override
    public double checkAdds() {
        double newAdds = super.checkAdds();
        double addTofu = 1.2;
        double addHip = 0.3;
        if(this.hasGrilledTofu) {
            newAdds += addTofu;
            System.out.println("+ Grilled tofu patty: $" + addTofu);
        }
        if(this.hasJalapenos) {
            newAdds += addHip;
            System.out.println("+ Jalapeno peppers: $" + addHip);
        }
        return newAdds;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getName() {
        return name;
    }

    public String hasJalapenos() {
        if(hasJalapenos) {
            return "extra jalapenos";
        } else {
            return "no jalapenos";
        }
    }

    public String hasGrilledTofu() {
        if(hasGrilledTofu) {
            return "extra grilled tofu";
        } else {
            return "no grilled tofu";
        }
    }
}
