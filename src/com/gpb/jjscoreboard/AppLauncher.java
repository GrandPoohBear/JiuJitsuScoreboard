package com.gpb.jjscoreboard;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.gpb.jjscoreboard.controller.ClockController;
import com.gpb.jjscoreboard.controller.KeyListenerController;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.view.Buzzer;
import com.gpb.jjscoreboard.view.ConsoleMatchPanel;
import com.gpb.jjscoreboard.view.DisplayMatchPanel;

public class AppLauncher {

	private final MatchModel matchModel;
	
	public AppLauncher() {
		matchModel = new MatchModel();
		
		KeyListenerController keyListenerController = new KeyListenerController(matchModel);
		
		@SuppressWarnings("unused")
		ClockController clockController = new ClockController(matchModel);
		
		//If the buzzer is successfully created, it will add itself as a model listener
		try {
			@SuppressWarnings("unused")
			Buzzer buzzer = new Buzzer(matchModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFrame displayFrame = new JFrame("Jiu Jitsu Scoreboard");
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.addKeyListener(keyListenerController);
		displayFrame.getContentPane().add(new DisplayMatchPanel(matchModel).getDisplayComponent());
		displayFrame.pack();
		displayFrame.setVisible(true);
		displayFrame.setMinimumSize(new Dimension(800,625));
		
		JFrame consoleFrame = new JFrame("Jiu Jitsu Scoreboard Console");
		consoleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consoleFrame.addKeyListener(keyListenerController);
		ConsoleMatchPanel consoleMatchPanel = new ConsoleMatchPanel(matchModel);
		consoleMatchPanel.getDisplayComponent().addKeyListener(keyListenerController);
		consoleFrame.getContentPane().add(consoleMatchPanel.getDisplayComponent());
		consoleFrame.pack();
		consoleFrame.setVisible(true);
		consoleFrame.setLocation(801, 0);
		consoleFrame.setResizable(false);
	}
	
	public static void main(String[] args) {
		new AppLauncher();
	}

}
