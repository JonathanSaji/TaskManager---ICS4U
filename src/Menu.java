
import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class Menu extends JFrame implements MouseListener{

    JPanel panel;
    JPanel panel2;
    boolean change = false;
    public Menu() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Menu Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(20, 20, 10, 10));
        add(panel);


        for (int i = 1; i <= 400; i++) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 48));
            label.setForeground(Color.WHITE);
            numberCreator(label);
        }
        
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when the mouse button has been clicked (pressed and released) on a component
        if (e.getComponent() instanceof JLabel) {
        JLabel label = (JLabel) e.getComponent();
        String text = label.getText();
        System.out.println("Label says: " + text);
        }
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
        change = !change;
        if (change){
            e.getComponent().setForeground(Color.GREEN);
        }
        else{
            e.getComponent().setForeground(Color.RED);
        }        

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component
        change = !change;
        if (change){
            e.getComponent().setForeground(Color.GREEN);
        }
        else{
            e.getComponent().setForeground(Color.RED);
        }        
	}

    public void numberCreator(JLabel label){
        label.addMouseListener(this);
        panel.add(label);
    }



}

/*
Sources:
https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

*/