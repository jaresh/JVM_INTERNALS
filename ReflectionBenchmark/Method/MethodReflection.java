import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestObject
{
    public int Calculate(int a, int b){ return a+b; }
}

public class MethodReflection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
            
        Object Test1 = Class.forName("TestObject").newInstance();
        Method method;
        
        for(int i=0; i<=5000000; i++){
        	method = Test1.getClass().getMethod("Calculate", int.class, int.class);
            method.invoke(Test1, 2, 2);
        }

    }
}