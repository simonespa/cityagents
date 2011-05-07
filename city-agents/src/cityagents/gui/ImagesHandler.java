/**
 * City Agents is a framework for intelligent mobile agents.
 * Copyright (C) 2011 Deep Blue Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cityagents.gui;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;

/**
 * 
 * @author Deep Blue Team
 */
public class ImagesHandler {

	private static String IMAGES_PATH = "src" + File.separator + "resources" + File.separator;
	private static ImagesHandler instance = null;

	private Image street = null;
	private Image streetButton = null;
	private Image grass = null;
	private Image grassButton = null;
	private Image house = null;
	private Image houseButton = null;
	private Image car = null;

	private ImagesHandler() {
		loadImages();
	}

	public static ImagesHandler getInstance() {
		if (instance == null) {
			instance = new ImagesHandler();
		}
		return instance;
	}

	public Image getGrass() {
		return grass;
	}
	
	public Image getGrassButton() {
		return grassButton;
	}

	public Image getStreet() {
		return street;
	}
	
	public Image getStreetButton() {
		return streetButton;
	}

	public Image getHouse() {
		return house;
	}
	
	public Image getHouseButton() {
		return houseButton;
	}
	
	public Image getCar() {
		return car;
	}

	private void loadImages() {
		Toolkit t = Toolkit.getDefaultToolkit();

		street = t.getImage(IMAGES_PATH + "street.jpg");
		streetButton = t.getImage(IMAGES_PATH + "street-button.jpg");
		grass = t.getImage(IMAGES_PATH + "grass.gif");
		grassButton = t.getImage(IMAGES_PATH + "grass-button.gif");
		house = t.getImage(IMAGES_PATH + "house.jpg");
		houseButton = t.getImage(IMAGES_PATH + "house-button.jpg");
		car = t.getImage(IMAGES_PATH + "car.gif");

		MediaTracker mt = new MediaTracker(new JPanel());
		mt.addImage(street, 0);
		mt.addImage(streetButton, 1);
		mt.addImage(grass, 2);
		mt.addImage(grassButton, 3);
		mt.addImage(house, 4);
		mt.addImage(houseButton, 5);
		mt.addImage(car, 6);

		try {
			for (int i = 0; i <= 6; i++) {
				mt.waitForID(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}