package week1.day1;

public class ChristmasTree {
    public static void main(String[] args){
        int base=7;
        for(int i=1;i<=base;i+=2){
            for(int j =0;j<(base-i)/2;j++){
                System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
}
}
