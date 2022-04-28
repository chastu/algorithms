package com.atgugu.algorithms;

/**
 * 稀疏数组
 */
public class SparesArry {
    public static void main(String[] args) {
        //创建一个二维数组
        //1.表示黑子2.表示白子0.表示没有棋子
        int chessArr[][] = new int[11][11];
        //棋盘的(0,1)为黑子,(1,3)为白,(3,5)为白
        chessArr[0][1] = 2;
        chessArr[1][3] = 1;
        chessArr[3][5] = 1;

        //便利输出棋子
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        int count = 0;
        //找到有效数值
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] > 0) {
                    count++;
                }
            }
        }
        //压缩数据 第一行 数组大小 有效值 后面n行 坐标 值
        int spareArr[][] = new int[count + 1][3];
        spareArr[0][0] = chessArr.length;
        spareArr[0][1] = chessArr[0].length;
        spareArr[0][2] = count;

        // c 表示当前在数组的第几行
        int c = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                //稀疏数组
                if (chessArr[i][j] > 0) {
                    c++;
                    spareArr[c][0] = i;
                    spareArr[c][1] = j;
                    spareArr[c][2] = chessArr[i][j];
                }
            }
        }

        //便利得到的稀疏数组
        for (int[] ints : spareArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        //数组还原
        int restore[][] = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i <= spareArr[0][2]; i++) {
            for (int j = 1; j <= 3; j++) {
                restore[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
            }
        }

        //打印数组
        for (int[] ints : restore) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
