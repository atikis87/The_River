package controller;

import model.Cabbage;
import model.Farmer;
import model.Goat;
import model.Object;
import model.Wolf;

public class Controller
{
	
    private Object wolf;
    private Object goat;
    private Object cabbage;
    private Object farmer;
    private Position current_position;
    
    //Constructor
    public Controller() 
    {
        wolf = new Wolf();
        goat = new Goat();
        cabbage = new Cabbage();
        farmer = new Farmer();
        current_position = Position.STARTING_POINT;
    }
    
    public enum Position 
    {
        STARTING_POINT,
        FINAL_POINT,
        THE_BOAT;
    }

	public enum Items
    {
        WOLF,
        GOAT,
        CABBAGE,
        FARMER;
    }

	
    public String getName(Items identification)
    {
        switch (identification)
        {
        case WOLF: 
            return wolf.getName();
        case GOAT:
            return goat.getName();
        case CABBAGE:
            return cabbage.getName();
        default:
            return farmer.getName();
        }
    }
    
    // START NEW GAME
    public void newGame()
    {
    	// ALL OBJECTS AT THE START POINT
        wolf.setPosition(Position.STARTING_POINT);
        goat.setPosition(Position.STARTING_POINT);
        cabbage.setPosition(Position.STARTING_POINT);
        farmer.setPosition(Position.STARTING_POINT);
        current_position = Position.STARTING_POINT;
    }
    
    public Position getPosition(Items id)
    {
        switch (id) 
        {
        case WOLF:
            return wolf.getPosition();
        case GOAT:
            return goat.getPosition();
        case CABBAGE:
            return cabbage.getPosition();
        default:
            return farmer.getPosition();
        }
    }
    
    public Position getCurrentLocation() 
    {
        return current_position;
    }
    
    public void loadBoat(Items id) 
    {

        switch (id) 
        {
        case WOLF:
            if (wolf.getPosition() == current_position && goat.getPosition() != Position.THE_BOAT && cabbage.getPosition() != Position.THE_BOAT) 
            {
                wolf.setPosition(Position.THE_BOAT);
            }
            break;
        case GOAT:
            if (goat.getPosition() == current_position && wolf.getPosition() != Position.THE_BOAT && cabbage.getPosition() != Position.THE_BOAT)
            {
                goat.setPosition(Position.THE_BOAT);
            }
            break;
        case CABBAGE:
            if (cabbage.getPosition() == current_position && wolf.getPosition() != Position.THE_BOAT && goat.getPosition() != Position.THE_BOAT)
            {
                cabbage.setPosition(Position.THE_BOAT);
            }
            break;
        case FARMER:
            if (farmer.getPosition() == current_position) 
            {
                farmer.setPosition(Position.THE_BOAT);
            }
        default: // do nothing
        }
    }
    
    public void unloadBoat(Items id) 
    {
        switch (id) 
        {
        case WOLF:
            if (wolf.getPosition() == Position.THE_BOAT) 
            {
                wolf.setPosition(current_position);
            }
            break;
        case GOAT:
            if (goat.getPosition() == Position.THE_BOAT) 
            {
                goat.setPosition(current_position);
            }
            break;
        case CABBAGE:
            if (cabbage.getPosition() == Position.THE_BOAT) 
            {
                cabbage.setPosition(current_position);
            }
            break;
        case FARMER:
            if (farmer.getPosition() == Position.THE_BOAT) 
            {
                farmer.setPosition(current_position);
            }
        default:
        }
    }
    
    public void rowBoat() 
    {
        assert (current_position != Position.THE_BOAT);
        if (current_position == Position.STARTING_POINT) 
        {
            current_position = Position.FINAL_POINT;
        } 
        else 
        {
            current_position = Position.STARTING_POINT;
        }
    }
    
    public boolean thePlayerWon() 
    {
        return wolf.getPosition() == Position.FINAL_POINT && goat.getPosition() == Position.FINAL_POINT
                && cabbage.getPosition() == Position.FINAL_POINT && farmer.getPosition() == Position.FINAL_POINT;
    }
    

    public boolean thePlayerLost() 
    {
        if (goat.getPosition() == Position.THE_BOAT)
        {
            return false;
        }
        if (goat.getPosition() == farmer.getPosition())
        {
            return false;
        }
        if (goat.getPosition() == current_position)
        {
            return false;
        }
        if (goat.getPosition() == wolf.getPosition()) 
        {
            return true;
        }
        if (goat.getPosition() == cabbage.getPosition())
        {
            return true;
        }
        return false;
    }
    
}