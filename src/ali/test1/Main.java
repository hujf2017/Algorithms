package ali.test1;

import java.util.Scanner;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/4/1218:53
 * @description:
 *
 * // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
 * import java.util.Scanner;
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner in = new Scanner(System.in);
 *         while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
 *             int a = in.nextInt();
 *             int b = in.nextInt();
 *             System.out.println(a + b);
 *         }
 *     }
 * }
 *
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int ans = 0, x;
 *         for(int i = 0; i < n; i++){
 *             for(int j = 0; j < n; j++){
 *                 x = sc.nextInt();
 *                 ans += x;
 *             }
 *         }
 *         System.out.println(ans);
 *     }
 * }
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a1[][] = new int[][]{{0,1},{1,1}};
        int local =2;
        for(int i=1;i<n;i++){
            int local2=local*2;
            int a2[][] = new int[local2][local2];
            for(int j=0;j<local;j++){
                for(int k=0;k<local;k++){
                    a2[j][k]=0;
                }
            }

            for(int j=0;j<local;j++){
                for(int k=local;k<local2;k++){
                    a2[j][k]=a1[j][k-local];
                }
            }

            for(int j=local;j<local2;j++){
                for(int k=0;k<local;k++){
                    a2[j][k] = a1[j-local][k];
                }
            }

            for(int j=local;j<local2;j++){
                for(int k=local;k<local2;k++){
                    a2[j][k] = a1[j-local][k-local];
                }
            }

            a1 =a2;
            local=local2;
        }

        for(int i=0;i<a1.length;i++){
            for(int j=0;j<a1.length;j++){
                if(j==a1.length-1){
                    System.out.println(a1[i][j]);
                }else {
                    System.out.print(a1[i][j] + " ");
                }
            }
        }
    }
}
