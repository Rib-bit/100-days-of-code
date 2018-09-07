package com.example.masterclass;
/*
Quick challenge : describe accessibility of the interface and its members
 */
interface Accessible { //accessible from anywhere within this package
    int SOME_CONSTANT = 100;//accessible from anywhere, because all variables in interfaces are public static final(!)
    public void methodA();//accessible from anywhere
    void methodB();//accessible from anywhere, because all methods in interfaces are public
    boolean methodC();//accessible from anywhere
}

/*
the whole point of declaring an interface is to provide methods to implement
    hiding any methods or variables would be counterproductive in many cases

making the interface itself package-private will however make its members package-private, in effect
 */
