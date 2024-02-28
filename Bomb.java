// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.BackgroundFill;
// import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
// import javafx.scene.shape.Arc;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Ellipse;
// import javafx.scene.shape.Polygon;
// import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
// import javafx.scene.shape.Shape;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.scene.transform.Rotate;
// import javafx.scene.transform.Translate;

// import java.util.ArrayList;

public class Bomb extends StackPane{
	
	//FIELD--------------------------------------------------------------------------------------
	private double height;
	private double width;
	private int xSpeed = 2;
	private int ySpeed = 2;
	
	private Color borderColor;
	private Color spriteColor;
	
	public Bomb(){
		height = 40;
		width = 40;
		borderColor = Color.BLACK;
		spriteColor = Color.RED;
		Rectangle box = new Rectangle(width,height,spriteColor);
			box.setStrokeWidth(1);
			box.setStroke(borderColor);
			this.setTranslateX(200);
			this.setTranslateY(150);
			
		this.getChildren().add(box);
	}
	
	//Getters Setters--------------------------------------------------------------------------------------
	public int getXSpeed(){return xSpeed;}
	public int getYSpeed(){return ySpeed;}

	public void setXSpeed(int x){xSpeed = x;}
	public void setYSpeed(int y){ySpeed = y;}

}