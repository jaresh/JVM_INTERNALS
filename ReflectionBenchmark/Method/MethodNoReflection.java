class TestObject
{
    public int Calculate(int a, int b){ return a+b; }
}

public class MethodNoReflection
{
    public static void main(String[] args){
            
        TestObject Test1 = new TestObject();
        
        for(int i=0; i<=500000000; i++){
            Test1.Calculate(2,2);
        }

    }
}