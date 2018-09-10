package com.example.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGameMain {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0,new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1,new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2,new Location(2, "You are at the top of a hill"));
        locations.put(3,new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4,new Location(4, "You are in a valley beside a stream"));
        locations.put(5,new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {

            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

           /* if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word: words){
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }*/
            if (direction.length() > 1){

                String[] playerInput = direction.split(" ");

                for(String i: playerInput) {
                    if((i.equalsIgnoreCase("w")) || (i.equalsIgnoreCase("n")) ||
                            (i.equalsIgnoreCase("e")) || (i.equalsIgnoreCase("s")) ||
                            (i.equalsIgnoreCase("west")) || (i.equalsIgnoreCase("north")) ||
                            (i.equalsIgnoreCase("east")) || (i.equalsIgnoreCase("south")) ||
                            (i.equalsIgnoreCase("q")) || (i.equalsIgnoreCase("quit"))) {
                        direction = i.substring(0, 1);
                        break;
                    }

                    if((i.equalsIgnoreCase("random")) || (i.equalsIgnoreCase("randomly")) ||
                            (i.equalsIgnoreCase("rdm"))) {
                        direction = "rdm";
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else if(direction.equalsIgnoreCase("rdm")) {
                System.out.println("The sun shines in your right eye, and you get lost for a while");
                loc = (int) ((Math.random() * (locations.size() - 1)) + 1);
            } else {
                System.out.println("Your way is blocked");
            }
        }
    }
}