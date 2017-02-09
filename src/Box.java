import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Box {
	PVector pos;//Position
	float size;
	PApplet p;

	public Box(PApplet p, float x, float y, float z, float r) {
		pos = new PVector(x, y, z);
		this.size = r;
		this.p = p;
	}

	public ArrayList<Box> generate() {
		ArrayList<Box> newBoxes = new ArrayList<Box>();
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				for (int z = -1; z < 2; z++) {
					int sum = p.abs(x) + p.abs(y) + p.abs(z);
					float newSize = size / 3;
					if (sum > 1) {
						Box b = new Box(p, pos.x + x * newSize, pos.y + y * newSize, pos.z + z * newSize, newSize);
						newBoxes.add(b);
					}
				}
			}
		}
		return newBoxes;
	}

	public void show() {
		p.pushMatrix();
		p.translate(pos.x, pos.y, pos.z);
		p.noStroke();
		p.fill(255);
		p.box(size);
		p.popMatrix();

	}

}
