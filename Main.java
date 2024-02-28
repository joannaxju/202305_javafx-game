import javafx.application.Application;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.Priority;
// import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.scene.transform.Rotate;
// import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class Main extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
		
	public void start(Stage primaryStage){
		primaryStage.setTitle("Survival of the Digletts");
		
		Scoreboard scoreboard = new Scoreboard();
			
		Pane center = new Pane();
			
			Player p1 = new Player(Color.LIGHTBLUE);
			Player p2 = new Player(Color.LIGHTPINK);
			Apple a = new Apple();
			Bomb b = new Bomb();
			
			
			center.getChildren().addAll(p1,p2,a,b);
		
		BorderPane border = new BorderPane();
			border.setTop(scoreboard);
			border.setCenter(center);	
		
		//SceneAndStage--------------------------------------------------------------------------------------
			Scene scene = new Scene(border, 800, 650);
			primaryStage.setScene(scene);
		    primaryStage.show();
				
		double rightWall = border.getBoundsInParent().getMaxX();
		double bottomWall = border.getBoundsInParent().getMaxY() - scoreboard.getHeight();		
		
		//DiglettAndApple--------------------------------------------------------------------------------------
		p1.setTranslateX((rightWall/4)-35);
		p2.setTranslateX(((rightWall*3)/4)-35);
		a.setTranslateX(rightWall/2);
		p1.setTranslateY((bottomWall/2)-35);
		p2.setTranslateY((bottomWall/2)-35);
		a.setTranslateY(bottomWall/2);

		Bounds p1Bounds = p1.getBoundsInParent();
		Bounds p2Bounds = p2.getBoundsInParent();
		Bounds appleB = a.getBoundsInParent();
			
		ArrayList<KeyCode> keys = new ArrayList<KeyCode>();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){ 
			@Override
			public void handle(KeyEvent event){
				if(event.getCode()==KeyCode.UP && keys.indexOf(KeyCode.UP)==-1)
					keys.add(KeyCode.UP);
				else if(event.getCode()==KeyCode.DOWN && keys.indexOf(KeyCode.DOWN)==-1)
					keys.add(KeyCode.DOWN);
				else if(event.getCode()==KeyCode.RIGHT && keys.indexOf(KeyCode.RIGHT)==-1)
					keys.add(KeyCode.RIGHT);
				else if(event.getCode()==KeyCode.LEFT && keys.indexOf(KeyCode.LEFT)==-1)
					keys.add(KeyCode.LEFT);
				else if(event.getCode()==KeyCode.W && keys.indexOf(KeyCode.W)==-1)
					keys.add(KeyCode.W);
				else if(event.getCode()==KeyCode.S && keys.indexOf(KeyCode.S)==-1)
					keys.add(KeyCode.S);
				else if(event.getCode()==KeyCode.A && keys.indexOf(KeyCode.A)==-1)
					keys.add(KeyCode.A);
				else if(event.getCode()==KeyCode.D && keys.indexOf(KeyCode.D)==-1)
					keys.add(KeyCode.D);
			}
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>(){ 
			@Override
			public void handle(KeyEvent event){
				for(int i = 0; i<keys.size();i++){
					if(event.getCode()==KeyCode.UP && KeyCode.UP == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.DOWN && KeyCode.DOWN == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.RIGHT && KeyCode.RIGHT == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.LEFT && KeyCode.LEFT == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.W && KeyCode.W == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.S && KeyCode.S == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.A && KeyCode.A == keys.get(i))
						keys.remove(i);
					else if(event.getCode()==KeyCode.D && KeyCode.D == keys.get(i))
						keys.remove(i);
				}
			}
		});
		
		
		Label winner = new Label("WINNER!!!");
		Insets ins = new Insets(10);
		BackgroundFill redFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
		Font f1 = Font.font("Comic Sans", 40);

		winner.setBackground(new Background(redFill));
		winner.setTextFill(Color.WHITE);
		winner.setFont(f1);			
		winner.setPadding(ins);
		winner.setAlignment(Pos.CENTER);
		winner.setMaxWidth(Double.MAX_VALUE);
		
		
		AnimationTimer ani = new AnimationTimer(){
		
			@Override
			public  void handle(long now){
				int check = scoreboard.endGame();
				
				if(check==0){
					Bounds bombBounds = b.getBoundsInParent();
				
					double oldX = b.getTranslateX();
				
					b.setTranslateX(oldX+b.getXSpeed());
					
					double oldY = b.getTranslateY();
				
					b.setTranslateY(oldY-b.getYSpeed());
				
					if(oldX + bombBounds.getWidth()>rightWall || oldX<=0){
						b.setTranslateX(oldX - b.getXSpeed());
						b.setXSpeed(-1 * b.getXSpeed());
					}
				
					if(oldY + bombBounds.getHeight()>bottomWall || oldY<=0){
						b.setTranslateY(oldY + b.getYSpeed());
						b.setYSpeed(-1 * b.getYSpeed());
					}
				for(KeyCode k:keys){
					if(p1.getTranslateX() + p1Bounds.getWidth()<rightWall){
						if(k==KeyCode.D)
							p1.setTranslateX(p1.getTranslateX()+p1.getXSpeed());
					}
					if(p2.getTranslateX() + p2Bounds.getWidth()<rightWall){
						if(k==KeyCode.RIGHT)
							p2.setTranslateX(p2.getTranslateX()+p2.getXSpeed());
					}
					if(p1.getTranslateX( )> 0){
						if(k==KeyCode.A)
							p1.setTranslateX(p1.getTranslateX()-p1.getXSpeed());
					}
					if(p2.getTranslateX()>0){
						if(k==KeyCode.LEFT)
							p2.setTranslateX(p2.getTranslateX()-p2.getXSpeed());
					}
					if(p1.getTranslateY() + p1Bounds.getHeight()<bottomWall){
						if(k==KeyCode.S)
							p1.setTranslateY(p1.getTranslateY()+p1.getYSpeed());
					}
					if(p2.getTranslateY() + p2Bounds.getHeight()<bottomWall){
						if(k==KeyCode.DOWN)
							p2.setTranslateY(p2.getTranslateY()+p2.getYSpeed());
					}
					if(p1.getTranslateY()>0){
						if(k==KeyCode.W)
							p1.setTranslateY(p1.getTranslateY()-p1.getYSpeed());
					}
					if(p2.getTranslateY( )> 0){
						if(k==KeyCode.UP)
							p2.setTranslateY(p2.getTranslateY()-p2.getYSpeed());
					}
					
					if((p1.getTranslateX()+p1Bounds.getWidth())>a.getTranslateX() &&
					(p1.getTranslateY()+p1Bounds.getHeight())>a.getTranslateY()&&
					(a.getTranslateX()+appleB.getWidth())>p1.getTranslateX()&&
					(a.getTranslateY()+appleB.getHeight())>p1.getTranslateY()){
						scoreboard.changeScore(1);
						int randomX = (int)(Math.random()*rightWall);
						int randomY = (int)(Math.random()*bottomWall);
						a.setTranslateX(randomX);
						a.setTranslateY(randomY);
					}
					else if((p2.getTranslateX()+p2Bounds.getWidth())>a.getTranslateX() &&
					(p2.getTranslateY()+p2Bounds.getHeight())>a.getTranslateY()&&
					(a.getTranslateX()+appleB.getWidth())>p2.getTranslateX()&&
					(a.getTranslateY()+appleB.getHeight())>p2.getTranslateY()){
						scoreboard.changeScore(2);
						int randomX = (int)(Math.random()*rightWall);
						int randomY = (int)(Math.random()*bottomWall);
						a.setTranslateX(randomX);
						a.setTranslateY(randomY);
					}
					
					if((p1.getTranslateX()+p1Bounds.getWidth())>b.getTranslateX() &&
					(p1.getTranslateY()+p1Bounds.getHeight())>b.getTranslateY()&&
					(b.getTranslateX()+bombBounds.getWidth())>p1.getTranslateX()&&
					(b.getTranslateY()+bombBounds.getHeight())>p1.getTranslateY()){
						scoreboard.changeScore(3);
					}
					else if((p2.getTranslateX()+p2Bounds.getWidth())>b.getTranslateX() &&
					(p2.getTranslateY()+p2Bounds.getHeight())>b.getTranslateY()&&
					(b.getTranslateX()+bombBounds.getWidth())>p2.getTranslateX()&&
					(b.getTranslateY()+bombBounds.getHeight())>p2.getTranslateY()){
						scoreboard.changeScore(4);
					}
					
					
				}
				}
			}
		};
		
		ani.start();
		
	
		
	
	}
		
	
}