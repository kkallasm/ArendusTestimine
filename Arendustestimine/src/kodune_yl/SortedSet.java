package kodune_yl;

import java.util.ArrayList;
import java.util.List;

public class SortedSet {
	
	private int total = 0;
	private int[] sortedSet = new int[100];
	private int lastPoint = 0;

	public SortedSet(){
		
	}
	
	public void add(Object o){
		if(this.contains(o)){
			if(this.lastPoint<sortedSet.length){
				sortedSet[lastPoint] = (Integer)o;
				lastPoint++;
				total++;
			}
		}
	}
	
	public void remove(Object o){
		for(int i=0; i<sortedSet.length; i++){
			if(sortedSet[i]==(Integer)o)
				sortedSet[i]=(Integer) null;
		}
	}
	
	public boolean contains(Object o){
		for(Integer i: sortedSet){
			if(i==(Integer)o && i!=null)
				return true;						
		}
		return false;
	}
	
	public boolean containsAll(List list){
		
		return true;
	}
	
	public boolean removeAll(List list){
		
		return true;
	}
	
	public boolean retainAll(List list){
		
		return true;
	}
	
	public int size(){		
		return total;
	}
	
	public List asList(){
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i: sortedSet){
			if(i!=null)
				list.add(i);
		}
		return list;
	}
	
}



/*
Meetodid:

void add(Object o) - lisab elemendi hulka (kui seda seal enne ei olnud)
void remove(Object o) - eemaldab elemendi hulgast
boolean contains(Object o) - ütleb, kas antud element on juba hulgas
boolean containsAll(List list) - ütleb, kas listi kõik elemendid on hulgas
boolean removeAll(List list) - eemaldab hulgast kõik listis olevad elemendid
boolean retainAll(List list) - eemaldab hulgast kõik elemendid, mida listis pole
int size() - tagastab hulga suuruse
List asList() - tagastab hulga elemendid (sisestamise järjekorras)
*/