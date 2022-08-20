
import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable{
    private List<Quackable> quackers; //เก็บเป็น list ของ Quackable (เก็บทั้งฝูง)

    public Flock () {
        quackers = new ArrayList<>();
    } //สร้างฝูงขึ้นมา

    public void add(Quackable duck){ //เพิ่ม duck เข้ามาใน flock
        quackers.add(duck);
    } //เพิ่มเป็ดในฝูง

    @Override
    public void quack() {
        for (Quackable duck: quackers){ //วน loop ให้เป็ดทุกตัว quack
            if (quackers.get(0) == duck){ //ถ้าเป็นจ่าฝูงตัวแรก quack 3 รอบ
                duck.quack();
                duck.quack();
                duck.quack();
            } else { //ตัวอื่นๆ quack รอบเดียว
                duck.quack();
            }

        }
    }
}
