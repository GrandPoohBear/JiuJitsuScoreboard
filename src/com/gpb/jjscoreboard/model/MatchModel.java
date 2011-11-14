package com.gpb.jjscoreboard.model;

import com.gpb.jjscoreboard.JJSConstants;

public class MatchModel extends BroadcastingModel implements JJSConstants {
	
	// critical time at 30 seconds
	private static final long CRITICAL_TIME_THRESHOLD = 30 * 1000;
	
	private long millisRemaining;
	private long lastClockUpdateMillis;
	private boolean clockRunning;
	private boolean buzzPending;
	private int lastClockMinutes;
	private final PlayerModel leftPlayer;
	private final PlayerModel rightPlayer;
	
	public MatchModel() {
		leftPlayer = new PlayerModel("Red", Side.LEFT);
		rightPlayer = new PlayerModel("Green", Side.RIGHT);
		lastClockMinutes = STARTING_CLOCK_MINUTES;
		resetMatch();
	}

	public void resetMatch() {
		setClockByMinutes(lastClockMinutes);
		clockRunning = false;
		buzzPending = false;
		leftPlayer.resetPlayer();
		rightPlayer.resetPlayer();
		broadcastModelChange();
	}

	public void setClockByMinutes(int minutes) {
		millisRemaining = minutes * 60 * 1000;
		lastClockMinutes = minutes;
		broadcastModelChange();
	}
	
	public String getTimeDisplayString() {
		int minutes = (int)(millisRemaining / (1000 * 60));
		int seconds = (int)((millisRemaining / 1000) % 60);
		
		String colon = ":";
		if (millisRemaining % 1000 < 500 && clockRunning)
			colon = " ";
		
		return String.format("%d%s%02d", minutes, colon, seconds);
	}

	public long getMillisRemaining() {
		return millisRemaining;
	}

	public void setMillisRemaining(long millisRemaining) {
		if (this.millisRemaining >= 0 && millisRemaining <= 0) {
			millisRemaining = 0;
			if (clockRunning) {
				buzzPending = true;
				clockRunning = false;
			}
		}
		
		this.millisRemaining = millisRemaining;
		broadcastModelChange();
	}

	public boolean isClockRunning() {
		return clockRunning;
	}

	public void setClockRunning(boolean clockRunning) {
		this.clockRunning = clockRunning;
		lastClockUpdateMillis = System.currentTimeMillis();
		broadcastModelChange();
	}
	
	public void tickClock() {
		if (clockRunning) {
			long curMillis = System.currentTimeMillis();
			long delta = curMillis - lastClockUpdateMillis;
			long newTimeValue = millisRemaining - delta;
			
			if (newTimeValue <= 0) {
				newTimeValue = 0;
				buzzPending = true;
				clockRunning = false;
			}
			
			setMillisRemaining(newTimeValue);
			lastClockUpdateMillis = curMillis;
			
		}
	}

	public PlayerModel getLeftPlayer() {
		return leftPlayer;
	}

	public PlayerModel getRightPlayer() {
		return rightPlayer;
	}
	
	public boolean isCriticalTime() {
		return millisRemaining <= CRITICAL_TIME_THRESHOLD;
	}
	
	public boolean isBuzzPending() {
		return buzzPending;
	}
	
	public void clearBuzzPending() {
		buzzPending = false;
	}
	
	public void addTimeIncrement() {
		setMillisRemaining(getMillisRemaining() + TIME_ADJUSTMENT_AMOUNT);
	}
	
	public void subtractTimeIncrement() {
		setMillisRemaining(getMillisRemaining() - TIME_ADJUSTMENT_AMOUNT);
	}
	
}
