//import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
//import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Apple extends StackPane{
	
	//Fields--------------------------------------------------------------------------------------
	ArrayList<Shape> apple = new ArrayList<Shape>();
	private int xloc;
	private int yloc;
	
	//Constructor--------------------------------------------------------------------------------------
	public Apple(){
		
		Circle body = new Circle(15);
			body.setFill(Color.rgb(250,42,90));
			body.setStrokeWidth(2);
			body.setStroke(Color.BLACK);
		
		Rectangle stem = new Rectangle(3.5,10);
			stem.setFill(Color.rgb(150, 85, 64));
			stem.setTranslateY(-17);
			stem.setStrokeWidth(1.5);
			stem.setStroke(Color.BLACK);		
		
		Ellipse leaf = new Ellipse(2.5,8.5);
			leaf.setFill(Color.rgb(148,185,54));
			leaf.setTranslateY(-18);
			leaf.setTranslateX(7.5);
			leaf.setStrokeWidth(1.5);
			leaf.setStroke(Color.BLACK);
			leaf.setRotate(50);
		
		apple.add(body);
		apple.add(leaf);
		apple.add(stem);	
		this.getChildren().addAll(apple);	
	}

	//GettersSetters--------------------------------------------------------------------------------------
	public int getXloc(){return xloc;}
	public int getYloc(){return yloc;}

	
	public void setXloc(int x){xloc = x;}
	public void setYloc(int y){yloc = y;}
	
	//Methods--------------------------------------------------------------------------------------
	
}