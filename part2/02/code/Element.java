package com.nari.s6000;

public class Element{
	   public String heroName;
	   public int heroAge;
	   public int heroNo;
	   public Element nextNode;
	   public Element(String name,int age,int no) {
		   this.heroName=name;
		   this.heroAge=age;
		   this.heroNo=no;
	   }
	@Override
	public String toString() {
		return "Element [heroName=" + heroName + ", heroAge=" + heroAge + ", heroNo=" + heroNo + "]";
	}
	   
}
