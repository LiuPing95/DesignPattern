package creation.factoryMethod;


public class HumanFactory extends AbstractHumanFactory {

    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        //如果有多个人种，都去实现Human接口即可。
        BlackHuman human = humanFactory.createHuman(BlackHuman.class);
        human.getColor();
        human.talk();
        human.test1();
        // 接口中的静态方法也只能根据类名来调用
        Human.test2();
    }

    /**
     * 简单工厂方法模式：如果模块只需要一个工厂，那么不需要定义父类或接口，把方法写成静态的
     * 多个工厂方法模式：在复杂的业务场景中，每一个工厂负责某一类对象的创建。
     * */
    public <T extends Human> T createHuman(Class<T> c) {
        T t = null;
        if (c != null) {
            try {
                t = (T) Class.forName(c.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

}