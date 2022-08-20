
public class GooseAdaptor implements Quackable{ //ต้องมี interface เดียวกันกับ client ที่ต้องการ
    private Goose goose;

    public GooseAdaptor (Goose goose) //ต้องมี Goose อยู่ใน Adaptor เพื่อจะเรียก honk()
    {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
        goose.honk();
    }
}
