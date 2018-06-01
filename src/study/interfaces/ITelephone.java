package study.interfaces;

public interface ITelephone {
    void powerOne();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
