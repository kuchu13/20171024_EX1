import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JLabel jlbID = new JLabel("ID");
    private JLabel jlbPW = new JLabel("Password");

    private JTextField jtfID = new JTextField();
    //    private JTextField jtfPW = new JTextField();
    private JPasswordField jtfPW = new JPasswordField();
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnLogin = new JButton("Login");
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH = 150,screenW,screenH;
    private Container cp;

    public LoginFrame() {
        screenW=dim.width;
        screenH=dim.height;
        initComp();
    }
    private void initComp() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setBounds(100,100,300,150);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        jlbID.setHorizontalAlignment(JLabel.RIGHT);
        jlbPW.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(jlbID);
        cp.add(jtfID);
        cp.add(jlbPW);
        cp.add(jtfPW);
        cp.add(jbtnExit);
        cp.add(jbtnLogin);

        jbtnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfID.getText().equals("h304")&&(new String(jtfPW.getPassword())).equals("23323456")){
                    MainFrame mainFrame= new MainFrame(LoginFrame.this);
                    mainFrame.setVisible(true);
                    LoginFrame.this.setVisible(false);
                    System.out.println("Yes");
                }else{
                    System.out.println("No"+"\tID:"+jtfID.getText()+"\tPw:"+new String(jtfPW.getPassword()));
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                }
            }
        });
        jbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}