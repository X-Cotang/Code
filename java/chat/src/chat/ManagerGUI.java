package chat;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.GridLayout;

public class ManagerGUI extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private JPanel panel;

    // _________________________________________
    static ManagerGUI thisManager;
    static ServerSocket socket = null;
    BufferedReader br = null;
    Thread t;
    private JLabel lblHistory;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ManagerGUI frame = new ManagerGUI();
		    frame.setVisible(true);
		    
		    int port = 1234;

		    try {
			
			socket = new ServerSocket(port);
		    } catch (Exception e) {
			
		    }
		    Thread t = new Thread(thisManager);
		    t.start();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public ManagerGUI() {
	initComponents();
	thisManager = this;
    }

    private void initComponents() {
	setTitle("Server");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 835, 674);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.add(getLblHistory());
	
	panel = new JPanel();
	panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setBounds(10, 59, 811, 554);
	contentPane.add(panel);
	panel.setLayout(new GridLayout(1, 1, 1, 1));

    }

    @Override
    public void run() {
	while (true)

	    try {
		
		Socket staffSocket = socket.accept();
		if (staffSocket != null) {
	
		    /*br = new BufferedReader(new InputStreamReader(staffSocket.getInputStream()));
		    String staffName = br.readLine();
		    staffName = staffName.substring(0, staffName.indexOf(":"));
		     */
		
		    chatPanel chatPanel = new chatPanel(staffSocket, "Server");
		    panel.add(chatPanel);
		    chatPanel.updateUI();
		    lblHistory.setVisible(false);
		    Thread t = new Thread(chatPanel);
		    t.start();
		}

		Thread.sleep(1000);
	    } catch (Exception e) {
	
	    }
    }

	private JLabel getLblHistory() {
		if (lblHistory == null) {
			lblHistory = new JLabel("Dang cho ket noi...");
			lblHistory.setForeground(Color.RED);
			lblHistory.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblHistory.setBounds(329, 27, 198, 22);
		}
		return lblHistory;
	}
}