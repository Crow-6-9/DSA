class Candidate {
    private int id;
    private String name;
    private String partyName;
    private String logo;
    private int predicateVote;

    public Candidate(int id, String name, String partyName, String logo) {
        this.id = id;
        this.name = name;
        this.partyName = partyName;
        this.logo = logo;
        this.predicateVote = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getLogo() {
        return logo;
    }

    public int getPredicateVote() {
        return predicateVote;
    }

    public void setPredicateVote(int predicateVote) {
        this.predicateVote = predicateVote;
    }
}

class Area {
    private int id;
    private String name;
    private int totalVote;

    public Area(int id, String name, int totalVote) {
        this.id = id;
        this.name = name;
        this.totalVote = totalVote;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalVote() {
        return totalVote;
    }
}

class NewsChannel {
    public void showPrediction(Area area, Candidate... candidates) {
        int totalCandidates = candidates.length;
        int totalPredictedVotes = 0;

        for (Candidate candidate : candidates) {
            totalPredictedVotes += candidate.getPredicateVote();
        }

        if (totalPredictedVotes < area.getTotalVote()) {
            int remainingVotes = area.getTotalVote() - totalPredictedVotes;
            System.out.println("Remaining " + remainingVotes + " people may not vote for any candidate.");
        }

        Candidate winner = candidates[0];
        for (Candidate candidate : candidates) {
            if (candidate.getPredicateVote() > winner.getPredicateVote()) {
                winner = candidate;
            }
        }

        System.out.println("Winner: " + winner.getName() + " (" + winner.getPartyName() + ")");
        System.out.println("Opposition candidate: ");
        for (Candidate candidate : candidates) {
            if (candidate.getId() != winner.getId()) {
                System.out.println(candidate.getName() + " (" + candidate.getPartyName() + ")");
            }
        }
    }
}

public class VotingPollApplication {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate(1, "Candidate 1", "Party A", "Logo A");
        Candidate candidate2 = new Candidate(2, "Candidate 2", "Party B", "Logo B");
        Candidate candidate3 = new Candidate(3, "Candidate 3", "Party C", "Logo C");

        Area area = new Area(1, "Area 1", 1000);

        candidate1.setPredicateVote(600);
        candidate2.setPredicateVote(300);
        candidate3.setPredicateVote(400);

        NewsChannel newsChannel = new NewsChannel();
        newsChannel.showPrediction(area, candidate1, candidate2, candidate3);
    }
}
