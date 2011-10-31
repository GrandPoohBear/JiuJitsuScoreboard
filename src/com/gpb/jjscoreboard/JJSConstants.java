package com.gpb.jjscoreboard;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

public interface JJSConstants {
	public static final double F = TableLayout.FILL;
	public static final double P = TableLayout.PREFERRED;
	
	//First member is for left player, second for right player
	public static final char[] DEC_SCORE_CHAR = {'q','o'};
	public static final char[] INC_SCORE_CHAR = {'w','p'};
	public static final char[] DEC_ADV_CHAR = {'a','k'};
	public static final char[] INC_ADV_CHAR = {'s','l'};
	public static final char[] DEC_PEN_CHAR = {'z','n'};
	public static final char[] INC_PEN_CHAR = {'x','m'};
	
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
	
	public static final Color POINT_PANEL_BG = Color.blue.darker();
	public static final Color ADV_PANEL_BG = Color.green.darker();
	public static final Color PEN_PANEL_BG = Color.red.darker();
	
}
