package com.nari.s6000;

public class ElementLinkedList {
	Element head =new Element("", 0, 0);
	
	public static void main(String[] args) {
		Element el1=new Element("张三", 11, 1);
		Element el4=new Element("郑六", 12, 4);
		Element el2=new Element("李四", 18, 2);
		Element el3=new Element("王五", 14, 3);
		ElementLinkedList elList=new ElementLinkedList();
		elList.addElementBySort(el4);
		elList.addElementBySort(el1);
		elList.addElementBySort(el2);
		elList.addElementBySort(el3);
		el1=new Element("赵七", 100, 2);
		elList.deleteElByNo(4);
		elList.updateEl(el1);
		elList.list();		
	}
	public void addElement(Element el) {
		//head是不能动的，所以需要一个temp来记录临时变量
		Element temp=head;
		//需要找到链表的尾部
		while(true) {
			if(temp.nextNode==null) {
				temp.nextNode=el;
				break;
			}
			temp=temp.nextNode;
		}
	}
	
	public void list() {
		if(head.nextNode==null) {
			System.out.println("链表为空");
		}else {
			Element temp=head.nextNode;
			while(true) {
				System.out.println(temp.toString());
				if(temp.nextNode==null) {
					break;
				}
				temp=temp.nextNode;
			}
		}
	}
	
	public void addElementBySort(Element el) {
		//head是不能动的，所以需要一个temp来记录临时变量
		Element temp=head;
		boolean flag=false; //判断这个编号是否存在
		while(true) {
			if(temp.nextNode==null) {
				break;
			}
			if(temp.nextNode.heroNo>el.heroNo) { //这时候就已经找到适合添加的位置
				break;
			}else if(temp.nextNode.heroNo==el.heroNo) {
				flag=true;
				break;
			}
			temp=temp.nextNode;
		}
		if(flag) {
			System.out.printf("该%d编号已经存在",el.heroNo);
		}else {
			el.nextNode=temp.nextNode;
			temp.nextNode=el;
		}
	}
	
	public void updateEl(Element el) {
		Element temp=head;
		boolean flag=false;
		while(true) {
			if(temp.nextNode==null) {
				break;
			}
			if(temp.heroNo==el.heroNo) {
				flag=true;
				break;
			}
			temp=temp.nextNode;
		}
		if(!flag) {
			System.out.printf("你所修改英雄的编号%d不存在",el.heroNo);
		}else {
			temp.heroName=el.heroName;
			temp.heroAge=el.heroAge;
		}
	}
	
	public void deleteElByNo(int no) {
		Element temp=head;
		boolean flag=false;
		
		while(true) {
			if(temp.nextNode==null) {
				break;
			}
			if(temp.nextNode.heroNo==no) {
				flag=true;
				break;
			}
			temp=temp.nextNode;
		}
		if(flag) {
			temp.nextNode=temp.nextNode.nextNode;
			System.out.println("删除成功");
		}else {
			System.out.println("你所删除的元素不存在");
		}
	}
}
