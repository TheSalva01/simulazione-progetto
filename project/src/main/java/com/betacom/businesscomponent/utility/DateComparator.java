package com.betacom.businesscomponent.utility;

import java.util.Comparator;

import com.betacom.businesscomponent.model.Corso;

public class DateComparator implements Comparator<Corso>{

	@Override
	public int compare(Corso o1, Corso o2) {
		return (int) (o2.getDataInizioCorso().getTime() - o1.getDataInizioCorso().getTime());
	}

	
}
