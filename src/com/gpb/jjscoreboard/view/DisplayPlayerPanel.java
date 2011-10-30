package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gpb.jjscoreboard.model.ModelListener;
import com.gpb.jjscoreboard.model.PlayerModel;

public class DisplayPlayerPanel implements ModelListener {
	private final PlayerModel model;
	private JPanel panel;
	
	private final JLabel nameLabel;
	private final ColoredBoxPanel pointsBox;
	private final ColoredBoxPanel advantagesBox;
	private final ColoredBoxPanel penaltiesBox;
	
	private static final double f = TableLayout.FILL;
	private static final double p = TableLayout.PREFERRED;
	
	public DisplayPlayerPanel(PlayerModel model) {
		this.model = model;
		model.addModelListener(this);
		

		double [][] layoutCodes = {{5,f,5},{5,p,5,f,5,p,5,p,5}};
		panel = new JPanel(new TableLayout(layoutCodes));
		
		nameLabel = new JLabel(this.model.getName());
		panel.add(nameLabel, "1,1,c,c");
		
		pointsBox = new ColoredBoxPanel("Points", Color.blue.darker(), Color.white);
		panel.add(pointsBox, "1,3");
		
		advantagesBox = new ColoredBoxPanel("Advantages", Color.green.darker(), Color.white);
		panel.add(advantagesBox, "1,5");
		
		penaltiesBox = new ColoredBoxPanel("Penalties", Color.red.darker(), Color.white);
		panel.add(penaltiesBox, "1,7");
	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}
	
	@Override
	public void updateFromModel() {
		nameLabel.setText(model.getName());
		pointsBox.setNumber(model.getScore());
		advantagesBox.setNumber(model.getAdvantages());
		penaltiesBox.setNumber(model.getPenalties());
	}
	
	@SuppressWarnings("serial")
	private class ColoredBoxPanel extends JPanel {
		private final String description;
		private final Color bgColor;
		private final Color textColor;
		
		private final JLabel numberLabel;
		private final JLabel descriptionLabel;

		public ColoredBoxPanel(String description, Color bgColor, Color textColor) {
			super();
			double [][] layoutCodes = {{f},{f,p}};
			setLayout(new TableLayout(layoutCodes));
			this.description = description;
			this.bgColor = bgColor;
			this.textColor = textColor;
			
			setBackground(this.bgColor);
			
			numberLabel = new JLabel("0");
			numberLabel.setForeground(this.textColor);
			numberLabel.setFont(numberLabel.getFont().deriveFont(36.f));
			add(numberLabel, "0,0,c,c");
			
			descriptionLabel = new JLabel(this.description);
			descriptionLabel.setForeground(this.textColor);
			add(descriptionLabel, "0,1,c,c");
		}
		
		public void setNumber(int num) {
			numberLabel.setText("" + num);
		}
	}

}
