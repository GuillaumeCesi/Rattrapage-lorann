package model;
import java.util.ArrayList;

import contract.IElement;
import contract.IEntity;
import contract.IHero;
import contract.ILoadMap;
import contract.ISize;
import contract.Movement;
import model.elements.Element;
import model.elements.Hero;
import model.elements.Spell;

/**
 * load map of the game
 */
public class LoadMap implements ILoadMap {

    /**
     * number for level
     *  Lorann can exit in map
     */
    private int number;
    private boolean exit = false;

    private ArrayList<IEntity> entities;

    /**
     * BDD id 
     */
    private int id;

    /**
     * IElement
     */
    private IElement elements[][];

    /**
     * IHero
     */

    private IHero hero;

    /**
     * ISize
     */
    private ISize size;

    /**
     * Map finish
     */
    private boolean end;
    

    /**
     * locate of elements
     * @param width
     * @param height
     * @param hero
     *
     */
    public LoadMap(int id,int width, int height, Hero hero, int number) {
        this.size = new Size(width,height);
        this.hero = hero;
        this.number = number;
        this.elements = new Element[height][width];
        this.entities = new ArrayList<IEntity>();
        this.id = id;
    }

    /**
     * Add entity
     * @param entity
     */
    public void addEntity(IEntity entity){
        this.entities.add(entity);
    }

    /**
     * Remove entity
     * @param entity
     */
    public void removeEntity(IEntity entity){
        this.entities.remove(entity);
    }
    /**
     * Create spell
     * @param direction
     */

    public void createSpell(int x, int y, Movement movement) {
        this.addEntity(new Spell(x,y,movement));
    }
    /**
     * Death element
     * @param element
     */
    public void destroyElement(IElement element) {
        if (element instanceof IEntity) {
            this.entities.remove(element);
        } else {
            this.setElement(element.getLocation().getX(), element.getLocation().getY(), null);
        }

    }


    /**
     * getNumberMap
     * @return
     * The number
     */
    public int getNumber() {
        return number;
    }
    /**
     * get load query
     *@return null
     */
    public String getLoadQuery(int id) {
        return null;
    }
    /**
     * set number of map
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * getSize map
     * @return
     * dimension
     */
    public ISize getSize() {
        return size;
    }
    /**
     * set dimension map load
     * @param dimention
     * dimension
     */
    public void setSize(ISize size) {
        this.size = size;
    }
    /**
     * get pos hero map load
     * @return
     * Hero
     */
    public IHero getHero() {
        return hero;
    }
    /**
     * set hero pos map
     * @param hero
     * The hero
     */
    public void setHero(IHero hero) {
        this.hero = hero;
    }

    public IElement[][] getElements() {
        return elements;
    }

    public void setElements(IElement[][] elements) {
        this.elements = elements;
    }
    /**
     * getElement level 
     * @return The element
     */
    public IElement getElement(int x, int y){
        return this.elements[y][x];
    }

    /**
     * Locate Element of element
     * @param x
     * locate x
     * @param y
     * locate y
     * @param element
     */
    public void setElement(int x, int y, IElement element){
        this.elements[y][x] = element;
    }

    /**
     * getEntities 
     * @return
     * The entity
     */
    @SuppressWarnings("unchecked")
	public ArrayList<IEntity> getEntities() {
        return ((ArrayList<IEntity>) entities.clone());
    }
    /**
     * setEntities
     * @param entities
     * The entity
     */
    public void setEntities(ArrayList<IEntity> entities) {
        this.entities = entities;
    }
    /**
     * get exit map
     * @return
     * The sprite
     */
    public boolean isExit() {
        return exit;
    }
    /**
     * set exit map
     * @param exit
     * The exit
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }
    /**
     * if level map finish
     */

    public boolean isEnd() {
        return end;
    }
    /**
     * Set if the level is finished
     * @param finished
     * The end of the level
     */
    public void setEnd(boolean end) {
        this.end = end;
    }
    /**
     * Get the value of the level
     * @return
     * The value
     */

    public int getValue() {
        return 1000;
    }
    /**
     * Get the id of the level
     * @return
     * The ID
     */
    public int getId() {
        return id;
    }
    /**
     * Set the Id of the level
     * @param id
     * The ID
     */
    public void setId(int id) {
        this.id = id;
    }
}

