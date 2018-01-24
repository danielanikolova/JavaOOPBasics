package randomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList ral=new RandomArrayList();

        ral.add("abc");
        ral.add("fff");
        ral.add("ccc");
        ral.add("ooo");
        ral.add("eee");
        ral.add("lll");

        Object object = ral.getRandomElement(ral);

        System.out.println(object);


    }
}
