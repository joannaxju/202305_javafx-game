//import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
//import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Player extends StackPane{
	
	//FIELD--------------------------------------------------------------------------------------
	ArrayList<Shape> diglett = new ArrayList<Shape>();
	private int xSpeed = 4;
	private int ySpeed = 4;
	private int xloc;
	private int yloc;
	double scale = 0.3;
	
	public Player(Color c){
		
		Circle bodyCir = new Circle(87.5*scale);
			bodyCir.setFill(c);
			
		Ellipse rEye = new Ellipse(5.64*scale,21.87*scale);
			rEye.setFill(Color.rgb(20,17,13));
			rEye.setTranslateX(30.75*scale);
			rEye.setTranslateY(-40*scale);
			
		Ellipse lEye = new Ellipse(5.64*scale,21.87*scale);
			lEye.setFill(Color.rgb(20,17,13));
			lEye.setTranslateX(-30.75*scale);
			lEye.setTranslateY(-40*scale);
			
		Ellipse rEyeHighlight = new Ellipse(3.64*scale,6.29*scale);
			rEyeHighlight.setFill(Color.WHITE);
			rEyeHighlight.setTranslateX(30.75*scale);
			rEyeHighlight.setTranslateY((-40-3.51)*scale);
			
		Ellipse lEyeHighlight = new Ellipse(3.64*scale,6.29*scale);
			lEyeHighlight.setFill(Color.WHITE);
			lEyeHighlight.setTranslateX(-30.75*scale);
			lEyeHighlight.setTranslateY((-40-3.51)*scale);
			
		Ellipse nose = new Ellipse(31.16*scale,16.58*scale);
			nose.setFill(Color.rgb(227,108,115));
			nose.setStroke(Color.BLACK);
			nose.setStrokeWidth(1.75);
			
		Ellipse noseHighLight1 = new Ellipse((31.16/2)*scale,(16.58/2)*scale);
			noseHighLight1.setFill(Color.rgb(238, 167, 171));
			noseHighLight1.setTranslateX(-9.58*scale);
			
		Ellipse noseHighLight2 = new Ellipse((31.16/5)*scale,(16.58/5)*scale);
			noseHighLight2.setFill(Color.WHITE);
			noseHighLight2.setTranslateX(-13.58*scale);
		
		diglett.add(bodyCir);
		diglett.add(lEye);
		diglett.add(rEye);
		diglett.add(lEyeHighlight);
		diglett.add(rEyeHighlight);
		diglett.add(nose);
		diglett.add(noseHighLight1);
		diglett.add(noseHighLight2);	
		this.getChildren().addAll(diglett);
	}
	
	//GettersSetters--------------------------------------------------------------------------------------
	public int getXSpeed(){return xSpeed;}
	public int getYSpeed(){return ySpeed;}
	public int getXloc(){return xloc;}
	public int getYloc(){return yloc;}

	public void setXSpeed(int x){xSpeed = x;}
	public void setYSpeed(int y){ySpeed = y;}
	public void setXloc(int x){xloc = x;}
	public void setYloc(int y){yloc = y;}
	
}