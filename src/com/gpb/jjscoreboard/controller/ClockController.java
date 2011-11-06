package com.gpb.jjscoreboard.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.gpb.jjscoreboard.model.MatchModel;

public class ClockController {
	private final Timer timer;
	private final MatchModel model;
	
	public ClockController(MatchModel model) {
		this.model = model;
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClockController.this.model.tickClock();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}
}
