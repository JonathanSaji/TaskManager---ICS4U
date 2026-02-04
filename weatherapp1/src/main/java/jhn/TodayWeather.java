package jhn;
import javax.swing.*;

import java.awt.event.*;

import java.awt.*;
public class TodayWeather implements MouseListener {
   
    TodayWeather(JFrame parentFrame) {
      JPanel todayPanel = new JPanel();
      todayPanel.setBackground(Color.CYAN);
      parentFrame.add(todayPanel);
    }


@Override
	public void mousePressed(MouseEvent e) {
		// Invoked when a mouse button has been pressed on a component


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Invoked when a mouse button has been released on a component
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component

    }


    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

}
