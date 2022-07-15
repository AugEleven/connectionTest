package com.dazuoye;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class DishLinkedList {

    //初始头节点，但不存放数据

    public static DishLinkedNode head=new DishLinkedNode("","","","",0);

    //添加菜品信息(直接在末尾添加)
    public static void add(DishLinkedNode dishLinkedNode){
        //头结点不能移动，需要辅助结点temp来帮助我们遍历
        DishLinkedNode temp=head;
        while (true){
            //找到该链表的最后
            //判断条件是遍历的辅助结点的指针为空，即为找到
            if(temp.next==null)
                //跳出循环
                break;

            //如果还没有找到最后，那temp就后移一位
            temp=temp.next;
        }
        //退出该循环的时候，temp的next就指向了链表的尾结点
        temp.next=dishLinkedNode;
    }

    //添加菜品信息(按照价格添加)
    public static void addByPrice(DishLinkedNode dishLinkedNode){
        //因为是单链表，我们找的temp是位于添加位置的前一个节点，否则无法进行插入
        //创建辅助结点
        DishLinkedNode temp=head;

        boolean flag=false;//能否成功添加的标志，默认为false
        while(true){
            if(dishLinkedNode.Price==0){
                flag=true;
                break;
            }
            if(temp.next==null){//说明temp已经在链表最后了
                break;
            }
            if(temp.next.Price>dishLinkedNode.Price){//位置找到，就在temp的后面插入
                break;
            }
            temp=temp.next;//temp后移
        }
        //判断flag的值
        if(flag){
            System.out.println("您输入的价格不合法，请重新输入");
        }
        else {
            //插入到temp的后面
            dishLinkedNode.next=temp.next;
            temp.next=dishLinkedNode;
        }
    }

    //删除菜品信息(根据菜名来进行删除)
    public void delete(String name){
        //构建辅助结点temp
        DishLinkedNode temp=head;
        //标志是否找到符合删除项，默认为false
        boolean flag=false;
        //int i=0;
        while (true){
            if(temp.next==null){//已经找到链表的最后

                break;
            }
            else if(temp.next.DishName.equals(name)){//找到待删除的菜品的前一个结点
                flag=true;
                //System.out.println("啦啦啦啦啦flag");
                break;
            }
            //System.out.println(temp.next.DishName);
            //i++;
            temp=temp.next;//结点后移
        }
        //判断flag
        if(flag){
            //找到，可以进行删除
            temp.next=temp.next.next;
        }else {
            System.out.println("该菜品不存在");
        }
    }

    //修改菜品的价格
    public void updatePrice(String dishname,String newprice){
        //判断是否为空链表
        if(head.next==null){
            System.out.println("目前还没有菜品信息，请进行添加");
            return;
        }
        //构建辅助结点
        DishLinkedNode temp=head;
        boolean flag=false;//是否找到对应结点的标志，默认为false
        while (true){
            if(temp==null){//已经遍历完链表了
                break;
            }
            if(temp.DishName.equals(dishname)){//根据菜品名字找到要修改的菜品
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //对flag进行判断
        if(flag){
            temp.Price=Double.parseDouble(newprice);//修改找到的菜品的价格
        }else {
            System.out.println("没有找到要修改的菜品，请重新输入");
        }
    }

    //修改菜品的档口
    public void updateStall(String dishname,String newstall){
        //判断是否为空链表
        if(head.next==null){
            System.out.println("目前还没有菜品信息，请进行添加");
            return;
        }
        //构建辅助结点
        DishLinkedNode temp=head;
        boolean flag=false;//是否找到对应结点的标志，默认为false
        while (true){
            if(temp==null){//已经遍历完链表了
                break;
            }
            if(temp.DishName.equals(dishname)){//根据菜品名字找到要修改的菜品
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //对flag进行判断
        if(flag){
            temp.Stall=newstall;//修改找到的菜品的档口信息
        }else {
            System.out.println("没有找到要修改的菜品，请重新输入");
        }
    }

    //修改菜品的饭堂
    public void updateCanteen(String dishname,String newcanteen){
        //判断是否为空链表
        if(head.next==null){
            System.out.println("目前还没有菜品信息，请进行添加");
            return;
        }
        //构建辅助结点
        DishLinkedNode temp=head;
        boolean flag=false;//是否找到对应结点的标志，默认为false
        while (true){
            if(temp==null){//已经遍历完链表了
                break;
            }
            if(temp.DishName.equals(dishname)){//根据菜品名字找到要修改的菜品
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //对flag进行判断
        if(flag){
            temp.Canteen=newcanteen;//修改找到的菜品的价格
        }else {
            System.out.println("没有找到要修改的菜品，请重新输入");
        }
    }

    //修改菜品的口味
    public void updateTaste(String dishname,String newtaste){
        //判断是否为空链表
        if(head.next==null){
            System.out.println("目前还没有菜品信息，请进行添加");
            return;
        }
        //构建辅助结点
        DishLinkedNode temp=head;
        boolean flag=false;//是否找到对应结点的标志，默认为false
        while (true){
            if(temp==null){//已经遍历完链表了
                break;
            }
            if(temp.DishName.equals(dishname)){//根据菜品名字找到要修改的菜品
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //对flag进行判断
        if(flag){
            temp.Taste=newtaste;//修改找到的菜品的价格
        }else {
            System.out.println("没有找到要修改的菜品，请重新输入");
        }
    }

    //按照饭堂查询
    public String[] getByCanteen(String canteen){
        //构建辅助结点
        DishLinkedNode temp=head;
        String[] dish=new String[Main.dishLinkedList.getLength()];
        int count=0;
        //System.out.println(canteen+"的菜品有：");
        while (temp!=null){
            if (temp.Canteen.equals(canteen)) {
                dish[count] = temp.toString();
                count++;
                //System.out.println(temp.toString());

            }

            temp=temp.next;

        }
        /*for(String x:dish){
            System.out.println("***********************************");
            System.out.println(x);
        }

         */
        return dish;
        //System.out.println("一共"+count+"个菜品");
    }

    //按照档口查询
    public String[] getByStall(String stall){
        //构建辅助结点
        DishLinkedNode temp=head;
        String[] dish=new String[Main.dishLinkedList.getLength()];
        int count=0;
        //System.out.println(stall+"的菜品有：");
        while (temp!=null){
            if (temp.Stall.equals(stall)){
                dish[count]=temp.toString();
                count++;
                //System.out.println(temp.toString());
            }
            temp=temp.next;
        }
        return dish;
        //System.out.println("一共"+count+"个菜品");
    }

    //按照口味查询
    public String[] getByTaste(String taste){
        //构建辅助结点
        DishLinkedNode temp=head;
        String[] dish=new String[Main.dishLinkedList.getLength()];
        int count=0;
        //System.out.println(taste+"的菜品有：");
        while (temp!=null){
            if (temp.Taste.equals(taste)){
                dish[count]=temp.toString();
                count++;
                //System.out.println(temp.toString());
            }
            temp=temp.next;
        }
        return dish;
        //System.out.println("一共"+count+"个菜品");
    }

    //按照菜名查询
    public String[] getByDishName(String dishName){
        //构建辅助结点
        DishLinkedNode temp=head;
        String[] dish=new String[Main.dishLinkedList.getLength()];
        int count=0;
        //System.out.println(dishName+"的菜品有：");
        while (temp!=null){
            if (temp.DishName.equals(dishName)){
                dish[count]=temp.toString();
                count++;
                //System.out.println(temp.toString());
            }
            temp=temp.next;
        }
        return dish;
        //System.out.println("一共"+count+"个菜品");
    }

    //获得链表长度
    public int getLength(){
        int count=0;
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return 0;
        }
        //构造辅助结点
        DishLinkedNode temp=head.next;

        while (true){
            //判断链表是否遍历到了最后
            if(temp==null){
                break;
            }
            count++;
            temp=temp.next;

        }
        return count;
    }

    //展示菜单遍历
    public void showList(){
        //判断链表是不是为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        DishLinkedNode temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }
//************************************************************************************//

    public static DishLinkedNode sortList(DishLinkedNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }
    public static void quickSort(DishLinkedNode head, DishLinkedNode end) {
        if (head != end) {
            DishLinkedNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static DishLinkedNode partion(DishLinkedNode head, DishLinkedNode end) {
        DishLinkedNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.Price < head.Price) {
                p1 = p1.next;

                DishLinkedNode tempnode = p1;
                p1.next= p2.next;
                p2.next = tempnode;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            DishLinkedNode tempnode = p1;
            p1.next = head.next;
            head.next = tempnode;
        }
        return p1;
    }


//************************************************************************************//


    public void DishRead(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("dish.txt"));
            String Line=null;
            DishLinkedNode temp=head;
            while ((Line= br.readLine())!=null){
                String[] dishinfo=new String[5];
                dishinfo=Line.split(",");//以句号分割
                DishLinkedNode dln=new DishLinkedNode(dishinfo[0],dishinfo[1],dishinfo[2],dishinfo[3],Double.parseDouble(dishinfo[4]));
                while (true){


                    if(temp.next==null){
                        break;
                    }
                    temp=temp.next;
                }
                temp.next=dln;

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void updateDish(){
        try {
            FileWriter fw2=new FileWriter("dish.txt");
            //Main.dishLinkedList.sortList(head);
            DishLinkedNode temp=head.next;
            //Main.dishLinkedList.sortList(head);
            while (temp!=null){
                fw2.write(temp.toString());
                fw2.flush();
                temp=temp.next;

            }

            fw2.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("更新失败");
        }
    }

}
