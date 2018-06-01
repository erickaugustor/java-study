package study.interfaces;

public class DeskPhone implements ITelephone {
   private int myNumber;
   private boolean isisRinging;

   public DeskPhone(int myNumber) {
       this.myNumber = myNumber;
   }

    @Override
    public void powerOne() {
        System.out.println("No action taken");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now isRinging " + phoneNumber);
    }

    @Override
    public void answer() {
        if(isisRinging){
            System.out.println("Answering the desk");
            isisRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber) {
            isisRinging = true;
            System.out.println("Ring, ring");
        } else {
            isisRinging = false;
        }
        return isisRinging;
    }

    @Override
    public boolean isRinging() {
        return isisRinging;
    }
}
