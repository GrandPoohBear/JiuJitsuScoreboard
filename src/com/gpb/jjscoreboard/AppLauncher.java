package com.gpb.jjscoreboard;

import javax.swing.JFrame;

import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.view.ConsoleMatchPanel;
import com.gpb.jjscoreboard.view.DisplayMatchPanel;

public class AppLauncher {

	private final MatchModel matchModel;
	
	public AppLauncher() {
		matchModel = new MatchModel();
		
		JFrame displayFrame = new JFrame("Jiu Jitsu Scoreboard");
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayFrame.getContentPane().add(new DisplayMatchPanel(matchModel).getDisplayComponent());
		displayFrame.pack();
		displayFrame.setVisible(true);
		
		JFrame consoleFrame = new JFrame("Jiu Jitsu Scoreboard Console");
		
		consoleFrame.getContentPane().add(new ConsoleMatchPanel(matchModel).getDisplayComponent());
		consoleFrame.pack();
		consoleFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppLauncher();
	}

}
