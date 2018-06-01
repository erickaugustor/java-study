package study.interfaces;

public class Main {
    public static void main(String[] args) {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(12345);
        timsPhone.powerOne();
        timsPhone.callPhone(12345);
        timsPhone.answer();

        timsPhone = new MobilePhone(234545);
        timsPhone.callPhone(234545);
        timsPhone.answer();
    }
}
