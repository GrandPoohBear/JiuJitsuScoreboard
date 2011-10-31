package com.gpb.jjscoreboard.model;

import java.awt.Color;

import com.gpb.jjscoreboard.JJSConstants;

public class MatchModel extends BroadcastingModel implements JJSConstants {
	private long millisRemaining;
	private boolean clockRunning;
	private int lastClockMinutes;
	private final PlayerModel leftPlayer;
	private final PlayerModel rightPlayer;
	
	public MatchModel() {
		leftPlayer = new PlayerModel("Red", Color.red, Side.LEFT);
		rightPlayer = new PlayerModel("Green", Color.green, Side.RIGHT);
		lastClockMinutes = 5;
		resetMatch();
	}

	public void resetMatch() {
		setClockByMinutes(lastClockMinutes);
		clockRunning = false;
	}

	private void setClockByMinutes(int minutes) {
		millisRemaining = minutes * 60 * 1000;
		lastClockMinutes = minutes;
	}
	
	public String getTimeDisplayString() {
		int minutes = (int)(millisRemaining / (1000 * 60));
		int seconds = (int)((millisRemaining / 1000) % 60);
		
		return "" + minutes + ":" + seconds;
	}

	public long getMillisRemaining() {
		return millisRemaining;
	}

	public void setMillisRemaining(long millisRemaining) {
		this.millisRemaining = millisRemaining;
	}

	public boolean isClockRunning() {
		return clockRunning;
	}

	public void setClockRunning(boolean clockRunning) {
		this.clockRunning = clockRunning;
	}

	public PlayerModel getLeftPlayer() {
		return leftPlayer;
	}

	public PlayerModel getRightPlayer() {
		return rightPlayer;
	}
	
}
