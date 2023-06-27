package appchat;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class User2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextArea txtChat;
	private static JTextArea textArea;
	private static Jedis jedis = new Jedis();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new User2().setVisible(true);
		Jedis jedis = new Jedis();
		JedisPubSub jedisPubSub = new JedisPubSub() {
		      @Override
		      public void onMessage(String channel, String message) {
		          // Handle received message
		          System.out.println("Received message: " + message);
		          textArea.append(message+"\n");
		          
		          
		      }
		  };
		  
		  // Subscribe to the "channel1" channel
		  jedis.subscribe(jedisPubSub, "topic");
		
	}

	/**
	 * Create the frame.
	 */
	public User2() {
		setTitle("May 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "N\u1ED9i dung xem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 940, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 21, 920, 369);
		panel.add(textArea);
		
		txtChat = new JTextArea();
		txtChat.setBounds(84, 412, 763, 56);
		contentPane.add(txtChat);
		
		JLabel lblNewLabel = new JLabel("Nhập text chat");
		lblNewLabel.setBounds(0, 412, 84, 56);
		contentPane.add(lblNewLabel);
		
		 btnNewButton = new JButton("Gửi");
		btnNewButton.setBounds(857, 412, 83, 56);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
	}
	public void send(String messeage) throws NamingException {
		
			jedis.publish("topic","May 2:"+ txtChat.getText());
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btnNewButton)) {
			try {
				send(txtChat.getText());
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}

