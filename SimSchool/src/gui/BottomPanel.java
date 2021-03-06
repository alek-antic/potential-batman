package gui;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import schoolobjects.LivingThing;
import schoolobjects.animals.Animal;
import schoolobjects.people.Person;

public class BottomPanel extends JPanel {
	
	private ControlListener l;
	private ArrayList<LivingThing> livers;
	private ArrayList<JRadioButton> buttons;

	public BottomPanel(ControlListener listen) {
		ButtonGroup group = new ButtonGroup();
		buttons = new ArrayList<JRadioButton>();
		l = listen;
		livers = l.getDrawings();
		for(LivingThing alive : livers) {
			if(alive instanceof Animal)
				buttons.add(new JRadioButton(((Animal)alive).getType()));
			else if(alive instanceof Person)
				buttons.add(new JRadioButton(((Person)alive).getName()));
		}
		
		setLayout(new GridLayout(1,buttons.size() + 1));
		
		for(JRadioButton b : buttons) {
			group.add(b);
			add(b);
			b.addActionListener(new RadioHandler());
		}
		add(new JLabel("Press \'ENTER\' for info"));
	}
	
	private class RadioHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < buttons.size(); i ++) {
				l.setSelected(livers.get(i), buttons.get(i).isSelected());
			}
		}
		
	}
	
}
