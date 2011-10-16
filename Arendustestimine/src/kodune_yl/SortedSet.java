package kodune_yl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedSet {
	
	private Object[] sortedSet = new Object[100];
	private int lastIndex = 0;

	public SortedSet(){
		
	}
	
	public void add(Object o){
		  if(!this.contains(o) && this.lastIndex < sortedSet.length) {
				sortedSet[lastIndex] = o;
				lastIndex++;
		  }
	}

	
	public void remove(Object o){
		for(int i = 0; i < sortedSet.length; i++){
			if(sortedSet[i] == o)
				sortedSet[i] = null;
		}

		updateSet();
	}
	
	public boolean contains(Object o){
		for(Object i : sortedSet){
			if(i != null && i.equals(o))
				return true;						
		}
		return false;
	}
	
	public boolean containsAll(List list){
		int listLength = list.size();
		int vastused = 0;
		boolean onOlemas;
		for(Object lo : list){
			onOlemas = false;
			for(Object o: sortedSet){
				if(lo.equals(o))
					onOlemas = true;
			}
			if(onOlemas)
				vastused++;
		}
		return (vastused==listLength);
	}
	
	public boolean removeAll(List list){
		for(Object lo : list){
			for(int i=0;i<sortedSet.length;i++){
				if(lo.equals(sortedSet[i])){
					sortedSet[i]=null;
				}
			}
		}
		updateSet();
		return true;
	}
	
	public boolean retainAll(List list){
		for(Object lo : list){
			for(int i=0;i<sortedSet.length;i++){
				if(!lo.equals(sortedSet[i])){
					sortedSet[i]=null;
				}
			}
		}
		updateSet();
		return true;
	}
	
	public int size(){		
		return lastIndex;
	}
	
	public List<Object> asList(){
		return Arrays.asList(sortedSet);
	}
	
	
	private void updateSet(){
		Object[] tmp = new Object[100];
		int k = 0;
		for(int i=0;i<sortedSet.length;i++){
			if(!sortedSet[i].equals(null))
				tmp[k] = sortedSet[i];
		}
		sortedSet = tmp;
		lastIndex = sortedSet.length - 1;
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
