package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.ModelListener;

public class DisplayMatchPanel implements ModelListener {
	private final MatchModel model;
	
	private final JPanel panel;
	private final JLabel timerLabel;
	private final DisplayPlayerPanel leftPlayer;
	private final DisplayPlayerPanel rightPlayer;
	//private final JLabel logoPanel;
	
	private static final double f = TableLayout.FILL;
	private static final double p = TableLayout.PREFERRED;
	
	public DisplayMatchPanel(MatchModel model) {
		this.model = model;
		
		double [][] tableLayoutSetup = {{10,f,10,p,10,f,10},{10,p,10,f,10}};
		panel = new JPanel(new TableLayout(tableLayoutSetup));
		
		timerLabel = new JLabel("0:00");
		panel.add(timerLabel, "3,1,c,c");
		
		leftPlayer = new DisplayPlayerPanel(model.getLeftPlayer());
		panel.add(leftPlayer.getDisplayComponent(), "1,3");
		
		rightPlayer = new DisplayPlayerPanel(model.getRightPlayer());
		panel.add(rightPlayer.getDisplayComponent(), "5,3");
		
	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}
	
	@Override
	public void updateFromModel() {
		long millis = model.getMillisRemaining();
		
		int minutes = (int)(millis / (1000 * 60));
		int seconds = (int)((millis / 1000) % 60);
		
		timerLabel.setText("" + minutes + ":" + seconds);
	}

}
