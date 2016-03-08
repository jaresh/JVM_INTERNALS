class TestObject
{
	public int testInt = 0;
}

public class SimpleWriteNoReflection
{
    public static void main(String[] args) {
    		
    	TestObject Test1 = new TestObject();
    		
    	for(int i=0; i<=500000000; i++){
    		Test1.testInt = 5;
    	}

    }
}
