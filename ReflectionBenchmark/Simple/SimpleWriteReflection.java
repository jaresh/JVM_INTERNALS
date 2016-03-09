import java.lang.reflect.Field;

class TestObject
{
	public int testInt = 0;
}

public class SimpleWriteReflection 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
    		
    	Object Test1 = Class.forName("TestObject").newInstance();
        Field field;
        int a;
        
        for(int i=0; i<=5000000; i++){
            field = Test1.getClass().getField("testInt");
            field.setInt(Test1,5);
        }

    }
}
