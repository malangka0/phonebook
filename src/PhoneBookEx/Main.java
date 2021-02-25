package PhoneBookEx;

import java.awt.Container;

import javax.swing.JFrame;

public class Main extends JFrame{

	public  Main() {
		
		Container con = new Container();
	
		phoneBook pb = new phoneBook();
		//pb.display(con);
		
	
	}
	
	public static void main(String[] args) {
		new Main();
			
	}

}
