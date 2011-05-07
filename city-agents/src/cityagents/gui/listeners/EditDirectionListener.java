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
package cityagents.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import cityagents.core.Direction;
import cityagents.gui.PrincipalFrame;
import cityagents.gui.RightPanel;

/**
 *
 * @author Deep Blue Team
 */
public class EditDirectionListener implements ActionListener {
	
	private RightPanel panel;
	
	/**
	 * 
	 */
	public EditDirectionListener() {
		panel = PrincipalFrame.getInstance().getRightPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if( source.getText().equals("North")) {
			panel.setCurrentDirection(Direction.NORTH);
		} else if( source.getText().equals("South")) {
			panel.setCurrentDirection(Direction.SOUTH);
		} else if( source.getText().equals("West")) {
			panel.setCurrentDirection(Direction.WEST);
		} else if( source.getText().equals("East")) {
			panel.setCurrentDirection(Direction.EAST);
		} else if( source.getText().equals("Close")) {
			panel.setEditDirection(false);
			panel.repaint();
		}
	}

}
