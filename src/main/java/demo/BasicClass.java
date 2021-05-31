package demo;

/**
 * @author: zyf
 * @date: 2021/2/27 21:45
 * @description:
 */
public class BasicClass implements BasicInterface {
    private String value;

    @Override
    public void publicMethod() {
        System.out.println("publicMethod!");
    }


    private void privateMethod() {
        System.out.println("privateMethod!" + value);
    }
}
