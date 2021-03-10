import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Server extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;

	//constructor to set simple GUI

	public Server(){
		super("Instant Messenger");
		userText=new JTextField();
		userText.setEditable(false);// preventing user to type anything before recieving message
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){ //this function will be callled whenever we hit enter
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText,BorderLayout.NORTH);
		chatWindow=new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(400,400);
		setVisible(true);
	}

	//set up and run the server

	public void startRunning(){
		try{
			server=new ServerSocket(6789,100);//port number and backlog(how many people can wait in queue)
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch(EOFException e){
					showMessage("\n Server ended Connection! ");	
				}
				finally{
					closeCrap();
				}
			}


		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//wait for connection,then display connection info

	private void waitForConnection() throws IOException{
		showMessage("Waiting for connection...\n");
		connection=server.accept();//only create connection when it is really connected to someone
		showMessage("Now connected to"+connection.getInetAddress().getHostName());
	}

	//get streams to send and recieve data

	private void setupStreams() throws IOException{
		output=new ObjectOutputStream(connection.getOutputStream());//send data out
		output.flush();  
		input=new ObjectInputStream(connection.getInputStream());//recieve data in
		showMessage("\n Streams are now setup!\n");
	}

	//chatting 

	private void whileChatting() throws IOException{
		String message=" You r now connected! ";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message=(String)input.readObject();
				showMessage("\n"+message);
			}catch(ClassNotFoundException e){
				showMessage("\n what crap it is\n");
			}

		}while(!message.equals("CLIENT - END"));
	}

	//close streams and sockets
	private void closeCrap(){
		showMessage("\n closing connections...!\n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	// send messge to client
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER - "+message);//write data to data to the client
			output.flush();
			showMessage("\n SERVER - "+message);//print message on our screen
		}catch(IOException e){
			chatWindow.append("\n ERROR... cant send message!");
		}
	}

	//updates chat window

	private void showMessage(final String text){
		SwingUtilities.invokeLater(    // it is a utility to make the thread run 
			new Runnable(){  //it is thread to update the chat window
				public void run(){
					chatWindow.append(text);
				}
			}
		);
	}

	//let the user type stuff into their box
	private void ableToType(final boolean flag){
		SwingUtilities.invokeLater(    // it is a utility to make the thread run 
			new Runnable(){  //it is thread to update the chat window
				public void run(){
					chatWindow.setEditable(flag);
				}
			}
		);
	}
}


public class server_main{
	public static void main(String[] arg){
		Server obj=new Server();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		obj.startRunning();
	}
}