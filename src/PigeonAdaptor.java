public class PigeonAdaptor implements Quackable{

    private Pigeon pigeon;
    public  PigeonAdaptor (Pigeon pigeon){ //ต้องมี Pigeon อยู่ใน Adaptor เพื่อจะเรียก coo()
        this.pigeon = pigeon;
    }
    @Override
    public void quack() {
        pigeon.coo();
        pigeon.coo();
    }
}
