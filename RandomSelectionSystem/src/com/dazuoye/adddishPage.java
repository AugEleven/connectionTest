package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Reader;

public class adddishPage implements ActionListener{
    private JFrame frame;
    private JPanel p1,p2,p3,p4,p5,p6;
    private JTextField name,canteen,stall,taste,price;
    private JButton jb;
    private Reader fw;

    public adddishPage(){
        frame=new JFrame("添加菜品");
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();

        name=new JTextField(20);
        canteen=new JTextField(20);
        stall=new JTextField(20);
        taste=new JTextField(20);
        price=new JTextField(20);
        jb=new JButton("添加");

        p1.add(new JLabel("菜名："));
        p1.add(name);
        p2.add(new JLabel("所属饭堂："));
        p2.add(canteen);
        p3.add(new JLabel("所属档口："));
        p3.add(stall);
        p4.add(new JLabel("口味："));
        p4.add(taste);
        p5.add(new JLabel("价格："));
        p5.add(price);
        p6.add(jb);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);
        frame.add(p6);

        frame.pack();
        frame.setVisible(true);
        show();


    }
    public void show(){

        jb.addActionListener(this);//添加监视器
        frame.setBounds(500,500,350,250);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("添加")){
            String n= name.getText();
            String c=canteen.getText();
            String s=stall.getText();
            String t=taste.getText();
            double p=Double.parseDouble(price.getText());
            DishLinkedNode newdish=new DishLinkedNode(n,c,s,t,p);
            DishLinkedList.addByPrice(newdish);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"添加成功");
            name.setText("");
            canteen.setText("");
            stall.setText("");
            taste.setText("");
            price.setText("");

        }
    }
}
