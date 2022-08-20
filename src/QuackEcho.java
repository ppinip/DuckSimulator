public class QuackEcho implements Quackable{

    private Quackable duck;

    public QuackEcho (Quackable duck) { //รับพารามิเตอร์เป็น quackable เพราะต้องเรียก method quack()
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack(); // ร้องปกติ

        System.out.println("Echo :"); //มีเสียง echo
        duck.quack();

    }
}
