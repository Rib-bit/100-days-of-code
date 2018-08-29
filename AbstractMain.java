package masterclass;
/*
Back to Abstraction

        We learned about interfaces recently. They allow us to define the required functionality for something, without actually implementing the details
        They deal with the what, not the how. They are considered abstract. Can't be instantiated.
        The actual implementation is left to the classes, hence the 'implements' keyword

        Java also has abstract classes.

 */
public class AbstractMain {

    public static void main(String[] args) {

        Dog dog = new Dog("Yokie");
        dog.eat();
        dog.breathe();

       /* Bird bird = new Bird("Parrot");

        bird.eat();         We could implement a fly() method, but not all birds can fly.
        bird.breathe();     Better would be to create an abstract Bird class that extends the
                            abstract Animal class and has an abstract fly() method...

                            Bird is now abstract, cannot be instantiated*/

        Parrot parrot = new Parrot("Australian ringneck");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        //penguin.fly(); ERROR

        /*
        We define functionality that must be implemented, but without specifying them.
        With a superclass, a subclass is not required to implement those generic methods. Here, we are forcing
        the classes that implement this to figure out the implementation of those methods.

            When do we use abstract classes rather than interfaces? As before, it's usually a matter of relationship
            For an 'is a' relationship, we would be better of using inheritance, i.e. an abstract class
            For a 'has a'/'can' relationship, an interface
                Careful considerations, we wouldn't want a Dragonfly or a Bat to be considered a Bird
                ... we could rename our Bird class 'Flying Animals' and have all fliers inherit from it
                but we would end up with bats laying eggs, or dragonfly hunting for insects in the dark.
                If flight is their only common feature, we're actually looking at more of a 'can' relationship

                We're creating a CanFly interface instead


        Interface vs. Abstract class

            Interfaces can have variables, but they're all public static final, making them constants with a static scope, essentially
                They have to be static, because nonstatic variables require an instance, and you can't instantiate an interface ...
                    ...(wait, but you can't instantiate an abstract class either, and yet their variable don't seem to be static...)
                Abstract classes can have member variables that are inherited, unlike Interfaces

            Interfaces cannot have constructors, Abstract classes can.

            Interfaces can only have public methods, whereas the methods of an Abstract class can have varying visibility.

            Interfaces can only have abstract methods, but Abstract classes can also have defined, concrete methods
                The Animal class implements the getName() method, and as a result that code doesn't have to be duplicated for all classes that extend it.

            Interfaces can be implemented several at a time by a class, but a class can ony inherit fro one parent class
                When an Abstract class is in love, and has a child class, it lets it do all its work : it is tradition - the baby class will be ...
                ... overriding and implementing all the abstract methods of its parent.
                    If the baby class doesn't want to work, then it must be defined as Abstract as well

             When to use them:

                Abstract classes when you want to:
                    Share code among closely related classes
                    Have classes that extend your Abstract class with many common methods or fields or required access modifiers other than public
                    Declare non static or non final fields; this enables you to define methods that can access and modify the state of an object
                    Have your base class provide a default implementation of certain methods, but have other methods open to being overridden by child classes

                    The purpose of an Abstract class is to provide a common definition of a base class that multiple derived classes can share

            Interfaces:
                Just the declaration of methods of class. We define what kind of operations an object can perform. The classes will define and implement these.
                Cannot be instantiated. May contain a mix of methods declared with or without an implementation, all public and abstract
                Can be extended by another interface (CanMove -> CanFly & CanWalk)
                Flexible, can deal with a lot of stress on the design of your program. Each interface in your program is a point of variation...
                ... at which you can plug in different implementations for that interface.
                They are used for abstraction, decoupling the 'what' from the 'how'
                Since Java 8, Interfaces can contain methods with implementation, 'default methods'. We use the 'default' keyword.
                Since Java 9, Interfaces can contain private methods(primarily used when two default methods in an interface share common code)

                when:
                    Unrelated classes will implement your Interface.
                    You want to specify the behaviour of a specified data type, without concern for who implements the behaviour
                    You want to separate different behaviour.
         */


    }
}
