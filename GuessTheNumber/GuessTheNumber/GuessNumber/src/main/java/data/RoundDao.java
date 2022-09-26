package data;

import entity.Round;
import java.util.List;
// Author Talha
public interface RoundDao {
    
    Round add(Round round);
    List<Round> getRoundbyGameid(int gameid);
}
