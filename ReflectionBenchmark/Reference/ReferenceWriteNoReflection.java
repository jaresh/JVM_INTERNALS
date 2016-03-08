class TestObject
{
	public String testString = "";
}

public class ReferenceWriteNoReflection
{
    public static void main(String[] args) {
    		
    	TestObject Test1 = new TestObject();
    		
    	for(int i=0; i<=500000000; i++){
    		Test1.testString = "Hello!";
    	}

    }
}
