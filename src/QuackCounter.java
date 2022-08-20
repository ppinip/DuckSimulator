
public class QuackCounter implements Quackable{

    private Quackable duck; //เก็บ Quackable อยู่ด้านใน
    private static int numberOfQuacks; //เก็บจำนวน Quack เป็ดทุกตัว

    public QuackCounter (Quackable duck){ //รับพารามิเตอร์เป็น quackable เพราะต้องเรียก method quack()
        this.duck = duck;    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++; //เป็น decorator behavior ในการนับจำนวน quack เพิ่มเข้ามา
    }

    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }
}
