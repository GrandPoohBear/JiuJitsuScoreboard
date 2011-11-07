package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.ModelListener;
import com.gpb.jjscoreboard.model.PlayerModel;

public class ConsolePlayerPanel implements ModelListener, JJSConstants {
	private final PlayerModel model;
	
	private final JPanel panel;
	private final JTextField nameField;
	private final ColoredPanelWithButtons scorePanel;
	private final ColoredPanelWithButtons advantagePanel;
	private final ColoredPanelWithButtons penaltyPanel;
	
	
	public ConsolePlayerPanel(final PlayerModel model) {
		this.model = model;
		model.addModelListener(this);
		
		double [][] tableLayoutCodes = {{5,F,5},{5,P,5,F,5,P,5,P,5}};
		
		panel = new JPanel(new TableLayout(tableLayoutCodes));
		
		nameField = new JTextField(model.getName());
		nameField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setName(nameField.getText());
			}
		});
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				model.setName(nameField.getText());
			}
		});
		panel.add(nameField, "1,1,f,f");
		
		scorePanel = new ColoredPanelWithButtons("Points", 
				POINT_PANEL_BG, 
				Color.white, 
				model.getDecScoreChar(), 
				model.getIncScoreChar());
		scorePanel.getDecrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setScore(model.getScore() - 1);
			}
		});
		scorePanel.getIncrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setScore(model.getScore() + 1);
			}
		});
		panel.add(scorePanel, "1,3");
		
		advantagePanel = new ColoredPanelWithButtons("Advantages", 
				ADV_PANEL_BG, 
				Color.white, 
				model.getDecAdvChar(), 
				model.getIncAdvChar());
		advantagePanel.getDecrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setAdvantages(model.getAdvantages() - 1);
			}
		});
		advantagePanel.getIncrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setAdvantages(model.getAdvantages() + 1);
			}
		});
		panel.add(advantagePanel, "1,5");
		
		penaltyPanel = new ColoredPanelWithButtons("Penalties", 
				PEN_PANEL_BG, 
				Color.white, 
				model.getDecPenChar(), 
				model.getIncPenChar());
		penaltyPanel.getDecrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setPenalties(model.getPenalties() - 1);
			}
		});
		penaltyPanel.getIncrementButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setPenalties(model.getPenalties() + 1);
			}
		});
		panel.add(penaltyPanel, "1,7");

	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}

	@Override
	public void updateFromModel() {
		nameField.setText(model.getName());
		scorePanel.setNumber(model.getScore());
		advantagePanel.setNumber(model.getAdvantages());
		penaltyPanel.setNumber(model.getPenalties());
	}
	
	@SuppressWarnings("serial")
	private class ColoredPanelWithButtons extends JPanel {
		private final JLabel descriptionLabel;
		private final JLabel numberLabel;
		private final JButton decrementButton;
		private final JButton incrementButton;
		
		public ColoredPanelWithButtons(String description, 
				Color bgColor, Color textColor, char decrementKey, char incrementKey) {
			
			super();
			double[][] layoutCodes = {{P,F,P},{F,P}};
			setLayout(new TableLayout(layoutCodes));
			
			decrementKey = Character.toUpperCase(decrementKey);
			incrementKey = Character.toUpperCase(incrementKey);
			
			decrementButton = new JButton("<- " + decrementKey);
			decrementButton.setFocusable(false);
			add(decrementButton, "0,0");
			
			numberLabel = new JLabel("0");
			numberLabel.setForeground(textColor);
			add(numberLabel, "1,0");
			
			incrementButton = new JButton(incrementKey + " ->");
			incrementButton.setFocusable(false);
			add(incrementButton, "2,0");
			
			descriptionLabel = new JLabel(description);
			descriptionLabel.setForeground(textColor);
			add(descriptionLabel, "0,1,2,1");
			
			setBackground(bgColor);
		}
		
		public JButton getDecrementButton() {
			return decrementButton;
		}
		
		public JButton getIncrementButton() {
			return incrementButton;
		}
		
		public void setNumber(int num) {
			numberLabel.setText("" + num);
		}
	}

}
