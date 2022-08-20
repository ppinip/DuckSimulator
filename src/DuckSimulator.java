
public class DuckSimulator { //เป็น client

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate(new EchoCountingDuckFactory()); //อยู่ที่ว่าเราจะเรียก duckFactory แบบไหน
    }
                  //รับ duckFactory เข้ามาแล้ว ไม่จำเป็นต้อง new obj แล้ว ให้ duckFactory create ให้เราแทน
    void simulate(AbstractDuckFactory duckFactory) {           //เป็นการ decorate action เพิ่มการนับจำนวน Quack ของแต่ละ Duck
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdaptor(new Goose()); //ใส่ goose ในฝูงได้ เพราะเป็น Quackable เหมือนกัน ใน GooseAdaptor implements Quackable แล้ว
        Quackable pigeon = new PigeonAdaptor(new Pigeon());
        Quackable mallardDuck1 = new QuackCounter(new QuackEcho(new MallardDuck())); // มีผลลัพธ์เหมือนกัน
        Quackable mallardDuck2 = new QuackEcho(new QuackCounter(new MallardDuck())); // มีผลลัพธ์เหมือนกัน
        /*
        Composite: Flock มีประเภทเดียวกันกับ Quackable สามารถใส่ Quackable เข้าไปได้หลายอัน
        ทำเป็นฝูงเป็ดใหญ่ รวมถึงข้างในมีฝูงเป็ดย่อยได้ด้วย
        simulate อันเดียว แต่จัดการได้ทั้งฝูง
         */
        //ฝูงเป็ดใหญ่
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(goose);
        flockOfDucks.add(pigeon);
        flockOfDucks.add(mallardDuck1);
        flockOfDucks.add(mallardDuck2);

        //ฝูงเป็ดย่อย
        Flock flockOfRubberDucks = new Flock();
        flockOfRubberDucks.add(rubberDuck);
        flockOfRubberDucks.add( duckFactory.createRubberDuck());
        flockOfRubberDucks.add( duckFactory.createRubberDuck());

        //เพิ่มฝูงย่อยเข้าไปในฝูงใหญ่
        flockOfDucks.add(flockOfRubberDucks);

        System.out.println("\nDuck Simulator");

        simulate(flockOfDucks);// simulate ทั้งฝูงได้เลยเพราะใน flock วน loop quack ให้แล้ว

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(goose); //ส่ง goose ได้เพราะ GooseAdaptor เป็น Quackable แล้ว

        System.out.println("Number of quacks is " +
                QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable duck) { // ใช้ interface Quackable
        duck.quack();
    }
}
