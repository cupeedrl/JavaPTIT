import java.io.*;
import java.util.*;
import java.text.*;

class Club {
    private String clubId, name;
    private long price;

    public Club(String clubId, String name, long price) {
        this.clubId = clubId;
        this.name = name;
        this.price = price;
    }

    public String getclubId() {
        return clubId;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}

class Match {
    private String matchId, clubName;
    private long audience, revenue;

    public Match(String matchId, String clubName, long audience, long revenue) {
        this.matchId = matchId;
        this.clubName = clubName;
        this.audience = audience;
        this.revenue = revenue;
    }

    public long getRevenue() {
        return revenue;
    }

    public String toString() {
        return matchId + " " + clubName + " " + revenue;
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Club> clubs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String clubId = sc.nextLine();
            String name = sc.nextLine();
            long price = Long.parseLong(sc.nextLine());
            clubs.add(new Club(clubId, name, price));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Match> matches = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();

            String[] words = line.trim().split("\\s+");

            String matchId = words[0];
            long audience = Long.parseLong(words[1]);
            String clubId = matchId.substring(1,3);

            for(Club x : clubs){
                if(x.getclubId().equals(clubId)){
                    matches.add(new Match(matchId, x.getName(),audience,x.getPrice()*audience));
                }
            }
        }
        matches.sort(Comparator.comparing(Match::getRevenue).reversed());
        for(Match x : matches)
            System.out.println(x);
    }
}
