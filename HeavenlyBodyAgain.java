package com.example.masterclass;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBodyAgain {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBodyAgain> satellites;

    public HeavenlyBodyAgain(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBodyAgain> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(HeavenlyBodyAgain moon) {
        return this.satellites.add(moon);
    }


    //here, we'll only check the names

    @Override
    public boolean equals(Object obj) {//we want to make sure we override the method, instead of overloading it. We have to respect the signature
        if(this == obj) {
            return true; //will return true if the two objects are the same one in memory
        }
        System.out.println("obj.getClass()" + obj.getClass());
        System.out.println("this.getClass()" + this.getClass());
        if((obj==null)||(obj.getClass() != this.getClass())) {//getClass() will compare the hashcodes as well, right? Yup
            return false; //above, adding validation for the class of obj is unnecessary, because we used specific types for the Set and Map that contain HeavenlyBody objects
            //furthermore, even if subclassing HeavenlyBody... actually, we could end up comparing different subclasses of the same super and returning equal if they
            //happen to have the same name, which may be a problem... could that happen in this particular case though?(NO, FINAL CLASS)

            //say we take a subclass and try to cast it as the super, we may get an error because the subclass has different fields. And what about the equals() method for
            //that subclass?(NOPE) Would there be a danger of it being overridden too, but differently, causing further discrepancies?(DEFINITELY BAD)

            /* ANSWER
            waiiiit we declared it as final, of course!
             */

        }

        String objName = ((HeavenlyBodyAgain) obj).getName();// Ooooooooooooooooh casting! I keep overlooking that...
        return objName.equals(this.name);

        //Five rules for equals() https://docs.oracle.com/javase/8/docs/api/java/lang/Object/html#equals-java.lang.Object-
                //It is reflexive: for any non-null reference value x, x.equals(x) should return true.
                //It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
                //It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true,
        //              then x.equals(z) should return true.
                //It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently
        //              return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
                //For any non-null reference value x, x.equals(null) should return false.
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode() called " + this.name + " _ " + this.name.hashCode());

        return this.name.hashCode() + 57;//this simple line would accomplish our mission of comparing the bodies' names' hashcodes.
        // Safe here thanks to generics, but bad practice. Adding 57, small enough to not cause stack overflow
        //and guarantees that we've got a non-zero number that's being returned for each of our hashes. Huh??

        //how you override hashCode() is up to you, as long as
                // the same object will always generate the same hashcode during any execution of your program.
                // and as long as objects that compare equal have the same hashcode

        //could also be 'return Objects.hash(name)';
    }




























    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }*/
}
