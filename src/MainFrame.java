import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Locale;
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
    private JLabel jlbs[]=new JLabel[6];
    private int data[]=new int[6];
    private Random rnd = new Random(System.currentTimeMillis());
    private JButton jbtnClose= new JButton("Close");
    private JButton jbtnRegen= new JButton("Generate");

    //-----------設定字------------
    private JMenuItem jmiSetFont = new JMenuItem("Font");
    private JPanel JPanel1=new JPanel(new GridLayout(2,3,5,5));
    private  JLabel jlbFontFamily = new JLabel("Family");
    private  JLabel jlbFontStyle = new JLabel("Style");
    private JLabel jlbFontSize = new JLabel("Size");
    private JTextField jtfFamily = new JTextField();
    private JTextField jtfSize = new JTextField("24");
    private String[]options={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcbFStyle=new JComboBox(options);

    //-------File-book-cateory
    private JInternalFrame jIFAaaCategory=new JInternalFrame();
    private Container jIFAddCategoryCP;
    private JMenuBar jIFAddCategoryJmb=new JMenuBar();
    private JMenu jmData = new JMenu("Data");
    private JMenuItem jmiDataLoad =new JMenuItem("Load");
    private JMenuItem jmiDataNew =new JMenuItem("New");
    private JMenuItem jmiDataClose=new JMenuItem("Close");
    private JMenuItem jmiAddCategory= new JMenuItem("Category");
    private JScrollPane jsp1 =new JScrollPane();
    //-----------------------------
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
        this.setBounds(100,100,400,500);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
//        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(jmF0);
        jmb.add(jmF1);
        jmb.add(jmF2);
        jmb.add(jmF3);
        jmF0.add(jmiExit);
        jmF2.add(jmiLoto);
        this.setContentPane(jdp);
//        jifCP.setLayout(new BorderLayout(5,5));
//        jifCP.add(jpn,BorderLayout.SOUTH);
//        jifCP.add(jpn,BorderLayout.CENTER);



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

        jmiLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setBounds(10,10,300,300);
                jif.setVisible(true);
            }
        });

        //---------設定字-------
        JPanel1.add(jlbFontFamily);
        JPanel1.add(jlbFontStyle);
        JPanel1.add(jlbFontSize);
        JPanel1.add(jtfFamily);
        JPanel1.add(jcbFStyle);
        JPanel1.add(jtfSize);
        jmF1.add(jmiSetFont);

        jmiSetFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(MainFrame.this,JPanel1,"Font setting",JOptionPane.OK_CANCEL_OPTION);
                int fontStyle=0;
                switch(jcbFStyle.getSelectedIndex()){
                    case 0:
                        fontStyle=Font.PLAIN;
                        break;
                    case 1:
                        fontStyle=Font.BOLD;
                        break;
                    case 2:
                        fontStyle=Font.ITALIC;
                        break;
                    case 3:
                        fontStyle=Font.BOLD+Font.ITALIC;
                        break;
                }
                if(result==JOptionPane.OK_CANCEL_OPTION){
                    UIManager.put("Menu_font",new Font(jtfFamily.getText(),fontStyle,Integer.parseInt(jtfSize.getText())));
                }
            }
        });

        //-------File-book-cateory



        }
    }
