import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //constants
        final double drink_price=15.50;
        final double student_discount=0.10;
        final double senior_discount=0.05;
        final double tip_rate=0.10;
        //variables
        String customerName;
        int age,numberOfDrinks,serviceRating;
        boolean isStudent;
        double mealPrice;
        double drinksCost,subtotal;
        double discountRate=0.0;
        double tipAmount;
        double finalBill=0.0;
        double wholeAmount=0.0;
        //collect customer information
        System.out.print("enter customer name: ");
        customerName= input.nextLine();
        System.out.print("enter customer age: ");
        age= input.nextInt();
        System.out.print("enter meal price: ");
        mealPrice= input.nextDouble();
        System.out.print("enter number of the drinks: ");
        numberOfDrinks= input.nextInt();
        System.out.print("are you a student(true or false) ");
        isStudent= input.nextBoolean();
        System.out.print("enter service rating(1-5): ");
        serviceRating= input.nextInt();
        //check service rating
        if(serviceRating<1||serviceRating>5){
            System.out.println("error service rating must start from 1 up to 5");
        }else{
            //calculate drinks cost
            drinksCost=numberOfDrinks*drink_price;
            //calculate subtotal
            subtotal=mealPrice+drinksCost;
            //calculating discount
            if(isStudent && age>=60){
                discountRate=student_discount;
            }
            else if(isStudent){
                discountRate=senior_discount;
            }
            else if(age>=60){
                discountRate=senior_discount;
            }
            else {
                discountRate=0.0;
            }
             double discountAmount=subtotal*discountRate;
            //calculate tip
            if (serviceRating >= 4 && serviceRating <= 5) {

                tipAmount=(subtotal-discountAmount)*tip_rate;
            }
            else{
                tipAmount=0.0;
            }
            //calculate final bill
            finalBill=subtotal-discountAmount+tipAmount;
            //type casting
            wholeAmount=(int)finalBill;
            //displaying receipt
            System.out.println("\n====== SMART Restrount=======");
            System.out.println("customer:" + customerName);
            System.out.println("meal: $"+mealPrice);
            System.out.println("drinks:$"+drinksCost);
            System.out.println("discount: $"+discountAmount);
            System.out.println("Tip:$"+tipAmount);
            System.out.println("Final bill: $" + finalBill);
            System.out.println("whole amount: $"+wholeAmount);

        }
        //close scanner
        input.close();

    }
}