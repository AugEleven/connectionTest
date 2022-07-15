package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Reader;

public class updatedishPage implements ActionListener{
    private JFrame frame;
    private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
    private JButton jButton1,jButton2,jButton3,jButton4;
    private JTextField name,text;

    public updatedishPage(){
        frame=new JFrame("更新菜品");
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        jButton1=new JButton("更新饭堂信息");
        jButton2=new JButton("更新档口信息");
        jButton3=new JButton("更新口味信息");
        jButton4=new JButton("更新价格信息");
        name=new JTextField(20);
        text=new JTextField(20);

        panel1.add(new JLabel("要修改的菜名："));
        panel1.add(name);
        panel2.add(new JLabel("需要更新的内容："));
        panel2.add(text);
        panel3.add(jButton1);
        panel4.add(jButton2);
        panel5.add(jButton3);
        panel6.add(jButton4);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);

        frame.pack();
        frame.setVisible(true);
        show();

    }
    public void show(){

        jButton1.addActionListener(this);//添加监视器
        jButton2.addActionListener(this);//添加监视器
        jButton3.addActionListener(this);//添加监视器
        jButton4.addActionListener(this);//添加监视器
        frame.setBounds(500,500,350,250);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("更新饭堂信息")){
            String n= name.getText();
            String t=text.getText();
            Main.dishLinkedList.updateCanteen(n,t);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"更新成功");
            name.setText("");
            text.setText("");

        }
        else if(e.getActionCommand().equals("更新档口信息")){
            String n= name.getText();
            String t=text.getText();
            Main.dishLinkedList.updateStall(n,t);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"更新成功");
            name.setText("");
            text.setText("");
        }
        else if(e.getActionCommand().equals("更新口味信息")){
            String n= name.getText();
            String t=text.getText();
            Main.dishLinkedList.updateTaste(n,t);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"更新成功");
            name.setText("");
            text.setText("");
        }
        else if(e.getActionCommand().equals("更新价格信息")){
            String n= name.getText();
            String t=text.getText();
            Main.dishLinkedList.updatePrice(n,t);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"更新成功");
            name.setText("");
            text.setText("");
        }

    }
}
