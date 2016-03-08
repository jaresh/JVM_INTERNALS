import java.lang.reflect.Field;

class TestObject
{
    public String testString = "";
}

public class ReferenceWriteReflection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException {
            
        Object Test1 = Class.forName("TestObject").newInstance();
        Field field = Test1.getClass().getField("testString");
        
        for(int i=0; i<=500000000; i++){
            field.set(Test1, "Hello!");
        }

    }
}
