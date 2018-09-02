package masterclass;


//ArrayList<Team> teams;
//Collections.sort(teams);

/*
    Create a generic class to implement a league table for a sport.
    The class should allow teams to be added to the list
    and store a list of teams that belong to the league

    Your class should have a method to print out the teams in descending order

    Only teams of the same league should be added to any particular instance of the league class
    Make sure the program doesn't compile if you try to add an incompatible team
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueTable<J extends Team> /*implements Comparable<Team<J>>*/{
    private String sport;
    private List<J> table;

    public LeagueTable(String sport) {
        this.sport = sport;
        this.table = new ArrayList<>();
    }

    public String getSport() {
        return sport;
    }

    /*@Override
    public int compareTo(Team<J> team) {
        return 0;
    }*/

    public boolean addTeam(J team) {
        if((team != null) && (!table.contains(team))) {
            table.add(team);
            System.out.println("Added " + team.getName() + " to the league table");
            return true;
        }
        System.out.println("no team name specified, or team already in the list");
        return false;
    }

    public void printTable() {
        Collections.sort(table);
        System.out.println("\nRanking table for the Australian " + getSport() + " League");
        int i = 1;
        for(J t : table) {
            System.out.println("Team " + (i++) + ": " + t.getName() + "(" + t.ranking() + ")\r");
        }
    }
}
