package entity;

import java.util.Objects;
// Author Talha
public class Game {
    private int gameID;
    private String answer;
    private boolean finished;
    
    public Game() {
    }

    public Game(String answer, boolean finished) {
        this.answer = answer;
        this.finished = finished;
    }
    
    

    public Game(int gameID, String answer, boolean finished) {
        this.gameID = gameID;
        this.answer = answer;
        this.finished = finished;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.gameID;
        hash = 41 * hash + Objects.hashCode(this.answer);
        hash = 41 * hash + (this.finished ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameID != other.gameID) {
            return false;
        }
        if (this.finished != other.finished) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameID + ", answer=" + answer + ", finished=" + finished + '}';
    }
    
}
