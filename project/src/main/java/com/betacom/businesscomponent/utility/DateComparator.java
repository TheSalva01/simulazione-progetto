package com.betacom.businesscomponent.utility;

import java.util.Comparator;

import com.betacom.businesscomponent.model.Corso;

public class DateComparator implements Comparator<Corso>{

	public int compare(Corso o1, Corso o2) {
		return o1.getDataInizioCorso().compareTo(o2.getDataInizioCorso());
	}

	
}
