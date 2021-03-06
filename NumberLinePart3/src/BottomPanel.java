import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.management.AttributeList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends JPanel {

	private JRadioButton circle, square, triangle;
	private JSlider slider;
	private JCheckBox bold, italic, underline;
	private JPanel lButtons, rButtons;
	private ArrayList<ControlListener> listeners;

	public BottomPanel() {

		setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 0));

		lButtons = new JPanel();
		rButtons = new JPanel();
		lButtons.setLayout(new GridLayout(3, 1));
		rButtons.setLayout(new GridLayout(3, 1));

		circle = new JRadioButton("Circle", true);
		square = new JRadioButton("Square");
		triangle = new JRadioButton("Triangle");

		RadioHandler rh = new RadioHandler();
		circle.addActionListener(rh);
		square.addActionListener(rh);
		triangle.addActionListener(rh);

		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(circle);
		radioButtons.add(square);
		radioButtons.add(triangle);

		lButtons.add(circle);
		lButtons.add(square);
		lButtons.add(triangle);

		slider = new JSlider(0, 100);
		slider.setMajorTickSpacing(10);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		SliderHandler sh = new SliderHandler();
		slider.addChangeListener(sh);

		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		underline = new JCheckBox("Underline");
		CheckBoxHandler cbh = new CheckBoxHandler();
		bold.addActionListener(cbh);
		italic.addActionListener(cbh);
		underline.addActionListener(cbh);

		rButtons.add(bold);
		rButtons.add(italic);
		rButtons.add(underline);

		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		lButtons.setBorder(border);
		rButtons.setBorder(border);
		slider.setBorder(border);

		add(lButtons, BorderLayout.WEST);
		add(slider, BorderLayout.CENTER);
		add(rButtons, BorderLayout.EAST);

		listeners = new ArrayList<ControlListener>();
		
	}
	
	public void addControlListener(ControlListener l) {
		listeners.add(l);
	}

	private class RadioHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (circle.isSelected()) {
				for(ControlListener l : listeners) {
					l.changeShape(new Ellipse2D.Double());
				}
			} else if (square.isSelected()) {
				for(ControlListener l : listeners) {
					l.changeShape(new Rectangle());
				}
			} else {
				for(ControlListener l : listeners) {
					l.changeShape(new Polygon());
				}
			}
		}

	}

	private class SliderHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			
			for(ControlListener l : listeners) {
				l.changeLocation(slider.getValue());
			}
		}

	}

	private class CheckBoxHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean[] pressed = new boolean[3];
			pressed[0] = bold.isSelected();
			pressed[1] = italic.isSelected();
			pressed[2] = underline.isSelected();
			
			Map<TextAttribute, Object> fontStyle = new HashMap<TextAttribute, Object>();
			fontStyle.put(TextAttribute.FAMILY, Font.SANS_SERIF);
			fontStyle.put(TextAttribute.SIZE, 16);
			if(pressed[2])
				fontStyle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			if(pressed[1])
				fontStyle.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
			if(pressed[0])
				fontStyle.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
			
			for(ControlListener l : listeners) {
				l.changeFontStyle(new Font(fontStyle));
			}
		}

	}
}
