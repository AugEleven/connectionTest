package com.dazuoye;

public class DishLinkedNode {
    public String DishName;//菜名
    public String Canteen;//饭堂
    public String Stall;//档口
    public String Taste;//口味
    public double Price;//价格
    public DishLinkedNode next;//指向下一个结点的指针

    //构造器
    public DishLinkedNode(){}//无参数构造

    public DishLinkedNode(String dishName, String canteen, String stall, String taste, double price){
        this.DishName=dishName;
        this.Canteen=canteen;
        this.Stall=stall;
        this.Taste=taste;
        this.Price=price;
    }

    @Override
    public String toString() {
        return DishName+","+Canteen+","+Stall+","+Taste+","+Price+"\n";
    }
}
