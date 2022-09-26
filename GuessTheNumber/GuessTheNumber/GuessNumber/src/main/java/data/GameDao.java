package data;

import entity.Game;
import java.util.List;
// Author Talha
public interface GameDao {
  
    Game add(Game game);
    
    List<Game> getAll();
    
    Game findById(int id);
    
    boolean update(Game game);
}
