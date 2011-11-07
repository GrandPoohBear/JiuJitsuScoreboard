package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.ModelListener;
import com.gpb.jjscoreboard.model.PlayerModel;

public class DisplayPlayerPanel implements ModelListener, JJSConstants {
	private final PlayerModel model;
	private JPanel panel;
	
	private final JLabel nameLabel;
	private final ColoredBoxPanel pointsBox;
	private final ColoredBoxPanel advantagesBox;
	private final ColoredBoxPanel penaltiesBox;
	
	public DisplayPlayerPanel(PlayerModel model) {
		this.model = model;
		model.addModelListener(this);
		

		double [][] layoutCodes = {{5,F,5},{5,P,5,F,5,P,5,P,5}};
		panel = new JPanel(new TableLayout(layoutCodes));
		
		nameLabel = new JLabel(this.model.getName());
		nameLabel.setFont(nameLabel.getFont().deriveFont(60.f));
		panel.add(nameLabel, "1,1,c,c");
		
		pointsBox = new ColoredBoxPanel("Points", POINT_PANEL_BG, Color.white, 150.f);
		panel.add(pointsBox, "1,3");
		
		advantagesBox = new ColoredBoxPanel("Advantages", ADV_PANEL_BG, Color.white, 60.f);
		panel.add(advantagesBox, "1,5");
		
		penaltiesBox = new ColoredBoxPanel("Penalties", PEN_PANEL_BG, Color.white, 60.f);
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

		public ColoredBoxPanel(String description, Color bgColor, Color textColor, 
				float fontSize) {
			super();
			double [][] layoutCodes = {{F},{F,P}};
			setLayout(new TableLayout(layoutCodes));
			this.description = description;
			this.bgColor = bgColor;
			this.textColor = textColor;
			
			setBackground(this.bgColor);
			
			numberLabel = new JLabel("0");
			numberLabel.setForeground(this.textColor);
			numberLabel.setFont(numberLabel.getFont().deriveFont(fontSize));
			add(numberLabel, "0,0,c,c");
			
			descriptionLabel = new JLabel(this.description);
			descriptionLabel.setForeground(this.textColor);
			descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(18.f));
			add(descriptionLabel, "0,1,c,c");
		}
		
		public void setNumber(int num) {
			numberLabel.setText("" + num);
		}
	}

}
