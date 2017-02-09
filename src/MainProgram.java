import java.util.ArrayList;

import processing.core.PApplet;

public class MainProgram extends PApplet {
	float rotation = 0;
	Box b = new Box(this, 0, 0, 0, 200);
	ArrayList<Box> sponge = new ArrayList<Box>();

	public static void main(String[] args) {
		PApplet.main("MainProgram");
	}
	
	public void settings(){
        size(400,400, P3D);
    }

    public void setup(){
    	sponge.add(b);
    }
    
    public void mousePressed(){
    	ArrayList<Box> newBoxes = new ArrayList<>();
    	for(Box b: sponge){
    		newBoxes.addAll(b.generate());
    	}
    	sponge = newBoxes;
    }

    public void draw(){
    	noFill();
    	background(51);
    	stroke(255);
    	lights();
    	translate(width/2, height/2);
    	rotateX(rotation);
    	rotateY(rotation);
    	rotateZ(rotation);
    	for(Box box: sponge){
    		box.show();
    	}
    	rotation += 0.01;
    }

}
