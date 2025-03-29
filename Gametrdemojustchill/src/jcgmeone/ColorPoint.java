package jcgmeone;

import java.awt.Color;

public class ColorPoint {
	private Color color;
	private int x, y;
	public ColorPoint(Color color, int x, int y) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	


}
