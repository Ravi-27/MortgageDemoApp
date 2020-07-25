package com.mortgagedemo.app.service;

import com.mortgagedemo.app.model.Mortgage;
import com.mortgagedemo.app.repository.MortgageDynamicArray;

public interface MortgageService {

	MortgageDynamicArray sortByOfferDate();

	MortgageDynamicArray sortByCreatedDate();

	Mortgage createMortgageApplication(Mortgage mortgage);

	boolean isAlreadyPresentInMortgageDynamicArray(Mortgage mortgage);

}
