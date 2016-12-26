package p332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class V1 {
	public static List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if (tickets.length < 1)
            return ans;
        Map<String, PriorityQueue<String>> myMap = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if(!myMap.containsKey(tickets[i][0])) 
            	myMap.put(tickets[i][0], new PriorityQueue<String>());
            myMap.get(tickets[i][0]).add(tickets[i][1]);
        }

        String now = "JFK";
        Stack<String> s = new Stack<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!myMap.containsKey(now) || myMap.get(now).isEmpty()) {
                s.push(now);
                now = ans.remove(ans.size()-1);
            }
            ans.add(now);
            now = myMap.get(now).poll();
        }
        ans.add(now);
        while(!s.isEmpty()) ans.add(s.pop());
        return ans;
    }
	
	/**
	 * ["JFK","ATL","JFK","SFO","ATL","SFO"]
	 * ["JFK","SFO","ATL","JFK","ATL","SFO"]
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] arr = {
				{"JFK","SFO"},
				{"JFK","ATL"},
				{"SFO","ATL"},
				{"ATL","JFK"},
				{"ATL","SFO"}
		};
		
		String[][] arr1 = {
				{"JFK","KUL"},
				{"JFK","NRT"},
				{"NRT","JFK"},
		};
		
		V1 v = new V1();
		List<String> res = v.findItinerary(arr1);
		System.out.println(Arrays.toString(res.toArray()));
	}
}
