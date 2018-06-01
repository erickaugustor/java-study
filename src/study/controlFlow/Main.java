package study.controlFlow;

public class Main {

    public static void main(String[] args) {
        int value = 3;
        if(value == 1){
            System.out.println("Value was 1");
        }else if(value == 2){
            System.out.println("Value was 2");
        }else{
            System.out.println("Was not 1 or 2");
        }

        int switchValue = 1;
        switch(switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value");
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }

        String month = "JANUARY";
        switch(month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            default:
                System.out.println("Not sure");
                break;
        }

        int count = 0;
        for(int i = 10; i < 50; i++){
            if(isPrime(i)){
                count++;
                System.out.println("Number "+ i +" is a rime number");
                if(count == 3){
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }

        for(int i = 2; i <= n/2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

}
