
public class CallMeTest {
	public static void main(String[] args){
		EventNotify ren=new EventNotify();
		CallMe a=new CallMe("a sample test");
		CallMe b=new CallMe("b sample test");
		CallMe c=new CallMe("c sample test");
		
		//register
		ren.register(a);
		ren.register(b);
		ren.register(c);
		
		//doWork
		ren.doWork();
	}
}
