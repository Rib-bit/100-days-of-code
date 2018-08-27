//draia, 27/08/2018

package masterclass;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfacesChallengeMainTim {

    public static void main(String[] args) {

        PlayerTim tim = new PlayerTim("Tim", 10, 15);
        System.out.println(tim);
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);

        ISaveableTim werewolf = new MonsterTim("Werewolf", 20, 40);
        System.out.println("Strength = " + ((MonsterTim) werewolf).getStrength()); // we need to get around the fact that we declared it as an implementation of the interface
        //we do so by casting the object as an instance of a particular class, since getStrength() doesn't exist in the interface.
        //Or we could instantiate werewolf like we did tim, if possible

        //when there is no good reason to declare it by using the class, one should declare it as the interface type. Keeps code more generic.
        //we can always cast the instance as the interface or class type as necessary. And Java does some of that work for us,
        //like with parameters to methods that have been declared as the interface type, automatically cast for the class type.
        System.out.println(werewolf);
        saveObject(werewolf);


    }
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while(!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveableTim objectToSave){ //we can now use this method t o"save" any class that uses that interface
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveableTim objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
