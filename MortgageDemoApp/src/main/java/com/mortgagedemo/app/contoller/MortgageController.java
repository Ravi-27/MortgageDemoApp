package com.mortgagedemo.app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgagedemo.app.exceptionhandler.APIException;
import com.mortgagedemo.app.model.Mortgage;
import com.mortgagedemo.app.repository.MortgageDynamicArray;
import com.mortgagedemo.app.service.MortgageService;
import com.mortgagedemo.app.utility.DateUtils;

@RestController
@RequestMapping("/mortgage")
public class MortgageController {

	@Autowired
	private MortgageService mortgageService;

	@PutMapping("/mortgageApplication")
	public ResponseEntity<Mortgage> insertMortgageApplication(@RequestBody Mortgage mortgage) {

		mortgage.setCreatedDate(DateUtils.getTodaysDate());
		if (!mortgageService
				.isAlreadyPresentInMortgageDynamicArray(mortgage)
				&& mortgage.getOfferDate() != null && DateUtils.isOfferDateIsBeforeSixMonths(mortgage.getOfferDate())) {

			mortgage = mortgageService.createMortgageApplication(mortgage);
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/getAllMortgageApplication/{sortBy}")
	public ResponseEntity<Mortgage[]> getAllMortgageApplication(@PathVariable String sortBy) {

		 MortgageDynamicArray mortgageDynamicArray = new MortgageDynamicArray();

		mortgageDynamicArray = sortBy != null && sortBy.equalsIgnoreCase("sortByOfferDate")
				? mortgageService.sortByOfferDate(/* mortgageDynamicArray */)
				: mortgageService.sortByCreatedDate(/* mortgageDynamicArray */);

		if (mortgageDynamicArray.array[0]!=null)
			return new ResponseEntity<Mortgage[]>(mortgageDynamicArray.array, HttpStatus.OK);
		else
			throw new APIException("No Mortgage Applications Present", HttpStatus.NOT_FOUND);
	}

}
