import java.lang.reflect.Field;

class TestObject
{
	public String testString = "Hello!";
}

public class ReferenceReadReflection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
    		
    	Object Test1 = Class.forName("TestObject").newInstance();
        Field field = Test1.getClass().getField("testString");
        String a;
        
        for(int i=0; i<=500000000; i++){
            a = (String)field.get(Test1);
        }

    }
}