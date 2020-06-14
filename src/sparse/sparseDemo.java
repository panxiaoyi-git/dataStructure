package sparse;

import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.Array;

public class sparseDemo {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //1,2表示黑子和白子
        int chessArr[][] = new int[11][11];
        chessArr[1][1]=1;
        chessArr[2][3]=2;
        chessArr[4][3]=1;

        //输出原始的二维数组
        for (int[] row:chessArr) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
           System.out.println();
        }

        //将二维数组转成稀疏数组
        //先拿到非0的个数，对源数组进行遍历
        int sum= 0 ;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j]!=0)
                    sum++;
            }
        }
        System.out.println(sum);

        //创建对应的稀疏数组
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0存放到sparse数组中
         int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chessArr[i][j]!=0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //查看稀疏数组
        System.out.println("这是稀疏数组");
        for (int[] row:sparseArr){
            for (int i:row){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
        System.out.println("稀疏转原数组");

        int[][] chessArr1=new int[sparseArr[0][0]][sparseArr[0][1]];

        //将值加进数组中
        for (int i = 1; i <sparseArr.length-1; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        // 输出恢复后的二维数组

        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
