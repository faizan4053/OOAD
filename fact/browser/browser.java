import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

 class readfile extends JFrame{

	private JTextField addressBar;
	private JEditorPane display;

	public readfile(){
		super("Simple Browser");

		addressBar=new JTextField("Eneter the URL");

		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						loadCrap(event.getActionCommand());
					}
				}

			);
		add(addressBar,BorderLayout.NORTH);

		display=new JEditorPane();

		display.setEditable(false);

		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadCrap(event.getURL().toString());
						}
					}
				}
			);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}

	//load crap 
	private void loadCrap(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}
		catch(Exception e){
			System.out.println("OOPS!");
		}
	}
}

public class browser{
	public static void main(String[] arg){
			readfile obj=new readfile();
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}