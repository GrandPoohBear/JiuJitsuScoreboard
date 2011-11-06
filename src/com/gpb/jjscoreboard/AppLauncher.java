package com.gpb.jjscoreboard;

import javax.swing.JFrame;

import com.gpb.jjscoreboard.controller.ClockController;
import com.gpb.jjscoreboard.controller.KeyListenerController;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.view.ConsoleMatchPanel;
import com.gpb.jjscoreboard.view.DisplayMatchPanel;

public class AppLauncher {

	private final MatchModel matchModel;
	
	public AppLauncher() {
		matchModel = new MatchModel();
		
		KeyListenerController keyListenerController = new KeyListenerController(matchModel);
		@SuppressWarnings("unused")
		ClockController clockController = new ClockController(matchModel);
		
		JFrame displayFrame = new JFrame("Jiu Jitsu Scoreboard");
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.addKeyListener(keyListenerController);
		displayFrame.getContentPane().add(new DisplayMatchPanel(matchModel).getDisplayComponent());
		displayFrame.pack();
		displayFrame.setVisible(true);
		
		JFrame consoleFrame = new JFrame("Jiu Jitsu Scoreboard Console");
		consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consoleFrame.addKeyListener(keyListenerController);
		ConsoleMatchPanel consoleMatchPanel = new ConsoleMatchPanel(matchModel);
		consoleMatchPanel.getDisplayComponent().addKeyListener(keyListenerController);
		consoleFrame.getContentPane().add(consoleMatchPanel.getDisplayComponent());
		consoleFrame.pack();
		consoleFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppLauncher();
	}

}
