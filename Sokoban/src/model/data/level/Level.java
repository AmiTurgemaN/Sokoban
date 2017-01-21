package model.data.level;

import java.io.Serializable;
import java.util.ArrayList;

import model.data.gameObjects.Area;
import model.data.gameObjects.AreaPlayer;
import model.data.gameObjects.Box;
import model.data.gameObjects.BoxedArea;
import model.data.gameObjects.GeneralGameObject;
import model.data.gameObjects.Player;
import model.data.gameObjects.Space;
import model.data.gameObjects.Wall;
import model.data.point.GeneralIntegerPoint;
import model.data.point.Point2D;
import model.policy.GeneralSokobanPolicy;

public class Level implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Wall> walls;
	private ArrayList<Box> boxes;
	private ArrayList<Area> areas;
	private ArrayList<Player> players;
	private ArrayList<Space> spaces;
	private ArrayList<BoxedArea> boxedAreas;
	private ArrayList<AreaPlayer> areaPlayers;
	private int levelWidth;
	private int levelHeight;
	private boolean completed;
	private String levelString;
	private String levelName;
	private GeneralSokobanPolicy policy;

	public Level()
	{
		walls = new ArrayList<Wall>();
		boxes = new ArrayList<Box>();
		areas = new ArrayList<Area>();
		players = new ArrayList<Player>();
		spaces = new ArrayList<Space>();
		boxedAreas = new ArrayList<BoxedArea>();
		areaPlayers = new ArrayList<AreaPlayer>();
		this.levelHeight=0;
		this.levelWidth=0;
		this.levelName="";
		this.levelString="";
		this.completed=false;
		this.policy=null;
	}

	public ArrayList<Wall> getWalls() {
		return walls;
	}

	public void setWalls(ArrayList<Wall> walls) {
		this.walls = walls;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<Area> areas) {
		this.areas = areas;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public GeneralIntegerPoint getPlayerLocation()
	{
		if(!this.areaPlayers.isEmpty())
			return this.areaPlayers.get(0).getPoint();
		if(!this.players.isEmpty())
			return this.players.get(0).getPoint();
		return null;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setLevelWidth(int levelWidth) {
		this.levelWidth = levelWidth;
	}

	public void setLevelHeight(int levelHeight) {
		this.levelHeight = levelHeight;
	}

	public Level(GeneralSokobanPolicy policy)
	{
		this.policy=policy;
		walls = new ArrayList<Wall>();
		boxes = new ArrayList<Box>();
		areas = new ArrayList<Area>();
		players = new ArrayList<Player>();
		spaces = new ArrayList<Space>();
		boxedAreas = new ArrayList<BoxedArea>();
		areaPlayers = new ArrayList<AreaPlayer>();
		this.levelWidth=0;
		this.levelHeight=0;
		this.completed=false;
		this.levelString="";
		this.levelName="";
	}

	private void initLevel()
	{
		walls = new ArrayList<Wall>();
		boxes = new ArrayList<Box>();
		areas = new ArrayList<Area>();
		players = new ArrayList<Player>();
		spaces = new ArrayList<Space>();
		boxedAreas = new ArrayList<BoxedArea>();
		areaPlayers = new ArrayList<AreaPlayer>();
		this.levelWidth=0;
		this.levelHeight=0;
		this.completed=false;
		this.levelString="";
		this.levelName="";
	}

	public boolean isCompleted() {
		return completed;
	}

	public ArrayList<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(ArrayList<Space> spaces) {
		this.spaces = spaces;
	}

	public ArrayList<BoxedArea> getBoxedAreas() {
		return boxedAreas;
	}

	public void setBoxedAreas(ArrayList<BoxedArea> boxedAreas) {
		this.boxedAreas = boxedAreas;
	}

	public ArrayList<AreaPlayer> getAreaPlayers() {
		return areaPlayers;
	}

	public void setAreaPlayers(ArrayList<AreaPlayer> areaPlayers) {
		this.areaPlayers = areaPlayers;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Level(String level)	
	{
		this.levelString=level;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}

	public String getLevelString() {
		return levelString;
	}

	public void setLevelString(String levelString) {
		this.levelString = levelString;
	}

	public GeneralSokobanPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(GeneralSokobanPolicy policy) {
		this.policy = policy;
	}

	public int getLevelWidth() 
	{
		return this.levelWidth;
	}

	public int getLevelHeight() 
	{
		return this.levelHeight;
	}

	public GeneralGameObject getObjectByPoint(GeneralIntegerPoint point)
	{
		for(int i=0;i<walls.size();i++)
			if(walls.get(i).getPoint().compareTo(point)==0)
				return new Wall();
		for(int i=0;i<boxes.size();i++)
			if(boxes.get(i).getPoint().compareTo(point)==0)
				return new Box();
		for(int i=0;i<players.size();i++)
			if(players.get(i).getPoint().compareTo(point)==0)
				return new Player();
		for(int i=0;i<boxedAreas.size();i++)
			if(boxedAreas.get(i).getPoint().compareTo(point)==0)
				return new BoxedArea();
		for(int i=0;i<areas.size();i++)
			if(areas.get(i).getPoint().compareTo(point)==0)
				return new Area();
		for(int i=0;i<spaces.size();i++)
			if(spaces.get(i).getPoint().compareTo(point)==0)
				return new Space();
		for(int i=0;i<areaPlayers.size();i++)
			if(areaPlayers.get(i).getPoint().compareTo(point)==0)
				return new AreaPlayer();
		return null;
	}

	public void updateLevel(GeneralGameObject source, GeneralGameObject dest,
			GeneralGameObject newDest) {

		String [] levelRows = levelString.split("\n");
		String newLevelString="";

		switch(source.getType())
		{
		case AREAPLAYER:
			for(int i=0;i<areaPlayers.size();i++)
				if(areaPlayers.get(i).getPoint().getX() == source.getPoint().getX() &&
				areaPlayers.get(i).getPoint().getY() == source.getPoint().getY())
					areaPlayers.remove(i);
			areas.add(new Area(source.getPoint()));
			break;
		case PLAYER:
			for(int i=0;i<players.size();i++)
				if(players.get(i).getPoint().getX() == source.getPoint().getX() &&
				players.get(i).getPoint().getY() == source.getPoint().getY())
					players.remove(i);
			spaces.add(new Space(source.getPoint()));
			break;
		default:
			break;
		}
		switch(dest.getType())
		{
		case BOX:
			for(int i=0;i<boxes.size();i++)
				if(boxes.get(i).getPoint().getX() == dest.getPoint().getX() &&
				boxes.get(i).getPoint().getY() == dest.getPoint().getY())
					boxes.remove(i);
			players.add(new Player(dest.getPoint()));
			switch(newDest.getType())
			{
			case AREA:
				for(int i=0;i<areas.size();i++)
					if(areas.get(i).getPoint().getX() == newDest.getPoint().getX() &&
					areas.get(i).getPoint().getY() == newDest.getPoint().getY())
						areas.remove(i);
				boxedAreas.add(new BoxedArea(newDest.getPoint()));
				break;
			case SPACE:
				for(int i=0;i<spaces.size();i++)
					if(spaces.get(i).getPoint().getX() == newDest.getPoint().getX() &&
					spaces.get(i).getPoint().getY() == newDest.getPoint().getY())
						spaces.remove(i);
				boxes.add(new Box(newDest.getPoint()));
			default:
				break;
			}
			break;
		case BOXEDAREA:
			for(int i=0;i<boxedAreas.size();i++)
				if(boxedAreas.get(i).getPoint().getX() == dest.getPoint().getX() &&
				boxedAreas.get(i).getPoint().getY() == dest.getPoint().getY())
					boxedAreas.remove(i);
			areaPlayers.add(new AreaPlayer(dest.getPoint()));
			switch(newDest.getType())
			{
			case AREA:
				for(int i=0;i<areas.size();i++)
					if(areas.get(i).getPoint().getX() == newDest.getPoint().getX() &&
					areas.get(i).getPoint().getY() == newDest.getPoint().getY())
						areas.remove(i);
				boxedAreas.add(new BoxedArea(newDest.getPoint()));
				break;
			case SPACE:
				for(int i=0;i<spaces.size();i++)
					if(spaces.get(i).getPoint().getX() == newDest.getPoint().getX() &&
					spaces.get(i).getPoint().getY() == newDest.getPoint().getY())
						spaces.remove(i);
				boxes.add(new Box(newDest.getPoint()));
			default:
				break;
			}
			break;
		case AREA:
			for(int i=0;i<areas.size();i++)
				if(areas.get(i).getPoint().getX() == dest.getPoint().getX() &&
				areas.get(i).getPoint().getY() == dest.getPoint().getY())
					areas.remove(i);
			areaPlayers.add(new AreaPlayer(dest.getPoint()));
			break;
		case SPACE:
			for(int i=0;i<spaces.size();i++)
				if(spaces.get(i).getPoint().getX() == dest.getPoint().getX() &&
				spaces.get(i).getPoint().getY() == dest.getPoint().getY())
					spaces.remove(i);
			players.add(new Player(dest.getPoint()));
			break;
		default :
			break;
		}

		for(int i=0;i<levelRows.length;i++)
		{
			for(int j=0;j<levelRows[i].length();j++)
			{
				if(i==source.getPoint().getY() && j==source.getPoint().getX())
				{
					GeneralGameObject tempObject = getObjectByPoint(source.getPoint());
					newLevelString+= tempObject.getSymbol();
				}
				else if(i==dest.getPoint().getY() && j==dest.getPoint().getX())
				{
					GeneralGameObject tempObject = getObjectByPoint(dest.getPoint());
					newLevelString+= tempObject.getSymbol();
				}
				else if(i==newDest.getPoint().getY() && j==newDest.getPoint().getX())
				{
					GeneralGameObject tempObject = getObjectByPoint(newDest.getPoint());
					newLevelString+= tempObject.getSymbol();
				}
				else
				{
					newLevelString+=levelRows[i].charAt(j);
				}
			}
			newLevelString+="\n";

		}
		this.levelString = newLevelString;
		checkLevelCompleted();
	}

	private boolean checkLevelCompleted() {
		if(this.areaPlayers.isEmpty() && this.areas.isEmpty() && this.boxes.isEmpty())
		{
			this.completed=true;
			System.out.println(this.levelString);
			System.out.println("Level completed!");
			return true;
		}
		return false;
	}

	public void init2DLevel()
	{
		int tempCols=0;
		int rows=1;
		int cols=0;
		for(int i=0;i<this.levelString.length();i++)
		{
			if(this.levelString.charAt(i)=='\r')
			{
				rows++;
				if(tempCols>cols)
				{
					cols=tempCols;
				}
				tempCols=0;

			}
			else
				tempCols++;
		}
		cols--;

		this.levelWidth=cols;
		this.levelHeight=rows;
		this.walls = new ArrayList<Wall>();
		this.areas = new ArrayList<Area>();
		this.boxes = new ArrayList<Box>();
		this.players = new ArrayList<Player>();
		this.spaces = new ArrayList<Space>();
		this.boxedAreas = new ArrayList<BoxedArea>();
		this.areaPlayers = new ArrayList<AreaPlayer>();

		String [] levelRows = levelString.split("\r\n");
		for(int i=0;i<levelRows.length;i++)
			for(int j=0;j<levelRows[i].length();j++)
				switch(levelRows[i].charAt(j))
				{
				case '#':
					this.walls.add(new Wall(new Point2D(j,i)));
					break;
				case 'o':
					this.areas.add(new Area(new Point2D(j,i)));
					break;
				case '$':
					this.boxedAreas.add(new BoxedArea(new Point2D(j,i)));
					break;
				case 'B':
					this.areaPlayers.add(new AreaPlayer(new Point2D(j,i)));
					break;
				case '@':
					this.boxes.add(new Box(new Point2D(j,i)));
					break;
				case 'A':
					this.players.add(new Player(new Point2D(j,i)));
					break;
				case ' ' :
					this.spaces.add(new Space(new Point2D(j,i)));
					break;
				case '\r':
				case '\n':
					break;
				default :
					System.out.println("Could not load "+this.getLevelName()+" file");
					initLevel();
					return;
				}
		checkLevelCompleted();
	}

}