import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends JPanel {

	private JRadioButton circle, square, triangle;
	private JSlider slider;
	private JCheckBox bold, italic, underline;
	private JPanel lButtons, rButtons;

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

	}

	private class RadioHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == circle) {

			} else if (source == square) {

			} else {

			}
		}

	}

	private class SliderHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			
		}

	}

	private class CheckBoxHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == bold) {

			} else if (source == italic) {

			} else {

			}
		}

	}
}
