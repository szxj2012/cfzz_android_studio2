import java.util.ArrayList;
import java.util.List;


public class EventNotify {
	private List<CallMe> callMes=new ArrayList<CallMe>();
	
	public void register(CallMe callMe){
		callMes.add(callMe);
	}
	
	public void doWork(){
		for(CallMe callMe:callMes){
			callMe.interestingEvent("sample event");
		}
	}
}
