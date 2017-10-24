import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private Container cp;
    private LoginFrame loginFrame;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH = 150,screenW,screenH;


    private JMenuBar jmb = new JMenuBar();
    private JMenuItem jmiExit = new JMenuItem("Exit");
    private JMenuItem jmiLoto = new JMenuItem("Loto");
    private JInternalFrame jif = new JInternalFrame();
    private JDesktopPane jdp = new JDesktopPane();

    private Container jifCP;
    private JPanel jpn =new JPanel(new GridLayout(1,6,5,5));
    private JPanel jpn1 =new JPanel(new GridLayout(1,2,5,5));
    private Label jlbs[]=new JLabel[6];
    private int data[]=new int[6];
    private Random rnd = new Random(System.currentTimeMillis());
    private JButton jbtnClose= new JButton("Close");
    private JButton jbtnRegen= new JButton("Generate");

    JMenu jmF0 =new JMenu("File");
    JMenu jmF1 =new JMenu("Set");
    JMenu jmF2 =new JMenu("Game");
    JMenu jmF3 =new JMenu("About");

    public MainFrame (LoginFrame login) {
        screenW=dim.width;
        screenH=dim.height;
        loginFrame=login;
        initComp();
    }
    private void initComp() {
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);

        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        this.setBounds(100,100,400,500);
//        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setJMenuBar(jmb);
        this.setJMenuBar(jmb);
        this.setJMenuBar(jmb);
        jmb.add(jmF0);
        jmb.add(jmF1);
        jmb.add(jmF2);
        jmb.add(jmF3);
        jmF0.add(jmiExit);
        jmF2.add(jmiLoto);
        this.setContentPane();
        jifCP.setLayout(new BorderLayout(5,5));
        jifCP.add(jpn,BorderLayout.SOUTH);
        jifCP.add(jpn,BorderLayout.CENTER);










        jmiExit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
        jmiExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        this.setContentPane(jdp);

        jmiLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setBounds(10,10,300,300);
                jif.setVisible(true);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
//                loginFrame.reset();
            }
        });

        }
    }
