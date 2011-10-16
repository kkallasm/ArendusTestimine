package kodune_yl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedSet {
	
//	private int total = 0;
	private Object[] sortedSet = new Object[100];
	private int lastIndex = 0;

	public SortedSet(){
		
	}
	
	 public void add(Object o) {
		  if(!this.contains(o) && this.lastIndex < sortedSet.length) {
		   sortedSet[lastIndex] = (Integer) o;
		   lastIndex++;
//		   total++;
		  }
		 }
	
	public void remove(Object o){
		for(int i = 0; i < sortedSet.length; i++){
			if(sortedSet[i] == o)
				sortedSet[i] = null;
		}
		//TODO: järgmisi ühe võrra ettepoole liigutada
	}
	
	public boolean contains(Object o){
		for(Object i : sortedSet){
			if(i != null && i.equals(o))
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
		return lastIndex;
	}
	
	public List<Object> asList(){
		return Arrays.asList(sortedSet);
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