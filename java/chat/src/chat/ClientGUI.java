package chat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ClientGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private static JPanel panel;
    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ClientGUI frame = new ClientGUI();
		    frame.setVisible(true);
		    String ip = "127.0.0.1";
		    int port = 1234;
		    String name = "May khach";
		    Socket socket = null;
		    socket = new Socket(ip, port);
			panel.removeAll();
			chatPanel chatPanel = new chatPanel(socket, name);
			panel.add(chatPanel);
			panel.updateUI();
			Thread t = new Thread(chatPanel);
			t.start();

		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public ClientGUI() {
	initComponents();
    }

    private void initComponents() {
	setTitle("CLIENT");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 822, 716);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.add(getPanel_1());

    }

    public JLabel getLblNewLabel() {
	if (lblNewLabel == null) {
	    lblNewLabel = new JLabel("Client-Chat");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
	    lblNewLabel.setBounds(23, 13, 131, 51);
	}
	return lblNewLabel;
    }

    public JPanel getPanel_1() {
	if (panel == null) {
	    panel = new JPanel();
	    panel.setBackground(Color.LIGHT_GRAY);
	    panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
	    panel.setBounds(12, 72, 792, 554);
	    panel.setLayout(new GridLayout(1, 1, 1, 1));
	  
	}
	return panel;
    }

}