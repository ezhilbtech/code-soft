package codsoft_task_3;
import java.util.Scanner;
public class SGC{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("--- Student grade Calculator ---");
        System.out.print("Enter the number of subjects : ");
        int s=sc.nextInt();
        int total=0;
        System.out.println("Enter the marks obtained in each subjects: ");
        for(int i=0;i<s;i++){
            int marks=sc.nextInt();
            total=total+marks;
        }
         double AP=(double)total/s;
         String Grade;
         if (AP>=90){
           Grade="S"; 
         }
         else if(AP>=80){
            Grade="A";
         }
         else if(AP>=70){
            Grade="B";
         }
         else if(AP>=60){
            Grade="C";
         }
         else if(AP>=50){
            Grade="D";
         }
         else if(AP>=40){
            Grade="E";
         }
         else{
            Grade="Fail(F)";
         }
         System.out.println("Total marks : "+total);
         System.out.println("Average Percentage : "+AP+"%");
         System.out.println("Grade Scored : "+Grade);

    }
}