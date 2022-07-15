package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Reader;

public class deletedishPage implements ActionListener{
    private JFrame frame;
    private JPanel panel1,panel2;
    private JButton button;
    private JTextField dishname;

    public deletedishPage(){
        frame=new JFrame("删除菜品");
        panel1=new JPanel();
        panel2=new JPanel();
        dishname=new JTextField(20);
        button=new JButton("删除");
        panel1.add(new JLabel("菜名："));
        panel1.add(dishname);
        panel2.add(button);
        frame.add(panel1);
        frame.add(panel2);


        frame.pack();
        frame.setVisible(true);
        show();
    }

    public void show(){

        button.addActionListener(this);//添加监视器
        frame.setBounds(500,500,350,250);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("删除")){
            String s= dishname.getText();
            Main.dishLinkedList.delete(s);
            DishLinkedList.updateDish();
            JOptionPane.showMessageDialog(null,"删除成功");
            dishname.setText("");
        }
    }
}
