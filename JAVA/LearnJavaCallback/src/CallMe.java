/*
 * ʵ��interestingEvent�ӿڣ��¼�������
 */
public class CallMe implements InterestingEvent{
	private String name;
	public CallMe(String str) {
		// TODO Auto-generated constructor stub
		System.out.print("CallMe\n");
		this.name=str;
	}
	
	@Override
	public void interestingEvent(String event) {
		// TODO Auto-generated method stub
		System.out.print(name+"--cube-- interestingEvent��"+event+"\n");
	}
   
}
