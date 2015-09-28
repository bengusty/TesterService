package demo;

import java.util.Comparator;

public class TesterBugsRankingComparator implements Comparator<TesterBugsRanking> {
    @Override
    public int compare(TesterBugsRanking o1, TesterBugsRanking o2) {
        return o2.getTotalBugsCount().compareTo(o1.getTotalBugsCount());
    }
}
