package com.example.masterclass;

public class ScopeCheck {

    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int varTwo = 2;
        //declaring 'varOne' again inside this method, we created a new variable whose scope is the current method
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + (i * varTwo));//if we hadn't declared it again, Java would look for
            //varOne in the next narrowest scope, in this case our private field:    private int varOne = 1;
            //if we wanted to use the private field but still declare our local varOne, we could specify this.varOne
        }
//        System.out.println("Value of i is now " + i); // 'i' is no longer available; it is only accessible from within the loop, where it was declared
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree form outer class: " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created, varOne is " + varOne + "and varThree is " + varThree);
        }

        /*public void timesTwo() {
//            int varTwo = 2;
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + (i * ScopeCheck.this.varOne)); //this. refers to the current class
                // in the case where there is no varOne in this cinner class, we must specify that this. applies to the outer class ScopeCheck
            }*/
        public void timesTwo() {
//            ScopeCheck.this.timesTwo(); //we can use this to define the scope in which Java should look for the address
            System.out.println("varOne is still available here: " + varOne);
            //now that those variable are renamed, privateVar are no longer shadowed by the inner classe's fields
            // no longer need for 'this.'
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + (i * varThree));
            }
        }
    }
}
