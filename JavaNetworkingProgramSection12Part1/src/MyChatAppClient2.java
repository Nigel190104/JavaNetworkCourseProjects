import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

public class MyChatAppClient2 extends JFrame implements ActionListener {

    String username;
    PrintWriter pw;
    BufferedReader br;
    JTextArea taMessages;
    JTextField tfInput;
    JButton btnSend, btnExit;
    Socket client;

    public MyChatAppClient2(String uname, String serverName) throws IOException {
        super(uname);
        this.username = uname;
        client = new Socket(serverName, 9999);
        br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        pw = new PrintWriter(client.getOutputStream(), true);
        pw.println(username);
        buildInterface();
        new MessagesThread().start();
    }

    public void buildInterface(){
        btnSend = new JButton("Send");
        btnExit = new JButton("Exit");
        taMessages = new JTextArea();
        taMessages.setRows(10);
        taMessages.setColumns(50);
        taMessages.setEditable(false);
        tfInput = new JTextField(50);
        JScrollPane sp = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp, "Center");
        JPanel bp = new JPanel(new FlowLayout());
        bp.add(tfInput);
        bp.add(btnSend);
        bp.add(btnExit);
        add(bp, "South");
        btnSend.addActionListener(this);
        btnExit.addActionListener(this);
        setSize(550, 300);
        setVisible(true);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == btnExit){
            pw.println("end");
            System.exit(0);
        }else{
            pw.println(tfInput.getText());
        }
    }

    public static void main(String[] args){
        String name = JOptionPane.showInputDialog(null, "Enter your name : ",
                "Username", JOptionPane.PLAIN_MESSAGE);
        String servername = "localhost";
        try{
            new MyChatAppClient2(name, servername);

        }catch(Exception ex){
            out.println("Error : -> " + ex.getMessage());
        }

    }

    class MessagesThread extends Thread{

        public void run(){
            String line;
            try{
                while (true){
                    line = br.readLine();
                    taMessages.append(line + "\n");

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
