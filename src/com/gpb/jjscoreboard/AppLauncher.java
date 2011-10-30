package com.gpb.jjscoreboard;

import javax.swing.JFrame;

import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.view.DisplayMatchPanel;

public class AppLauncher {

	private final MatchModel matchModel;
	
	public AppLauncher() {
		matchModel = new MatchModel();
		
		JFrame frame = new JFrame("Jiu Jitsu Scoreboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new DisplayMatchPanel(matchModel).getDisplayComponent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppLauncher();
	}

}
