class TestObject
{
	public int testInt = 0;
}

public class SimpleReadNoReflection
{
    public static void main(String[] args) {
    		
    	TestObject Test1 = new TestObject();
    		
    	int a;
    		
    	for(int i=0; i<=500000000; i++){
    		a = Test1.testInt;
    	}

    }
}
