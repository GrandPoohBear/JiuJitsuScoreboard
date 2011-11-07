package com.gpb.jjscoreboard;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

public interface JJSConstants {
	public static final double F = TableLayout.FILL;
	public static final double P = TableLayout.PREFERRED;
	
	//Key bindings for player specific commands
	//First member is for left player, second for right player
	public static final char[] DEC_SCORE_CHAR = {'q','o'};
	public static final char[] INC_SCORE_CHAR = {'w','p'};
	public static final char[] DEC_ADV_CHAR = {'a','k'};
	public static final char[] INC_ADV_CHAR = {'s','l'};
	public static final char[] DEC_PEN_CHAR = {'z','n'};
	public static final char[] INC_PEN_CHAR = {'x','m'};
	
	//Overall key bindings
	public static final char START_STOP_TIME_CHAR = ' ';
	public static final char RESET_MATCH_CHAR = 'r';
	public static final char ADD_TIME1 = '+';
	public static final char ADD_TIME2 = '=';
	public static final char SUB_TIME1 = '-';
	public static final char SUB_TIME2 = '_';
	public static final char [] TIME_SET_SHORTCUTS = 
		{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	
	// Amount to adjust when using the add/sub keys specified above.
	public static final int TIME_ADJUSTMENT_AMOUNT = 10 * 1000;
	
	public static enum Side {
		LEFT(0), RIGHT(1);
		
		private int index;
		private Side(int index) {
			this.index = index;
		}
		public int idx() {
			return index;
		}
		
	}
	
	public static final Color POINT_PANEL_BG = Color.blue.darker().darker();
	public static final Color ADV_PANEL_BG = Color.green.darker().darker();
	public static final Color PEN_PANEL_BG = Color.red.darker().darker();
	
	public static final String BUZZ_RESOURCE_PATH = "/buzzer.wav";
	
	public static final int STARTING_CLOCK_MINUTES = 1;
	
}
