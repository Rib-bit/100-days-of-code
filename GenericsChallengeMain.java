package masterclass;

public class GenericsChallengeMain {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        /*Team adelaideCrows = new Team("Adelaide Crows"); //raw type
        adelaideCrows.addPlayer(joe); //here we want to make sure that only football players can get selected for football teams
        adelaideCrows.addPlayer(pat);
        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers()); //3...*/

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        //but we need an ability to restrict the type that can be provided for the T argument. See top of Team class

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);


        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> freemantle = new Team<>("Freemantle");

        hawthorn.matchResult(freemantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(freemantle, 2, 1);
        adelaideCrows.matchResult(hawthorn, 1, 1);
//        adelaideCrows.matchResult(baseballTeam, 1, 1); //will print an error, thanks to type parameter

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());
        System.out.println(freemantle.getName() + ": " + freemantle.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());


        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(adelaideCrows.compareTo(melbourne));

        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(freemantle.compareTo(melbourne));





        System.out.println("===================================");

        LeagueTable<Team<FootballPlayer>> footballLeague = new LeagueTable<>("Football");
        footballLeague.addTeam(hawthorn);
        footballLeague.addTeam(melbourne);
        footballLeague.addTeam(adelaideCrows);
        footballLeague.addTeam(freemantle);
//        footballLeague.addTeam(baseballTeam);//will not compile

        footballLeague.printTable();
        System.out.println("============_===============");

        League<Team<FootballPlayer>> footballLeagueTim = new League<>("AFL");
        footballLeagueTim.add(hawthorn);
        footballLeagueTim.add(melbourne);
        footballLeagueTim.add(adelaideCrows);
        footballLeagueTim.add(freemantle);

        footballLeagueTim.showLeagueTable();

        //as a reminder, we don't usually want to use raw types, even though Java allows it
    }
}
