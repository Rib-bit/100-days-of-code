package masterclass;
//Demonstrating proper encapsulation techniques
public class Printer {

    private double tonerLevel;//there we go, proper encapsulation
    private int pagesPrinted = 0;//aaaand preset these fields, they should pretty much always be at 0 when the printer is instantiated
    private boolean isDuplex;
    private int pagesLeft = 0;
    private int paper;

    public double tonerRefill(double refill){
        if(refill<=0) { //validation : need positive quantity
            System.out.println("Invalid value");
            return -1;
        }

        if(this.tonerLevel == 100) { //validation : can't overfill
            System.out.println("Toner is already full.");
            return -1;
        }

        if(refill>(100-this.tonerLevel)){ //again, can't overflow

            double tonerIn = 100 - this.tonerLevel; //what goes in
            double tonerOut = refill - tonerIn; //what stays out

            this.tonerLevel += tonerIn;

           if((tonerOut*1000)%10>4){
                tonerOut = (Math.ceil(tonerOut*100)/100);
                    //rounding the result up or down, depending. There's probably a built-in method for it, but this is concise enough I think
           } else if((tonerOut*1000)%10<=4){
                tonerOut = (Math.floor(tonerOut*100)/100);
           }

            System.out.println("There's " + tonerOut + "% left over.");

        } else {
            this.tonerLevel += refill;
        }

        if((this.tonerLevel*1000)%10>4){
            this.tonerLevel = (Math.ceil(this.tonerLevel*100)/100);

        } else if((this.tonerLevel*1000)%10<=4){
            this.tonerLevel = (Math.floor(this.tonerLevel*100)/100);
        }
        System.out.println("Toner refilled up to " + this.tonerLevel + "%");

        if(this.pagesLeft>0) { //in case the toner runs out while printing pages, printing resumes automatically where it stopped when the printer gets more
            print(this.pagesLeft);
        }

        return this.tonerLevel;
    }

    public int paperRefill(int refill){
        if(refill<=0) { //validation : need positive quantity
            System.out.println("Invalid value");
            return -1;
        }

        if(this.paper == 1000) { //validation : can't overfill
            System.out.println("Paper slot is already full.");
            return -1;
        }

        if(refill>(1000-this.paper)){ //again, can't overflow

            int paperIn = 1000 - this.paper; //what goes in
            int paperOut = refill - paperIn; //what stays out

            this.paper += paperIn;

            System.out.println("There's " + paperOut + "sheets left over.");

        } else {
            this.paper += refill;
        }

        System.out.println("Paper refilled up to " + this.paper + "/1000");

        if(this.pagesLeft>0) { //in case the paper runs out while printing pages, printing resumes automatically where it stopped when the printer gets more
            print(this.pagesLeft);
        }

        return this.paper;
    }

    public void print(int pages) {
        this.pagesPrinted = 0;
        this.pagesLeft = pages;
        System.out.println("Preparing to print " + pages + " pages.");

        if(this.isDuplex) {
            for(int i=0; i<pages; i += 2) {

                if((this.tonerLevel>=0.2) && (this.pagesLeft>1) && (this.paper>0)){

                    this.pagesLeft -= 2;
                    this.pagesPrinted += 2;
                    this.tonerLevel -= 0.2;
                    this.paper --;

                } else if((this.tonerLevel>=0.1) && (this.pagesLeft==1) && (this.paper>0)) { //set up so that it will 1 page only if it has 1 left, and if it has enough toner ofc
                    this.pagesLeft--;
                    this.pagesPrinted++;
                    this.tonerLevel -= 0.1;
                    this.paper--;
                        //if say, it runs out midway through but has 0.1% left, it will halt the process until the next refill
                        //better, since it needs to print both sides of a page at the same time

                } else if(this.tonerLevel<0.2) {

                    System.out.println((warning("toner"))); //had the same code 4 times, made a private method within the class instead
                    break;
                } else if(this.paper<=0) {

                    System.out.println((warning("paper")));
                    break;
                }
            }
        } else {

            for(int i=0; i<pages; i++) {

                if((this.tonerLevel>=0.1) && (this.paper>0)){

                    this.pagesLeft--;
                    this.pagesPrinted++;
                    this.tonerLevel -= 0.1;
                    this.paper--;

                } else if(this.tonerLevel<=0) {
                    System.out.println(warning("toner"));
                    break;
                } else if(this.paper<=0) {
                    System.out.println(warning("paper"));
                }
            }
        }

        if((this.tonerLevel*1000)%10>4){
            this.tonerLevel = (Math.ceil(this.tonerLevel*100)/100);

        } else if((this.tonerLevel*1000)%10<=4){
            this.tonerLevel = (Math.floor(this.tonerLevel*100)/100);
        }

        System.out.println(this.pagesPrinted + " pages printed, " + this.pagesLeft + " pages left ; " + this.tonerLevel + "% toner left , " + this.paper + "/1000 paper left");
        System.out.println("******");
    }

    private String warning(String missing) {
        return new StringBuilder().append("With current amount of ").append(missing).append(", only ").append(this.pagesPrinted).append(" pages will be printed. Please refill afterwards.").toString();
    } //pretty cool StringBuilder thingy in IntelliJ. Seems straight forward enough, works in this case at least, converting int to string as well..

    public Printer() {
        this(100, false, 1000);
    }

    public Printer(double tonerLevel, boolean isDuplex, int paper) {
        if((tonerLevel>-1) && (tonerLevel<=100)) { //extra validation
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.isDuplex = isDuplex;
        if (paper>=0) {
            this.paper = paper;
        } else {
            this.paper = -1;
        }
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public int getPagesLeft() {
        return pagesLeft;
    }

    public int getPaper() {
        return paper;
    }
}