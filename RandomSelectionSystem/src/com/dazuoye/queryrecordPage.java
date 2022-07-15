package com.dazuoye;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;

public class queryrecordPage {
    private JFrame frame;
    private JPanel panel;
    private JTextArea record;
    private static StringBuilder recordString=new StringBuilder();
    private Reader fw;

    public queryrecordPage(){
        frame=new JFrame("随机记录显示");
        panel=new JPanel();
        record=new JTextArea(10,30);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(record);
        frame.add(panel);

        try {
            fw=new FileReader("record.txt");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "读取文件失败");
        }
        BufferedReader bfr=new BufferedReader(fw);
        String temp="";
        try {
            while ((temp = bfr.readLine()) != null){
                recordString.append(temp+"\n");
            }
            fw.close();
        }catch (Exception e){
            System.out.println("读取记录过程中出现错误");
        }

        frame.pack();
        frame.setVisible(true);
        show();
        record.setText(recordString.toString());
    }

    public void show(){
        frame.setBounds(800,300,700,700);
        frame.setLayout(new FlowLayout());
    }

}
