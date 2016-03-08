import java.lang.reflect.Field;

class TestObject
{
	public int testInt = 0;
}

public class Warmup
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
    		
    	Object Test1 = Class.forName("TestObject").newInstance();
        TestObject Test2 = new TestObject();
        Field field = Test1.getClass().getField("testInt");
        int a;
        
        for(int i=0; i<=500000000; i++){
            field.setInt(Test1,5);
            field.getInt(Test1);
            a = Test2.testInt;
            Test2.testInt = 2;
        }

    }
}
