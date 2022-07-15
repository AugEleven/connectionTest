package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage implements ActionListener{
    private JFrame frame;
    private JPanel p1,p2;
    private JButton adddish,deldish,updatedish;
    private JButton queryrecord;

    public AdminPage(){
        frame=new JFrame("欢迎来到管理员界面~");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton adddish=new JButton("添加菜单");
        JButton delish=new JButton("删除菜品");
        JButton updatedish=new JButton("更新菜单");
        JButton queryrecord=new JButton("查询随机记录");

        p1=new JPanel();
        p2=new JPanel();

        p1.add(new JLabel("选择您要进行的操作"));
        frame.add(p1);

        p2.add(adddish);
        p2.add(delish);
        p2.add(updatedish);
        p2.add(queryrecord);

        p2.setLayout(new GridLayout(4,1,30,20));
        frame.add(p2);
        //绑定监听器
        adddish.addActionListener(this);
        delish.addActionListener(this);
        updatedish.addActionListener(this);
        queryrecord.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        show();

    }
    public void show(){

        frame.setBounds(800,300,700,700);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();//为cmd赋值为按钮的属性值
        if(cmd.equals("添加菜单")){
            adddishPage aPage=new adddishPage();
        }
        else if (cmd.equals("删除菜品")){
            deletedishPage dPage=new deletedishPage();
        }
        else if(cmd.equals("更新菜单")){
            updatedishPage uPage=new updatedishPage();
        }
        else if(cmd.equals("查询随机记录")){
            queryrecordPage q=new queryrecordPage();
        }

    }
}
