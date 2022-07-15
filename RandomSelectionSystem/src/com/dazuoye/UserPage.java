package com.dazuoye;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserPage implements ActionListener{
    private JFrame frame;
    private JPanel p1,p2,p3,p4,p5;
    private JTextArea dishshow;
    private JTextField search;
    private JLabel menu;
    private JButton jb1,jb2,jb3,jb4,jb5,jb6;
    public static StringBuilder dishString=new StringBuilder();
    public static StringBuilder searchString1=new StringBuilder();
    public static StringBuilder searchString2=new StringBuilder();
    public static StringBuilder searchString3=new StringBuilder();
    private Reader fw,fr;

    public UserPage(){
        frame=new JFrame("用户选菜界面~");
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        search=new JTextField(20);
        jb1=new JButton("展示所有菜单");
        jb2=new JButton("查询");
        jb3=new JButton("随机帮你选");


        menu=new JLabel("下面是可供选择的菜品，共有"+Main.dishLinkedList.getLength()+"个");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dishshow=new JTextArea(10,30);
        p1.add(menu);
        p1.add(dishshow);
        p2.add(new JLabel("输入你想查询的菜品："));
        p2.add(search);
        p3.add(jb1);
        p4.add(jb3);
        p5.add(jb2);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);

        try {
            fw=new FileReader("dish.txt");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "读取菜单失败");
        }
        BufferedReader bfr=new BufferedReader(fw);
        String temp="";
        try {
            while ((temp = bfr.readLine()) != null){
                dishString.append(temp+"\n");
            }
            fw.close();
        }catch (Exception e){
            System.out.println("读取记录过程中出现错误");
        }
        //dishshow.setText(dishString.toString());


        frame.pack();
        frame.setVisible(true);
        show();
    }
    public void show(){
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        frame.setBounds(800,300,700,700);
        frame.setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("展示所有菜单")){
            dishshow.setText(dishString.toString());
        }
        else if(e.getActionCommand().equals("查询")){
            dishshow.setText("");
            String s=search.getText();
            if(s.indexOf("饭堂")!=-1){

                for(String a:Main.dishLinkedList.getByCanteen(s)){
                    if(a!=null){
                        searchString1.append(a+"\n");
                    }
                }
                dishshow.setText(searchString1.toString());
            }
            else if(s.indexOf("档口")!=-1){
                for(String a:Main.dishLinkedList.getByStall(s)){
                    if(a!=null){
                        searchString2.append(a+"\n");
                    }
                }
                dishshow.setText(searchString2.toString());
            }
            else if(s.indexOf("类")!=-1){
                for(String a:Main.dishLinkedList.getByTaste(s)){
                    if(a!=null){
                        searchString3.append(a+"\n");
                    }
                }
                dishshow.setText(searchString3.toString());
            }

        }
        else if(e.getActionCommand().equals("随机帮你选")){
            Random random=new Random();
            String[] tempdish=new String[Main.dishLinkedList.getLength()];
            try{
                BufferedReader br=new BufferedReader(new FileReader("dish.txt"));
                String Line=null;
                int i=0;

                while ((Line= br.readLine())!=null){
                    tempdish[i]=Line;
                    i++;

                }
            }catch (Exception e1){
                e1.printStackTrace();
            }

            int r=random.nextInt(Main.dishLinkedList.getLength());
            dishshow.setText("为你随机选择的是："+tempdish[r]);
            //*****************记录随机信息****************************
            File recordFile=new File("record.txt");

            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String dateString=dateFormat.format(date);

            try {
                fr=new FileReader("record.txt");
            }catch (IOException ex){
                ex.printStackTrace();
            }
            if(!recordFile.exists()){
                try {
                    recordFile.createNewFile();
                    FileWriter fw2=new FileWriter("record.txt");
                    fw2.write(dateString+" "+tempdish[r]+"\n");
                    fw2.flush();
                    fw2.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }else {
                try {

                    FileWriter fw2=new FileWriter("record.txt",true);
                    fw2.write(dateString+" "+tempdish[r]+"\n");
                    fw2.flush();
                    fw2.close();

                }catch (Exception e3){
                    e3.printStackTrace();
                }
            }

        }
    }
}
