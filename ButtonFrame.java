import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public  class ButtonFrame extends JFrame implements ActionListener
{
    JButton Left = new JButton ("Align Left");
    JButton Center = new JButton ("Align Center");
    JButton Right = new JButton ("Align Right");
    JButton Resize = new JButton ("Resize");
    
    JMenuItem j1 = new JMenuItem("Reset");
    JMenuItem j2 = new JMenuItem("Double");
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu ("Options");
    JLabel WidthLabel = new JLabel("Width:   ");
    JTextField Width;
    JLabel HeightLabel = new JLabel("Height:     ");
    JTextField Height;
    ImageIcon image = new ImageIcon("pic_input.jpg");
    JLabel label = new JLabel("", image, JLabel.CENTER);
    JPanel pane= new JPanel();
    
    Image img = image.getImage();
    int wid = image.getIconWidth();
    int hei = image.getIconHeight();
    public ButtonFrame()
    {
        super("Image Application");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Left.addActionListener(this);
        Center.addActionListener(this);
        Right.addActionListener(this);
        Resize.addActionListener(this);
        j1.addActionListener(this);
        j2.addActionListener(this);
       //Menu construction
        menu.add(j1);
        menu.add(j2);
        menubar.add(menu);
        setJMenuBar(menubar);

        pane.setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();
        subPanel.add(Left);
        subPanel.add(Center);
        subPanel.add(Right);
        pane.add(subPanel, BorderLayout.NORTH);

        pane.add( label);
        
        Width = new JTextField(Integer.toString(wid) ,20);
        Height = new JTextField(Integer.toString(hei) ,20);
        
        JPanel subPanel2 = new JPanel();
        subPanel2.add(WidthLabel);
        subPanel2.add(Width);
        subPanel2.add(HeightLabel);
        subPanel2.add(Height);
        subPanel2.add(Resize);
        pane.add(subPanel2, BorderLayout.SOUTH);
        add(pane);
        setVisible(true);   
    } 
   public void actionPerformed(ActionEvent evt)
    {
        Object source =evt.getSource();
        if (source == Left)
        {
            label.setHorizontalAlignment(JLabel.LEFT);
        }
        else if (source == Center)
        {
            label.setHorizontalAlignment(JLabel.CENTER);
        }
        else if (source == Right)
        {
            label.setHorizontalAlignment(JLabel.RIGHT);
        }
        else if (source == Resize)
        {
            String text1 = Width.getText();
            String text2 = Height.getText();
            int int1 = Integer.parseInt(text1);
            int int2 = Integer.parseInt(text2);
            pane.remove(label);
            Image newimg = img.getScaledInstance(int1,int2,java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            label = new JLabel("", newIcon, JLabel.CENTER);
            pane.add(label);
            pane.revalidate();
        }
        else if (source == j1)
        {
            pane.remove(label);
            Image newimg = img.getScaledInstance(wid,hei,java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            label = new JLabel("", newIcon, JLabel.CENTER);
            Width.setText(Integer.toString(wid) );
            Height.setText(Integer.toString(hei) );
            pane.add(label);
            pane.revalidate();
        }
        else if (source == j2)
        {
            String text1 = Width.getText();
            String text2 = Height.getText();
            int int1 = Integer.parseInt(text1)*2;
            int int2 = Integer.parseInt(text2)*2;
            pane.remove(label);
            Image newimg = img.getScaledInstance(int1,int2,java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            label = new JLabel("", newIcon, JLabel.CENTER);
            Width.setText(Integer.toString(int1) );
            Height.setText(Integer.toString(int2) );
            pane.add(label);
            pane.revalidate();
        }
    }
   public void paint()
   {
       Image img1 = Toolkit.getDefaultToolkit().getImage("pic_input.jpg");
   }
   void setalignment (JLabel label)
   {
       label.setHorizontalAlignment(JLabel.LEFT);
       
   }   
}
