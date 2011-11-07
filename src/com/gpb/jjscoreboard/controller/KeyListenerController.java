package com.gpb.jjscoreboard.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.PlayerModel;

public class KeyListenerController implements KeyListener, JJSConstants {
	
	private final MatchModel model;
	private final PlayerModel left;
	private final PlayerModel right;
	
	public KeyListenerController(MatchModel model) {
		this.model = model;
		left = model.getLeftPlayer();
		right = model.getRightPlayer();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// NOOP
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// NOOP
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		
		//Make sure we don't get thrown off by the shift key
		c = Character.toLowerCase(c);
		
		// Left
		if (c == left.getDecScoreChar()) {
			left.setScore(left.getScore() - 1);
		} else if (c == left.getIncScoreChar()) {
			left.setScore(left.getScore() + 1);
		} else if (c == left.getDecAdvChar()) {
			left.setAdvantages(left.getAdvantages() - 1);
		} else if (c == left.getIncAdvChar()) {
			left.setAdvantages(left.getAdvantages() + 1);
		} else if (c == left.getDecPenChar()) {
			left.setPenalties(left.getPenalties() - 1);
		} else if (c == left.getIncPenChar()) {
			left.setPenalties(left.getPenalties() + 1);
		}
		
		// Right
		else if (c == right.getDecScoreChar()) {
			right.setScore(right.getScore() - 1);
		} else if (c == right.getIncScoreChar()) {
			right.setScore(right.getScore() + 1);
		} else if (c == right.getDecAdvChar()) {
			right.setAdvantages(right.getAdvantages() - 1);
		} else if (c == right.getIncAdvChar()) {
			right.setAdvantages(right.getAdvantages() + 1);
		} else if (c == right.getDecPenChar()) {
			right.setPenalties(right.getPenalties() - 1);
		} else if (c == right.getIncPenChar()) {
			right.setPenalties(right.getPenalties() + 1);
		}
		
		// Matchwide
		else if (c == START_STOP_TIME_CHAR) {
			model.setClockRunning(!model.isClockRunning());
		} else if (c == RESET_MATCH_CHAR) {
			model.resetMatch();
		} else if (c == ADD_TIME1 || c == ADD_TIME2) {
			model.addTimeIncrement();
		} else if (c == SUB_TIME1 || c == SUB_TIME2) {
			model.subtractTimeIncrement();
		}
		
		// Time presets
		else if (c == TIME_SET_SHORTCUTS[0] && !model.isClockRunning()) {
			model.setClockByMinutes(1);
		} else if (c == TIME_SET_SHORTCUTS[1] && !model.isClockRunning()) {
			model.setClockByMinutes(2);
		} else if (c == TIME_SET_SHORTCUTS[2] && !model.isClockRunning()) {
			model.setClockByMinutes(3);
		} else if (c == TIME_SET_SHORTCUTS[3] && !model.isClockRunning()) {
			model.setClockByMinutes(4);
		} else if (c == TIME_SET_SHORTCUTS[4] && !model.isClockRunning()) {
			model.setClockByMinutes(5);
		} else if (c == TIME_SET_SHORTCUTS[5] && !model.isClockRunning()) {
			model.setClockByMinutes(6);
		} else if (c == TIME_SET_SHORTCUTS[6] && !model.isClockRunning()) {
			model.setClockByMinutes(7);
		} else if (c == TIME_SET_SHORTCUTS[7] && !model.isClockRunning()) {
			model.setClockByMinutes(8);
		} else if (c == TIME_SET_SHORTCUTS[8] && !model.isClockRunning()) {
			model.setClockByMinutes(9);
		} else if (c == TIME_SET_SHORTCUTS[9] && !model.isClockRunning()) {
			model.setClockByMinutes(10);
		} 
		
	}

}
