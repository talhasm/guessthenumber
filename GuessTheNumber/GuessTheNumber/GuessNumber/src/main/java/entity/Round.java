package entity;

import java.time.LocalDateTime;
import java.util.Objects;
// Author Talha
public class Round {
    private int gameID;
    private String guess;
    private String result;
    private LocalDateTime guess_time;
    
    public Round(){
        
    }
     public Round(int gameID, String guess) {
        this.gameID = gameID;
        this.guess = guess;
    }
    

    public Round(int gameID, LocalDateTime guess_time, String guess, String result) {
        this.gameID = gameID;
        this.guess_time = guess_time;
        this.guess = guess;
        this.result = result;
    }
    public void setgameID(int gameID){
        this.gameID = gameID;
    }
    public int getID(){
       return gameID; 
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getGuesstime() {
        return guess_time;
    }

    public void setGuesstime(LocalDateTime guess_time) {
        this.guess_time = guess_time;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.gameID;
        hash = 97 * hash + Objects.hashCode(this.guess);
        hash = 97 * hash + Objects.hashCode(this.result);
        hash = 97 * hash + Objects.hashCode(this.guess_time);
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
        final Round other = (Round) obj;
        if (this.gameID != other.gameID) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.guess_time, other.guess_time)) {
            return false;
        }
        return true;
    }
    
}
