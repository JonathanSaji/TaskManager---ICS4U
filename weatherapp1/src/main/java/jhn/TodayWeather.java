package jhn;
import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class TodayWeather extends JFrame implements MouseListener {

	public JPanel todayPanel;

    TodayWeather(JFrame parentFrame, Weather weather) {

		todayPanel = new JPanel(new GridBagLayout());
		todayPanel.setBackground(Color.BLACK);
		parentFrame.add(todayPanel);


        String labelTexts[] = {};

        for(int i = 0; i <= 24; i++){
            if(i == 0){
                labelTexts[i] = "12 AM";
            }
            else if(i > 0 && i <= 12){
                labelTexts[i] = i + " AM";
            }
            else{
                labelTexts[i] = (i - 12) + " PM";
            }
            System.out.println(" Label ");
            System.out.println(labelTexts[i]);
        }

        
        

		// JLabel zero = new JLabel();
        // labelCreator(zero, "12 AM " + weather.getTemp(0),true,0,0);

		// JLabel one = new JLabel();
        // labelCreator(one, "1 AM " + weather.getTemp(1),true,1,1);

		// JLabel two = new JLabel();
        // labelCreator(two, "2 AM " + weather.getTemp(2),true,0,2);

		// JLabel three = new JLabel();
        // labelCreator(three, "3 AM " + weather.getTemp(3),true,1,3);
		
		



    }

	public void labelCreator(JLabel label, String text, boolean addMouseListener,int gridy,int gridx) {
       
        label = new JLabel(text, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300, 75));
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Monospaced", Font.PLAIN, 24));
        label.setBackground(Color.DARK_GRAY);
        if(addMouseListener) {
            label.addMouseListener(this);
        }
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;   // Always in the same column to stay centered
        gbc.gridy = gridy; // Increments to move down
        gbc.insets = new Insets(10, 50, 10, 50); // Adds 10 pixels of space above and below
        
        todayPanel.add(label, gbc);

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
		if (e.getComponent() instanceof JLabel) {
        JLabel label = (JLabel) e.getComponent();
        label.setOpaque(true);
        label.setForeground(Color.YELLOW);
        }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component
		if (e.getComponent() instanceof JLabel) {
        JLabel label = (JLabel) e.getComponent();
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
		}
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       
    }
}
