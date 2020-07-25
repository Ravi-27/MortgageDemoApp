package com.mortgagedemo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgagedemo.app.model.Mortgage;
import com.mortgagedemo.app.repository.MortgageDynamicArray;
import com.mortgagedemo.app.utility.DateUtils;

@Service
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	private MortgageDynamicArray mortgageDynamicArray;
	
	@Override
	public Mortgage createMortgageApplication(Mortgage mortgage) {
		return mortgageDynamicArray.add(mortgage);
	}
	
	@Override
	public MortgageDynamicArray sortByOfferDate(/* MortgageDynamicArray mortgageDynamicArray */) {
		MortgageDynamicArray sortedDynamicArray = new MortgageDynamicArray();
		Mortgage tempMortgage;
		for (int i = 0; i < mortgageDynamicArray.size; i++) {
			for (int j = i + 1; j < mortgageDynamicArray.size; j++) {
				// if(mortgageDynamicArray.array[i]!=null &&
				// mortgageDynamicArray.array[j]!=null)
				if (mortgageDynamicArray.array[i] != null && mortgageDynamicArray.array[j] != null
						&& (DateUtils.convertDateForComparison(mortgageDynamicArray.array[i].getOfferDate()).before(
								DateUtils.convertDateForComparison(mortgageDynamicArray.array[j].getOfferDate())))) {
					tempMortgage = mortgageDynamicArray.array[i];
					mortgageDynamicArray.array[i] = mortgageDynamicArray.array[j];
					mortgageDynamicArray.array[j] = tempMortgage;
				}
			}
		}
		System.out.println("Array elements in descending order by Offer Date:");
		// accessing element of the array
		for (int i = 0; i < mortgageDynamicArray.size; i++) {
			System.out.println("mortgageDynamicArray.array[" + i + "]" + mortgageDynamicArray.array[i] + " ");
			if (mortgageDynamicArray.array[i] != null)
				sortedDynamicArray.add(mortgageDynamicArray.array[i]);
		}
		return sortedDynamicArray;
	}

	@Override
	public MortgageDynamicArray sortByCreatedDate(/* MortgageDynamicArray mortgageDynamicArray */) {
		MortgageDynamicArray sortedDynamicArray = new MortgageDynamicArray();
		Mortgage tempMortgage;
		for (int i = 0; i < mortgageDynamicArray.size; i++) {
			for (int j = i + 1; j < mortgageDynamicArray.size; j++) {
				// if(mortgageDynamicArray.array[i]!=null &&
				// mortgageDynamicArray.array[j]!=null)
				if (mortgageDynamicArray.array[i] != null && mortgageDynamicArray.array[j] != null
						&& (DateUtils.convertDateForComparison(mortgageDynamicArray.array[i].getCreatedDate()).before(
								DateUtils.convertDateForComparison(mortgageDynamicArray.array[j].getCreatedDate())))) {
					tempMortgage = mortgageDynamicArray.array[i];
					mortgageDynamicArray.array[i] = mortgageDynamicArray.array[j];
					mortgageDynamicArray.array[j] = tempMortgage;
				}
			}
		}
		System.out.println("Array elements in descending order by Created Date:");
		// accessing element of the array
		for (int i = 0; i < mortgageDynamicArray.size; i++) {
			System.out.println("mortgageDynamicArray.array[" + i + "]" + mortgageDynamicArray.array[i] + " ");
			if (mortgageDynamicArray.array[i] != null)
				sortedDynamicArray.add(mortgageDynamicArray.array[i]);
		}
		return sortedDynamicArray; 
	}

	@Override
	public boolean isAlreadyPresentInMortgageDynamicArray(Mortgage mortgage) {
		return mortgageDynamicArray.isAlreadyPresentInMortgageDynamicArray(mortgageDynamicArray,mortgage);
	}

}
