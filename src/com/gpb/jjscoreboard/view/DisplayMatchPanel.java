package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.ModelListener;

public class DisplayMatchPanel implements ModelListener, JJSConstants {
	private final MatchModel model;
	
	private final JPanel panel;
	private final JLabel timerLabel;
	private final DisplayPlayerPanel leftPlayer;
	private final DisplayPlayerPanel rightPlayer;
	//private final JLabel logoPanel;
	
	
	public DisplayMatchPanel(MatchModel model) {
		this.model = model;
		this.model.addModelListener(this);
		
		double [][] tableLayoutSetup = {{10,F,10,P,10,F,10},{10,P,10,F,10}};
		panel = new JPanel(new TableLayout(tableLayoutSetup));
		panel.setBackground(Color.black);
		panel.setPreferredSize(new Dimension(800,600));
		
		timerLabel = new JLabel(model.getTimeDisplayString());
		timerLabel.setForeground(Color.white);
		timerLabel.setFont(timerLabel.getFont().deriveFont(120.f));
		panel.add(timerLabel, "1,1,5,1,c,c");
		
		// Left player and right player are swapped for the monitor facing
		// the competitors
		leftPlayer = new DisplayPlayerPanel(model.getLeftPlayer());
		panel.add(leftPlayer.getDisplayComponent(), "5,3");
		
		rightPlayer = new DisplayPlayerPanel(model.getRightPlayer());
		panel.add(rightPlayer.getDisplayComponent(), "1,3");
		
	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}
	
	@Override
	public void updateFromModel() {	
		timerLabel.setText(model.getTimeDisplayString());
		timerLabel.setForeground(model.isCriticalTime() ? Color.RED : Color.WHITE);
	}

}
