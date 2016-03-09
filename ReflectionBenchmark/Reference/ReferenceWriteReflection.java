import java.lang.reflect.Field;

class TestObject
{
    public String testString = "";
}

public class ReferenceWriteReflection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
            
        Object Test1 = Class.forName("TestObject").newInstance();
        
    	Field field;

        for(int i=0; i<=5000000; i++){
        	field = Test1.getClass().getField("testString");
            field.set(Test1, "Hello!");
        }

    }
}
