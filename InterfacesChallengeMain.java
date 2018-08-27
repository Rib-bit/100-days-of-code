package masterclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfacesChallengeMain {

    public static void main(String[] args) {
        //write a method that takes an object (that implements the interface) as a parameter, and then uses the save() method defined in the interface.
        //should just print the values to the screen

        //write another method that restores the values to a saveable object, using the populateFields() method

//        ISaveable mySword;
//        mySword = new Weapon();
//        List<String> swordList = mySword.saveToArrayList("sword","slashing", "12", "95");
//        Weapon yourSword = new Weapon();
//        Object yourSword = mySword.populateFields(swordList);
//        System.out.println("yourSword: " + yourSword);
//        System.out.println("mySword: " + mySword);
//
//        ISaveable myShield;
//        myShield = new Shield();
//        List<String> shieldList = myShield.saveToArrayList("shield","hardwood", "8", "80");
//        Object yourShield = myShield.populateFields(shieldList);
//        System.out.println("yourShield: " + yourShield);
//        System.out.println("myShield: " + myShield);
//
//        ISaveable myArmour;
//        myArmour = new Armour();
//        List<String> armourList = myArmour.saveToArrayList("armour", "chain", "14", "72");
//        Object yourArmour = myArmour.populateFields(armourList);
//        System.out.println("yourArmour: " + yourArmour);
//        System.out.println("myArmour: " + myArmour);
//
//
//        System.out.println("============================");


//        Armour plateArmour = new Armour();
//        List<String> plateArmourList = readValues();


        ISaveable savedSword;

        save(new Armour(), readValues());

        savedSword = fillIn(new Weapon(), readValues());

        System.out.println(savedSword);
    }

    public static void save(ISaveable equipment , List<String> list){
        System.out.println(equipment.saveToArrayList(list.get(0), list.get(1), list.get(2), list.get(3)));
    }

    public static ISaveable fillIn(ISaveable equipment, List<String> list){
        ISaveable newEquipment;
        newEquipment = (ISaveable) equipment.populateFields(list);
        return  newEquipment;
    }

    public static List<String> readValues() {
        List<String> values = new ArrayList<String>();

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
}
