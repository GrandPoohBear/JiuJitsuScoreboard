package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.ModelListener;

public class ConsoleAdminPanel implements ModelListener, JJSConstants {
	private final MatchModel model;
	private final JPanel panel;
	
	private final JPanel matchOptionsPanel;
	private final JButton resetMatchButton;
	private final JButton addTimeButton;
	private final JButton subtractTimeButton;
	private final JPanel timePresetPanel;
	private final JButton[] timeButtons;

	public ConsoleAdminPanel(MatchModel model) {
		this.model = model;
		this.model.addModelListener(this);
		
		double[][] layoutCodes = {{P},{P,P}};
		panel = new JPanel(new TableLayout(layoutCodes));
		
		matchOptionsPanel = new JPanel(new FlowLayout());
		matchOptionsPanel.setBorder(new TitledBorder("Match Options"));
		
		resetMatchButton = new JButton(
				"Reset Match (" + Character.toUpperCase(RESET_MATCH_CHAR) + ")");
		resetMatchButton.setFocusable(false);
		resetMatchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConsoleAdminPanel.this.model.resetMatch();	
			}
		});
		matchOptionsPanel.add(resetMatchButton);
		
		addTimeButton = new JButton(
				"Add Time (" + Character.toUpperCase(ADD_TIME1) + ")");
		addTimeButton.setFocusable(false);
		addTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsoleAdminPanel.this.model.addTimeIncrement();
			}
		});
		matchOptionsPanel.add(addTimeButton);
		
		subtractTimeButton = new JButton(
				"Subtract Time (" + Character.toUpperCase(SUB_TIME1) + ")");
		subtractTimeButton.setFocusable(false);
		subtractTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsoleAdminPanel.this.model.subtractTimeIncrement();
			}
		});
		matchOptionsPanel.add(subtractTimeButton);
		
		double[][] timePresetLayoutCodes = {{P,P,P,P,P},{P,P}};
		timePresetPanel = new JPanel(new TableLayout(timePresetLayoutCodes));
		timePresetPanel.setBorder(new TitledBorder("Time Presets (available when clock is stopped)"));
		
		timeButtons = new JButton[10];
		for (int i = 0; i < 10; i++) {
			char c = TIME_SET_SHORTCUTS[i];
			String label = (i+1) + "m (" + c + ")";
			
			final int timeAmount = i+1;
			timeButtons[i] = new JButton(label);
			timeButtons[i].setFocusable(false);
			timeButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ConsoleAdminPanel.this.model.setClockByMinutes(timeAmount);
				}
			});
			timePresetPanel.add(timeButtons[i], i%5 + "," + i/5);
		}
		
		panel.add(matchOptionsPanel, "0,0");
		panel.add(timePresetPanel, "0,1");
	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}


	@Override
	public void updateFromModel() {
		for (JButton button : timeButtons) {
			button.setEnabled(!model.isClockRunning());
		}
	}
}
