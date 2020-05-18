package easy.array;

public class BusyStudent {
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int time[] = new int[1001];
		for(int i = 0 ; i<startTime.length; i++) {
			time[startTime[i]]++;
			if(endTime[i] + 1 < time.length) {
				time[endTime[i] + 1]--;
			}
		}
		int busy[] = new int[1001];
		for(int i = 1; i < time.length; i++) {
			busy[i] = busy[i - 1] + time[i]; 
		}
		return busy[queryTime];
	}
	
}
