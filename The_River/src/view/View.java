package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.Controller.Items;
import controller.Controller.Position;

public class View extends JPanel implements MouseListener
{
	
	private static final long serialVersionUID = 1L;
	private Controller Position_Engine; // Model
    private boolean newStart = false;
    
    String html = "<html><body width='%1s'><h1>WELCOME to <br> The River Game</h1>"
            + "<p>Only the Woman Farmer and at most one other item are allowed "
            + "in the boat for each crossing. Only the Woman Farmer is able to operate the boat. "
            + "Do not leave the goat alone with the cabbage or the wolf unsupervised with the goat. "
            + "<br>Can you get all four across the river safely?<br><br>"
            + "<p>LET'S GO PLAY!";
    int w = 255;
    
    
	//Constructor
    public View()
    {
        Position_Engine = new Controller();
        addMouseListener(this);
    }
    
	// Create GUI
    public void createMyGUI()
    {
    	
        JFrame frame = new JFrame("The River"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View newContentPane = new View();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.setResizable(false);
        frame.setSize(900, 700);
        frame.setVisible(true);
        //Message
        JOptionPane.showMessageDialog(frame, String.format(html, w, w));


    }
	
	// All Final Rectangle

    private final Rectangle NewStartButton = new Rectangle(270, 120, 250, 30);
	private final Rectangle L_Farmer = new Rectangle(80, 215, 50, 50);
	
    private final Rectangle L_Wolf = new Rectangle(20, 215, 50, 50);
    private final Rectangle L_Goat = new Rectangle(20, 275, 50, 50);
    private final Rectangle L_Cabbage = new Rectangle(80, 275, 50, 50);
    private final Rectangle L_Boat = new Rectangle(140, 275, 110, 50);
    private final Rectangle L_Boat_Driver = new Rectangle(140, 215, 50, 50);
    private final Rectangle L_Boat_Passenger = new Rectangle(200, 215, 50, 50);

    private final Rectangle R_Farmer = new Rectangle(730, 215, 50, 50);
    
    private final Rectangle R_Wolf = new Rectangle(670, 215, 50, 50);
    private final Rectangle R_Goat = new Rectangle(670, 275, 50, 50);
    private final Rectangle R_Cabbage = new Rectangle(730, 275, 50, 50);
    private final Rectangle R_Boat = new Rectangle(550, 275, 110, 50);
    private final Rectangle R_Boat_Driver = new Rectangle(550, 215, 50, 50);
    private final Rectangle R_Boat_Passenger = new Rectangle(610, 215, 50, 50);

    // OWN COLOR
    Color myLightBlue = new Color(0,212,255);
    Color myFiledBrown = new Color(219,145,89);
    Color myGrassGreen = new Color(28,201,0);
    Color myWhite = new Color(255, 255, 255); 
    
    // Images / Location of images
	Image farmer_IMG = Toolkit.getDefaultToolkit().getImage("F:\\JAVA2021\\The_River\\src\\images\\Farmer_120X120.jpg");
	Image wolf_IMG = Toolkit.getDefaultToolkit().getImage("F:\\JAVA2021\\The_River\\src\\images\\Wolf120X120.jpg");
	Image goat_IMG = Toolkit.getDefaultToolkit().getImage("F:\\JAVA2021\\The_River\\src\\images\\Goat120X120.jpg");
	Image cabbage_IMG = Toolkit.getDefaultToolkit().getImage("F:\\JAVA2021\\The_River\\src\\images\\Cabbage120X120.jpg");
	Image boat_IMG = Toolkit.getDefaultToolkit().getImage("F:\\JAVA2021\\The_River\\src\\images\\Boat200X120.png");
    
    
    // MouseClick EVENT
    
    @Override
    public void mouseClicked(MouseEvent e)
    {

        if (newStart) 
        {
            if (this.NewStartButton.contains(e.getPoint())) 
            {
                Position_Engine.newGame();
                newStart = false;
                repaint();
            }
            return;
        }

        if (L_Farmer.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.FARMER) == Position.STARTING_POINT) 
            {
                Position_Engine.loadBoat(Items.FARMER);
            }
        } 
        else if (L_Wolf.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.WOLF) == Position.STARTING_POINT) 
            {
                Position_Engine.loadBoat(Items.WOLF);
            }
        } 
        else if (L_Goat.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.GOAT) == Position.STARTING_POINT) 
            {
                Position_Engine.loadBoat(Items.GOAT);
            }
        } 
        else if (L_Cabbage.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.CABBAGE) == Position.STARTING_POINT) 
            {
                Position_Engine.loadBoat(Items.CABBAGE);
            }
        } 
        else if (L_Boat_Driver.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.STARTING_POINT && Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
                Position_Engine.unloadBoat(Items.FARMER);
            }
        } 
        else if (L_Boat_Passenger.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.STARTING_POINT) 
            {
                if (Position_Engine.getPosition(Items.WOLF) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.WOLF);
                } 
                else if (Position_Engine.getPosition(Items.GOAT) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.GOAT);
                } 
                else if (Position_Engine.getPosition(Items.CABBAGE) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.CABBAGE);
                }
            }
        } 
        else if (L_Boat.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.STARTING_POINT && Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
                Position_Engine.rowBoat();
            }
        } 
        else if (R_Farmer.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.FARMER) == Position.FINAL_POINT) 
            {
                Position_Engine.loadBoat(Items.FARMER);
            }
        } 
        else if (R_Wolf.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.WOLF) == Position.FINAL_POINT) 
            {
                Position_Engine.loadBoat(Items.WOLF);
            }
        } 
        else if (R_Goat.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.GOAT) == Position.FINAL_POINT) 
            {
                Position_Engine.loadBoat(Items.GOAT);
            }
        } 
        else if (R_Cabbage.contains(e.getPoint())) 
        {
            if (Position_Engine.getPosition(Items.CABBAGE) == Position.FINAL_POINT) 
            {
                Position_Engine.loadBoat(Items.CABBAGE);
            }
        } 
        else if (R_Boat_Driver.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.FINAL_POINT && Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
                Position_Engine.unloadBoat(Items.FARMER);
            }
        } 
        else if (R_Boat_Passenger.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.FINAL_POINT) 
            {
                if (Position_Engine.getPosition(Items.WOLF) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.WOLF);
                } 
                else if (Position_Engine.getPosition(Items.GOAT) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.GOAT);
                } 
                else if (Position_Engine.getPosition(Items.CABBAGE) == Position.THE_BOAT) 
                {
                    Position_Engine.unloadBoat(Items.CABBAGE);
                }
            }
        } 
        else if (R_Boat.contains(e.getPoint())) 
        {
            if (Position_Engine.getCurrentLocation() == Position.FINAL_POINT && Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
                Position_Engine.rowBoat();
            }
        } 
        else 
        {
            return;
        }
        repaint();
    }

    // NOT USED EVENTS
	@Override
	public void mousePressed(MouseEvent e) {};

	@Override
	public void mouseReleased(MouseEvent e) {};

	@Override
	public void mouseEntered(MouseEvent e) {};

	@Override
	public void mouseExited(MouseEvent e) {};
	
	
	
	@Override
    public void paintComponent(Graphics g) 
    {
		// BACKGROUND COLOR
        g.setColor(myLightBlue);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //RIVER COLOR
        g.setColor(Color.blue);
        g.fillRoundRect(140, 325, 520, 336, 0, 0);
        
        // FIELD LEFT
        g.setColor(myFiledBrown);
        g.fillRoundRect(0, 355, 140, 306, 0, 0);
        
        // FIELD RIGHT
        g.setColor(myFiledBrown);
        g.fillRoundRect(660, 355, 225, 306, 0, 0);
        
        // GRASS LEFT
        g.setColor(myGrassGreen);
        g.fillRoundRect(0, 325, 140, 30, 0, 0);
        
        // GRASS RIGHT
        g.setColor(myGrassGreen);
        g.fillRoundRect(660, 325, 225, 30, 0, 0);
        
        // CLOUD 1
        g.setColor(myWhite);
        g.fillRoundRect(190, 50, 80, 50, 50, 30);
        
        // CLOUD 2
        g.setColor(myWhite);
        g.fillRoundRect(350, 80, 80, 50, 50, 30);
        
        // CLOUD 3
        g.setColor(myWhite);
        g.fillRoundRect(580, 20, 80, 50, 50, 30);
        
        
        paintObjectsOnLeft(g);
        paintObjectsOnRight(g);
        paintObjectsOnBoat(g);
        
        String message = "";
        if (Position_Engine.thePlayerLost()) 
        {
            message = "Sorry, You Lost!";
            newStart = true;
        }
        if (Position_Engine.thePlayerWon()) 
        {
            message = "Yes, You are The Winner!";
            newStart = true;
        }
        paintMessage(message, g);
        if (newStart) 
        {
            paintRestartButton(g);
        }
    }
	
    public void paintObjectsOnLeft(Graphics g) 
    {
        if (Position_Engine.getPosition(Items.FARMER) == Position.STARTING_POINT) 
        {
        	//FARMER LEFT
            g.drawImage(farmer_IMG, 80, 215, 50, 50, this);
            paintStringInRectangle("Farmer", 80, 235, 50, 50, g);
            
        }
        if (Position_Engine.getPosition(Items.WOLF) == Position.STARTING_POINT) 
        {
        	// WOLF LEFT
            g.drawImage(wolf_IMG, 20, 215, 50, 50, this);
            paintStringInRectangle("Wolf", 20, 235, 50, 50, g);
        	
        }
        if (Position_Engine.getPosition(Items.GOAT) == Position.STARTING_POINT) 
        {
        	// GOAT LEFT
            g.drawImage(goat_IMG, 20, 275, 50, 50, this);
            paintStringInRectangle("Goat", 20, 295, 50, 50, g);
        }
        if (Position_Engine.getPosition(Items.CABBAGE) == Position.STARTING_POINT) 
        {
        	// CABBAGE LEFT
        	g.drawImage(cabbage_IMG, 80, 275, 50, 50, this);
            paintStringInRectangle("Cabbage", 80, 295, 50, 50, g);
            
        }
    }
    
    public void paintObjectsOnRight(Graphics g) 
    {

        if (Position_Engine.getPosition(Items.FARMER) == Position.FINAL_POINT) 
        {
        	//FARMER ON BOAT R
            g.drawImage(farmer_IMG, 730, 215, 50, 50, this);
            paintStringInRectangle("Farmer", 730, 235, 50, 50, g);
        }
        if (Position_Engine.getPosition(Items.WOLF) == Position.FINAL_POINT) 
        {
        	//WOLF ON BOAT R
            g.drawImage(wolf_IMG, 670, 215, 50, 50, this);
            paintStringInRectangle("Wolf", 670, 235, 50, 50, g);
        }
        if (Position_Engine.getPosition(Items.GOAT) == Position.FINAL_POINT) 
        {
        	//GOAT ON BOAT R
            g.drawImage(goat_IMG, 670, 275, 50, 50, this);
            paintStringInRectangle("Goat", 670, 295, 50, 50, g);
        }
        if (Position_Engine.getPosition(Items.CABBAGE) == Position.FINAL_POINT) 
        {
        	// CABBAGE ON BOAT R
            g.drawImage(cabbage_IMG, 730, 275, 50, 50, this);
            paintStringInRectangle("Cabbage", 730, 295, 50, 50, g);
        }
    }
    
    
    public void paintObjectsOnBoat(Graphics g) 
    {
        if (Position_Engine.getCurrentLocation() == Position.STARTING_POINT) 
        {
        		//BOAT LEFT L
        		g.drawImage(boat_IMG, 140, 275, 112, 50, this);
            
            if (Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
            	
            	//FARMER ON BOAT L
                g.drawImage(farmer_IMG, 140, 215, 50, 50, this);
                paintStringInRectangle("Farmer", 140, 235, 50, 50, g);

            }
            if (Position_Engine.getPosition(Items.WOLF) == Position.THE_BOAT) 
            {
            	//WOLF ON BOAT L
                g.drawImage(wolf_IMG, 200, 215, 50, 50, this);
                paintStringInRectangle("Wolf", 200, 235, 50, 50, g);

            } 
            else if (Position_Engine.getPosition(Items.GOAT) == Position.THE_BOAT) 
            {
            	//GOAT ON BOAT L
                g.drawImage(goat_IMG, 200, 215, 50, 50, this);
                paintStringInRectangle("Goat", 200, 235, 50, 50, g);
            } 
            else if (Position_Engine.getPosition(Items.CABBAGE) == Position.THE_BOAT) 
            {
            	// CABBAGE ON BOAT L
                g.drawImage(cabbage_IMG, 200, 215, 50, 50, this);
                paintStringInRectangle("Cabbage", 200, 235, 50, 50, g);
            }
        }
        
        
        if (Position_Engine.getCurrentLocation() == Position.FINAL_POINT) 
        {
        	//BOAT RIGHT
        	g.drawImage(boat_IMG, 550, 275, 112, 50, this);
            
            if (Position_Engine.getPosition(Items.FARMER) == Position.THE_BOAT) 
            {
                
            	//FARMER ON BOAT R
                g.drawImage(farmer_IMG, 550, 215, 50, 50, this);
                paintStringInRectangle("Farmer", 550, 235, 50, 50, g);
            }
            if (Position_Engine.getPosition(Items.WOLF) == Position.THE_BOAT) 
            {
            	//WOLF ON BOAT R
                g.drawImage(wolf_IMG, 610, 215, 50, 50, this);
                paintStringInRectangle("Wolf", 610, 235, 50, 50, g);

            } 
            else if (Position_Engine.getPosition(Items.GOAT) == Position.THE_BOAT) 
            {
            	//GOAT ON BOAT R
                g.drawImage(goat_IMG, 610, 215, 50, 50, this);
                paintStringInRectangle("Goat", 610, 235, 50, 50, g);
            } 
            else if (Position_Engine.getPosition(Items.CABBAGE) == Position.THE_BOAT) 
            {
            	//GOAT ON BOAT R
                g.drawImage(cabbage_IMG, 610, 215, 50, 50, this);
                paintStringInRectangle("Cabbage", 610, 235, 50, 50, g);
            }
        }
    }
    
    
    public void paintStringInRectangle(String str, int x, int y, int width, int height, Graphics g) 
    {
        g.setColor(Color.GREEN);
        int fontSize = (height >= 40) ? 12 : 4;
        g.setFont(new Font("Calibri", Font.BOLD, fontSize));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = x + width / 2 - fm.stringWidth(str) / 2;
        int strYCoord = y + height / 2 + fontSize / 2 - 4;
        g.drawString(str, strXCoord, strYCoord);
    }

    
    public void paintMessage(String message, Graphics g) 
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = 400 - fm.stringWidth(message) / 2;
        int strYCoord = 100;
        g.drawString(message, strXCoord, strYCoord);
    }
    
    
    public void restartButton(String str, int x, int y, int width, int height, Graphics g) 
    {
        g.setColor(Color.BLACK);
        int fontSize = (height >= 40) ? 36 : 18;
        g.setFont(new Font("Calibri", Font.BOLD, fontSize));
        FontMetrics fm = g.getFontMetrics();
        int strXCoord = x + width / 2 - fm.stringWidth(str) / 2;
        int strYCoord = y + height / 2 + fontSize / 2 - 4;
        g.drawString(str, strXCoord, strYCoord);
    }
    
    
    public void paintRestartButton(Graphics g)
    {
        g.setColor(Color.BLACK);
        paintBorder(NewStartButton, 3, g);
        g.setColor(Color.orange);
        paintRectangle(NewStartButton, g);
        restartButton("Wrong Step. The River Restart!", NewStartButton.x, NewStartButton.y, NewStartButton.width,
                NewStartButton.height, g);
    }

    public void paintBorder(Rectangle r, int thickness, Graphics g) 
    {
        g.fillRect(r.x - thickness, r.y - thickness, r.width + (2 * thickness), r.height + (2 * thickness));
    }

    
    public void paintRectangle(Rectangle r, Graphics g) 
    {
        g.fillRect(r.x, r.y, r.width, r.height);
    }
}