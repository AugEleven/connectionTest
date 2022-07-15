package com.dazuoye;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<Administrator> administratorslist;
    public static Administrator administrator;
    public static File file;//管理员账号文件
    public static File file2;//菜品信息文件
    public static Reader fw, fw2;
    //public DishLinkedNode current;
    public static DishLinkedList dishLinkedList = new DishLinkedList();

    public static void main(String[] args) throws Exception {
        administratorslist = new ArrayList<Administrator>();



        File adminfile = new File("admin.txt");//管理员账号文本
        if (!adminfile.exists()) {
            try {
                adminfile.createNewFile();
                Writer fw = new FileWriter("admin.txt");
                fw.write("010811 000000");
                fw.flush();
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "创建失败");
            }
        }
        file = adminfile;//创建管理员文档，存储账号、密码
        administratorslistRead();

        File dishfile = new File("dish.txt");//菜单文件
        if (!dishfile.exists()) {
            try {
                dishfile.createNewFile();
                Writer fw2 = new FileWriter("dish.txt");
                fw2.write(dishLinkedList.toString());
                fw2.flush();
                fw2.close();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "创建失败");
            }
        }
        file2 = dishfile;
        //DishLinkedList.updateDish();
        dishLinkedList.DishRead();


        MainPage mainPage = new MainPage();
        dishLinkedList.showList();
    }

    public static void administratorslistRead() {
        try {
            fw = new FileReader("admin.txt");//字符流
        } catch (Exception e) {
            System.out.println("字符流创建失败");
        }

        BufferedReader bfr = new BufferedReader(fw);
        String temp = "";
        try {

            System.out.println("开始写入list");
            while ((temp = bfr.readLine()) != null) {//不知为何读取出的字符串中最前面会出现Null
                String[] tmpstr;
                tmpstr = temp.split("\\s+");//分割空格

                System.out.println("账号：" + tmpstr[0]);

                Administrator administrator = new Administrator(tmpstr[0], tmpstr[1]);
                administratorslist.add(administrator);
                System.out.println("读取到" + administrator.account);

            }
            bfr.close();
            fw.close();
            System.out.println("管理员list:" + administratorslist);
        } catch (Exception e) {
            System.out.println("读取管理员信息失败");
        }
    }



    //读取菜单
    /*public static void DishRead(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("dish.txt"));
            String Line=null;
            while ((Line= br.readLine())!=null){
                String[] dishinfo=Line.split(",");//以句号分割
                DishLinkedNode dln=new DishLinkedNode(dishinfo[0],dishinfo[1],dishinfo[2],dishinfo[3],Double.parseDouble(dishinfo[4]));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

     */

    //更新菜单数据
    /*public static void updateDish(){
        try {
            Writer fw2=new FileWriter("dish.txt");

            while (true){

            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("更新失败");
        }
    }

     */
}

