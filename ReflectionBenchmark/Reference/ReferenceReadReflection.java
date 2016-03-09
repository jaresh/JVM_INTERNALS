import java.lang.reflect.Field;

class TestObject
{
	public String testString = "Hello!";
}

public class ReferenceReadReflection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
    		
    	Object Test1 = Class.forName("TestObject").newInstance();
        Field field;
        String a;
        
        for(int i=0; i<=5000000; i++){
            field = Test1.getClass().getField("testString");
            a = (String)field.get(Test1);
        }

    }
}