package aeroport.sgbag.kernel;

import java.util.*;
import lombok.*;

public abstract class ElementCircuit extends KernelObject {
	protected static String kObjName = "Élement de circuit";

	@Getter
	protected LinkedList<Chariot> listeChariot;
	
	@Getter
	@Setter
	private Circuit parent;

	public abstract Boolean update();

	public ElementCircuit() {
		super();
		listeChariot = new LinkedList<Chariot>();
	}
	
	public ElementCircuit(Circuit parent) {
		this();
		this.parent = parent;
	}

	public Boolean registerChariot(Chariot chariot) {
		int oldSize = listeChariot.size();

		listeChariot.addFirst(chariot);

		return (listeChariot.size() == oldSize + 1);
	}

	public Boolean unregisterChariot() {
		int oldSize = listeChariot.size();
		
		listeChariot.getLast().setPosition(0); //Et oui

		listeChariot.removeLast();

		return (listeChariot.size() == oldSize - 1);
	}

	public Boolean hasChariot() {
		return (listeChariot.size() > 0);
	}
	
	@Override
	public String toString() {
		return "<ElementCircuit id=" + super.getId() + "/>";
	}
	
	

}