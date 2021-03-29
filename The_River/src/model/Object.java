package model;

import controller.Controller.Position;

public class Object
{
    protected String name;
    protected Position position;

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public Position getPosition() 
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
}