import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math.*;
public class Calculator extends JFrame implements ActionListener
{
JButton b[ ] =new JButton[10];
JButton bp =new JButton("+");
JButton bs =new JButton("-");
JButton bm =new JButton("*");
JButton bd =new JButton("/");
JButton bper =new JButton("%");
JButton be =new JButton("=");
JButton bdot =new JButton(".");
JButton brec =new JButton("1/x");
JButton bsqrt =new JButton("sqrt");
JButton bmc =new JButton("MC");
JButton bmr =new JButton("MR");
JButton bms =new JButton("MS");
JButton bmp =new JButton("M+");
JButton bc =new JButton("C");
JButton bce =new JButton("CE");
JButton bpm =new JButton("+/-");
JTextField tx = new JTextField(30);
boolean flag,flagee;
String oprstr;
float val1,val2,res,mem;
public Calculator()
{
Container con=getContentPane();
JPanel p= new JPanel();
p.setLayout(new GridLayout (4,3,10,10));
for(int i=9;i>=0;i--)
{
b[i]=new JButton(""+i);
p.add(b[i]);
b[i].setBackground(new Color(222,222,222));
b[i].setForeground(Color.red);
b[i].addActionListener(new Digit());
}
p.add(bpm);
p.add(bdot);
JPanel p1= new JPanel();
p1.setLayout(new GridLayout(4,1,10,10));
p1.add(bmc);
p1.add(bmr);
p1.add(bms);
p1.add(bmp);
JPanel p2= new JPanel();
p2.setLayout(new GridLayout(4,2,10,10));
p2.add(bd);
p2.add(bsqrt);
p2.add(bm);
p2.add(brec);
p2.add(bs);
p2.add(bper);
p2.add(bp);
p2.add(be);
con.setLayout(null);
tx.setBounds(100,50,150,30);
con.add(tx);
p1.setBounds(50,140,70,230);
con.add(p1);
p.setBounds(130,140,170,230);
con.add(p);
p2.setBounds(310,140,140,230);
con.add(p2);
JPanel p3 = new JPanel();
p3.setLayout(new GridLayout(1,2,10,10));
p3.add(bc);
p3.add(bce);
p3.setBounds(150,90,130,30);
con.add(p3);
bs.addActionListener(this);
bp.addActionListener(this);
bm.addActionListener(this);
bc.addActionListener(this);
bd.addActionListener(this);
brec.addActionListener(this);
bdot.addActionListener(this);
be.addActionListener(this);
bsqrt.addActionListener(this);
bper.addActionListener(this);
bmc.addActionListener(this);
bms.addActionListener(this);
bmr.addActionListener(this);
bmp.addActionListener(this);
bpm.addActionListener(this);
bc.addActionListener(this);
bce.addActionListener(this);
flag = true;
flagee = false;
}
public class Digit implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JButton b=(JButton)e.getSource();
if (flag==true)
{
tx.setText(b.getLabel());
flag=false;
}
else
{
String s1=tx.getText();
String s2=b.getLabel();
tx.setText(s1+s2);
}
}
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bp || e.getSource()==bs || e.getSource()==bm || e.getSource()==bd || e.getSource()==bper)
{
oprstr=((JButton)e.getSource()).getLabel();
val1=Float.parseFloat(tx.getText());
flag=true;
}
else if(e.getSource()==be)
{
val2=Float.parseFloat(tx.getText());
char opr=oprstr.charAt(0);
switch(opr)
{
case '+':res=val1+val2;
break;
case '-':res=val1-val2;
break;
case '*':res=val1*val2;
break;
case '/':res=val1/val2;
break;
case '%':res=val1%val2;
break;
}
flag=true;
tx.setText(""+res);
}
else if(e.getSource()==brec)
{
val1=Float.parseFloat(tx.getText());
tx.setText(""+1/val1);
flag=true;
}
else if(e.getSource()==bsqrt)
{
val1=Float.parseFloat(tx.getText());
tx.setText(""+Math.sqrt(val1));
flag=true;
}
else if(e.getSource()==bpm)
{
val1=Float.parseFloat(tx.getText());
tx.setText(""+-1*val1);
}
else if(e.getSource()==bdot)
{
String str=tx.getText();
if(str.indexOf('.')==-1)
tx.setText(str+".");
}
else if(e.getSource()==bms)
{
mem=Float.parseFloat(tx.getText());
flag=true;
}
else if(e.getSource()==bmr)
{
tx.setText(""+mem);
flag=true;
}
else if(e.getSource()==bmp)
{
mem=mem+Float.parseFloat(tx.getText());
flag=true;
}
else if(e.getSource()==bmc)
{
mem=0;
flag=true;
}
else if(e.getSource()==bce)
{
oprstr="";
tx.setText(""+val1);
flag=true;
}
else if(e.getSource()==bc)
{
val1=0;
oprstr="";
tx.setText("0");
flag=true;
}
}
public static void main(String args[])
{
Calculator c=new Calculator();
c.setVisible(true);
c.setSize(500,500);
c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}