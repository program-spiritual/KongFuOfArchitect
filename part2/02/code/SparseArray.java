package com.nari.s6000;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//对棋盘内容进行存档
public class SparseArray {
	
	public static void main(String[] args) {
		//创建一个11*11的棋盘
		int chessarry1[][]  =new int [11][11];
		//0表示棋盘的上的该位置没有棋子，1表示是白子，2表示的是黑子
		chessarry1[2][9]=1;
		chessarry1[3][4]=2;
		chessarry1[5][10]=1;
		chessarry1[7][6]=2;
		chessarry1[4][6]=1;
		chessarry1[3][0]=2;
		chessarry1[10][10]=1;
		chessarry1[0][0]=2;
		System.out.println("棋盘存档内容是：");
		
		for (int[] is : chessarry1) {
			for (int data : is) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		int sum=0;
		
		//稀疏数组需要有多少个非零值(即有效值),这一步必须单独进行
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessarry1[i][j]!=0) {
					sum++;
				}
			}
			
		}
		System.out.println("一共有"+sum+"个有效值");
		
		int chessArry2[][]=new int[sum+1][3];
		chessArry2[0][0]=11;
		chessArry2[0][1]=11;
		chessArry2[0][2]=sum;
		
		int count=0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessarry1[i][j]!=0) {
					++count;
					chessArry2[count][0]=i;
					chessArry2[count][1]=j;
					chessArry2[count][2]=chessarry1[i][j];
				}
			}
			
		}
		
		System.out.println("得到的稀疏数组是：");
		for (int[] is : chessArry2) {
			for (int data : is) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		writeToFile(chessArry2);
		
		readFileToObj();
		
	}
	
	
	public static  void writeToFile(int[][] chess) {
		ArrayMap arrayMap=new ArrayMap();
		arrayMap.setMap(chess);
		try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream( new File("map.data")));
			oo.writeObject(arrayMap);
			oo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFileToObj() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream( new File("map.data")));
			ArrayMap arrayMap2=(ArrayMap) ois.readObject();
			int[][] chessarry3=arrayMap2.getMap();
			System.out.println("反序列化后的稀疏数组");
			for (int[] is : chessarry3) {
				for (int data : is) {
					System.out.printf("%d\t",data);
				}
				System.out.println();
			}
			ois.close();
			int[][] chessarray4=new int[chessarry3[0][0]][chessarry3[0][1]];
			for(int i = 1;i < chessarry3.length;i++){   
				int a=chessarry3[i][0];
				int b=chessarry3[i][1];
				int c=chessarry3[i][2];
				chessarray4[a][b]=c;
			}
			System.out.println("恢复的棋盘");
			for (int[] is : chessarray4) {
				for (int data : is) {
					System.out.printf("%d\t",data);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
