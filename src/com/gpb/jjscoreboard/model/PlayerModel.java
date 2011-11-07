package com.gpb.jjscoreboard.model;

import com.gpb.jjscoreboard.JJSConstants;

public class PlayerModel extends BroadcastingModel implements JJSConstants {
	private int score;
	private int advantages;
	private int penalties;
	private String name;
	private final Side side;
	
	public PlayerModel(String name, Side side) {
		this.name = name;
		this.side = side;
		resetPlayer();
	}

	public void resetPlayer() {
		score = advantages = penalties = 0;
		broadcastModelChange();
	}
	
	public char getIncScoreChar() {
		return INC_SCORE_CHAR[side.idx()];
	}
	
	public char getDecScoreChar() {
		return DEC_SCORE_CHAR[side.idx()];
	}
	
	public char getIncAdvChar() {
		return INC_ADV_CHAR[side.idx()];
	}
	
	public char getDecAdvChar() {
		return DEC_ADV_CHAR[side.idx()];
	}
	public char getIncPenChar() {
		return INC_PEN_CHAR[side.idx()];
	}
	
	public char getDecPenChar() {
		return DEC_PEN_CHAR[side.idx()];
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = Math.max(score, 0);
		broadcastModelChange();
	}
	
	public int getAdvantages() {
		return advantages;
	}
	
	public void setAdvantages(int advantages) {
		this.advantages = Math.max(advantages, 0);
		broadcastModelChange();
	}
	
	public int getPenalties() {
		return penalties;
	}
	
	public void setPenalties(int penalties) {
		this.penalties = Math.max(penalties, 0);
		broadcastModelChange();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		broadcastModelChange();
	}
}
