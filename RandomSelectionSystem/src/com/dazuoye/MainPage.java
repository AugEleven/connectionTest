package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener{//实现监听器接口
    private JFrame frame;
    private JPanel panel1,panel2;
    private JButton jb1,jb2;
    public MainPage(){
        frame=new JFrame("懒人吃什么管理系统");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
        panel1=new JPanel();
        panel2=new JPanel();

        panel1.add(new JLabel("请选择您要进行的操作"));


        jb1=new JButton("用户选菜");
        jb2=new JButton("管理员界面");
        panel2.add(jb1);
        panel2.add(jb2);

        frame.add(panel1);
        frame.add(panel2);

        frame.pack();
        frame.setVisible(true);
        show();
    }
    public void show(){
        jb1.addActionListener(this);//添加监听器
        jb2.addActionListener(this);
        frame.setBounds(800,300,600,600);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("用户选菜")){
            UserPage userPage=new UserPage();
        }
        if(e.getActionCommand().equals("管理员界面")){
            AdminLoginPage adminLoginPage =new AdminLoginPage();
        }
    }
}
