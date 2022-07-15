package com.dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage implements ActionListener{
    private JFrame frame;
    private JTextField id;
    private JPasswordField password;
    private JPanel panel0,panel1,panel2,panel3,panel4;
    private JButton jb1,jb2;

    public AdminLoginPage(){
        frame=new JFrame("管理员系统");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel0=new JPanel();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();

        panel0.add(new JLabel("请您先完成登录"));
        frame.add(panel0);

        panel1.add(new JLabel("\t账号："));
        id=new JTextField(20);
        panel1.add(id);
        frame.add(panel1);

        panel2.add((new JLabel("\t密码：")));
        password=new JPasswordField(10);
        panel2.add(password);
        frame.add(panel2);

        jb1=new JButton("登录");
        jb2=new JButton("取消");
        panel3.add(jb1);
        panel3.add(jb2);
        frame.add(panel3);

        frame.pack();
        frame.setVisible(true);
        show();

    }
    public void show(){
        jb1.addActionListener(this);//添加监听器
        jb2.addActionListener(this);
        frame.setBounds(800,300,300,350);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("登录")){
            for(int i=0;i<Main.administratorslist.size();i++){
                if(Main.administratorslist.get(i).account.equals(id.getText())){
                    if(String.valueOf(password.getPassword()).equals(Main.administratorslist.get(i).password)){
                        JOptionPane.showMessageDialog(frame, "登录成功");
                        AdminPage adminPage=new AdminPage();//实例化管理员页面
                        frame.setVisible(false);//登录窗口设置为不可见
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "密码错误");
                        password.setText("");
                        return;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame, "该用户不存在");
                    id.setText("");
                    password.setText("");
                    return;
                }
            }

        }
        if(e.getActionCommand().equals("取消")){
            resetValue(e);
        }
    }
    protected void resetValue(ActionEvent e){//实现取消按钮，重置文本框和密码框的方法体
        id.setText("");
        password.setText("");
    }
}
