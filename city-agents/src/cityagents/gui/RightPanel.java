package cityagents.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import cityagents.core.Direction;
import cityagents.core.Grass;
import cityagents.core.House;
import cityagents.core.Street;
import cityagents.core.WorldMap;
import cityagents.core.WorldObject;
import cityagents.core.agents.CarAgent;
import cityagents.gui.listeners.RPanelMouseListener;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int size = 30;
	private PrincipalPanel superiorPanel;
	private WorldMap world;
	private ImagesHandler images;

	private List<Point> cellToDraw;
	private boolean startDraw = false;
	private boolean addAnAgent = false;
	private boolean editDirection = false;
	private Direction currentDirection = Direction.NONE;

	public RightPanel(PrincipalPanel p) {
		this.setOpaque(false);
		images = ImagesHandler.getInstance();
		superiorPanel = p;
		world = WorldMap.getInstance();
		cellToDraw = new ArrayList<Point>();
		this.setPreferredSize(new Dimension(52 * 2 * size, 52 * size));
		addMouseListener(new RPanelMouseListener(this, size));
		addMouseMotionListener(new RPanelMouseListener(this, size));
	}
	
	/**
	 * @return the currentDirection
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	/**
	 * @param currentDirection the currentDirection to set
	 */
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	/**
	 * @param editDirection
	 *            the editDirection to set
	 */
	public void setEditDirection(boolean editDirection) {
		this.editDirection = editDirection;
	}

	/**
	 * @return the editDirection
	 */
	public boolean isEditDirection() {
		return editDirection;
	}

	/**
	 * @return the startDraw
	 */
	public boolean isStartDraw() {
		return startDraw;
	}

	public void setStartDraw(boolean flag) {
		startDraw = flag;
	}

	/**
	 * @return the addAnAgent
	 */
	public boolean isAddAnAgent() {
		return addAnAgent;
	}

	public void setAddAnAgent(boolean flag) {
		addAnAgent = flag;
	}

	public void addCellToDraw(Point p) {
		cellToDraw.add(p);
	}

	public List<Point> getCellsToDraw() {
		return Collections.unmodifiableList(cellToDraw);
	}

	public void clearCellToDraw() {
		cellToDraw.clear();
	}

	/**
	 * @return the superiorPanel
	 */
	public PrincipalPanel getSuperiorPanel() {
		return superiorPanel;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		for (int i = 0; i < world.getWorldSize() * 2; i++) {
			for (int j = 0; j < world.getWorldSize(); j++) {
				WorldObject element = world.getElement(i, j);

				if (element instanceof CarAgent) {
					graphics.drawImage(images.getStreet(), i * size + 20, j	* size + 20, null);
					graphics.drawImage(images.getCar(), i * size + 20, j * size	+ 20, null);
				} else if (element instanceof Grass) {
					graphics.drawImage(images.getGrass(), i * size + 20, j * size + 20, null);
				} else if (element instanceof House) {
					graphics.drawImage(images.getGrass(), i * size + 20, j * size + 20, null);
					graphics.drawImage(images.getHouse(), i * size + 20, j * size + 20, null);
				} else if (element instanceof Street) {
					graphics.drawImage(images.getStreet(), i * size + 20, j * size + 20, null);
					if( isEditDirection() ) {
						drawDirection(graphics, element, i, j);
					}
				}
			}
		}
	}
	
	private void drawDirection(Graphics graphics, WorldObject element, int i, int j) {
		Street street = (Street) element;
		Direction dir = street.getDirection();
		if( dir.equals(Direction.NORTH)) {
			graphics.drawImage(images.getArrowNorth(), i * size + 20, j * size + 20, null);
		} else if( dir.equals(Direction.SOUTH)) {
			graphics.drawImage(images.getArrowSouth(), i * size + 20, j * size + 20, null);
		} else if( dir.equals(Direction.WEST)) {
			graphics.drawImage(images.getArrowWest(), i * size + 20, j * size + 20, null);
		} else if( dir.equals(Direction.EAST)) {
			graphics.drawImage(images.getArrowEast(), i * size + 20, j * size + 20, null);
		} else if( dir.equals(Direction.NORTH_WEST)) {
			
		} else if( dir.equals(Direction.NORTH_EAST)) {
			
		} else if( dir.equals(Direction.SOUTH_WEST)) {
			
		} else if( dir.equals(Direction.SOUTH_EAST)) {
			
		} else if( dir.equals(Direction.NORTH_WEST_EAST)) {
			
		} else if( dir.equals(Direction.NORTH_WEST_EAST)) {
			
		} else if( dir.equals(Direction.SOUTH_WEST_EAST)) {
			
		} else if( dir.equals(Direction.WEST_NORTH_SOUTH)) {
			
		} else if( dir.equals(Direction.EAST_NORTH_SOUTH)) {
			
		}
	}
}
