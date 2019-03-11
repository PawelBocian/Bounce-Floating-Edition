import java.util.Comparator;

// Special comparator used to sort Scores
public class ScoreComparator implements Comparator<Score>
{
    @Override
    public int compare(Score player_one, Score player_two) {
        if(player_two == null) return 1;
        if(player_one.get_points() > player_two.get_points()) return -1;
        else if(player_one.get_points() < player_two.get_points()) return 1;
        else return 0;
    }
}


