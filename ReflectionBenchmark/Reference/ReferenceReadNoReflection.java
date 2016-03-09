class TestObject
{
	public String testString = "Hello!";
}

public class ReferenceReadNoReflection
{
    public static void main(String[] args) {
    		
    	TestObject Test1 = new TestObject();
    		
    	String a;
    		
    	for(int i=0; i<=5000000; i++){
    		a = Test1.testString;
    	}

    }
}
