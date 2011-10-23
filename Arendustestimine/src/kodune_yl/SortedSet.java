package kodune_yl;

import java.util.ArrayList;
import java.util.List;

public class SortedSet {
	
	private final int MAXSIZE = 100;
	private Object[] sortedSet = new Object[MAXSIZE];
	private int lastIndex = 0;

	
	public void add(Object o){
		  if(!this.contains(o) && lastIndex < MAXSIZE) {
				sortedSet[lastIndex] = o;
				lastIndex++;
		  }
	}

	
	public void remove(Object o){
		for(int i = 0; i < lastIndex; i++){
			if(sortedSet[i].equals(o))
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
	
	public boolean containsAll(List<Object> list){
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
	
	public boolean removeAll(List<Object> list){
		for(Object lo : list){
			for(int i=0;i<lastIndex;i++){
				if(lo.equals(sortedSet[i])){
					sortedSet[i]=null;
				}
			}
		}
		updateSet();
		return true;
	}
	
	public boolean retainAll(List<Object> list){
		SortedSet tmp = new SortedSet();
		for(Object lo : list){
			for(int i=0;i<lastIndex;i++){
				if(lo.equals(sortedSet[i])){
					tmp.add(sortedSet[i]);
				}
			}
		}		
		this.sortedSet = tmp.sortedSet;
		this.lastIndex = tmp.lastIndex;
		return true;
	}
	
	public int size(){		
		return lastIndex;
	}
	
	public List<Object> asList(){
		List<Object> list = new ArrayList<Object>();
		for(Object o : sortedSet){
			if(o!=null)
				list.add(o);
		}
		return list;
	}
	
	
	private void updateSet(){
		Object[] tmp = new Object[MAXSIZE];
		int k = 0;
		for(int i=0;i<lastIndex;i++){
			if(sortedSet[i]!=null){
				tmp[k] = sortedSet[i];
				k++;
			}
		}
		sortedSet = tmp;
		lastIndex = k;
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
