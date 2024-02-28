// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
// import javafx.scene.control.Button;
// import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;

// import java.util.ArrayList;

public class Scoreboard extends HBox{
	
	//Fields--------------------------------------------------------------------------------------
	int p1score = 0;
	int p2score = 0;
	Label score = new Label("SCORE\nPlayer 1 (BLUE): "+p1score+"\nPlayer 2 (PINK): "+p2score);
	Insets ins = new Insets(10);
	Insets insMini = new Insets(5,7.5,5,7.5);
	BackgroundFill lightblueFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
	BackgroundFill lightpinkFill = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);
	Font f1 = Font.font("Comic Sans", 18);
	
	Label rules = new Label("Eat the apple to earn 1 point.\nIf you touch the red box, you lose a lot of points.\nFirst player to reach 10 points wins.");
	
	
	public Scoreboard(){
				
		this.setBackground(new Background(lightblueFill));
		this.setPadding(ins);
		
		score.setBackground(new Background(lightpinkFill));
		score.setTextFill(Color.BLUE);
		score.setFont(f1);			
		score.setPadding(insMini);
		score.setAlignment(Pos.CENTER);
		score.setMaxWidth(Double.MAX_VALUE);
		
		rules.setBackground(new Background(lightpinkFill));
		rules.setTextFill(Color.BLUE);
		rules.setFont(f1);			
		rules.setPadding(insMini);
		rules.setAlignment(Pos.CENTER);
		rules.setMaxWidth(Double.MAX_VALUE);
		
		
			
		// this.setMargin(score, new Insets(0,9,0,9));
		// this.setHgrow(score, Priority.ALWAYS);
		
		// this.setMargin(rules, new Insets(0,9,0,9));
		// this.setHgrow(rules, Priority.ALWAYS);
	
		this.getChildren().addAll(score,rules);
	}
	
	public int getP1() {return p1score;}
	public int getP2() {return p2score;}
	
	public void changeScore(int player){
		if(player==1){
			p1score++;
		}else if(player==2){
			p2score++;
		}else if(player==3){
			p1score--;
		}else if(player==4){
			p2score--;
		}
		score.setText("SCORE\nPlayer 1 (BLUE): "+p1score+"\nPlayer 2 (PINK): "+p2score);
		
	}
	
	public int endGame(){
		if(p1score==10){
			score.setText("WINNER: PLAYER 1");
			return 1;
		}
		else if(p2score==10){
			score.setText("WINNER: PLAYER 2");
			return 2;
		}
		return 0;
	}
		
}