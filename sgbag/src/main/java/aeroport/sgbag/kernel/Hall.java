package aeroport.sgbag.kernel;

import java.util.*;

import lombok.*;

@AllArgsConstructor
public class Hall {

	@Getter
	@Setter
	private Circuit circuit;

	@Getter
	@Setter
	private ArrayList<Bagage>  bagagesList;
	
	@Getter
	private ArrayList<FileBagage> fileBagageList;
	
	public Hall() {
		bagagesList = new ArrayList<Bagage>();
		fileBagageList = new ArrayList<FileBagage>();
	}
	
	public void init() {
		BagageFactory.getBagageFactory().setCircuit(circuit);
	}
	
	public boolean update() {
		boolean allUpdated = true;
		for (int i = 0; i < fileBagageList.size(); i++) {
			if(!fileBagageList.get(i).update()) {
				allUpdated = false;
			}
		}
		if(!circuit.update()) {
			allUpdated = false;
		}
		return allUpdated;
	}
	
	public void addFileBagage(FileBagage file) {
		fileBagageList.add(file);
	}
	
	public void removeFileBagage(FileBagage file) {
		fileBagageList.remove(file);
	}

}