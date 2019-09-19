package com.yash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pojo.Account;
import com.yash.sevice.AccountService;



@RestController
@RequestMapping(value="/bank")
public class AccountController {

	@Autowired
	private AccountService accountService;

	
	@PostMapping(value="/save",consumes={"application/xml","application/json"})
    public ResponseEntity<?> save(@RequestBody @Valid Account acc,BindingResult result){

		
		
		if(result.hasErrors()){
			
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.BAD_GATEWAY);
		}
		
		int a=accountService.save(acc);
	
		return new ResponseEntity<Integer>(HttpStatus.CREATED);

	}

	@GetMapping(value="/getAccount/{id}", produces={"application/xml","application/json"})
    public Account getAccountById(@PathVariable("id") int id){
		
				return accountService.getAcountById(id);
		
	}
	
	
	@GetMapping(value="/getAllAccount", produces={"application/json"})
	public List<Account> getAll(){

		return accountService.getAll();
	}
	
	
	@PutMapping(value="/update", produces={"application/xml","application/json"})
	public int update(@RequestBody Account acc){

		return accountService.updateBalById(acc);
	}
	
	@DeleteMapping(value="/delete/{accNo}", produces={"application/xml","application/json"})
	public int delete(@PathVariable("accNo") int accNo){

		Account acc=accountService.getAcountById(accNo);
		System.out.println(acc);
		if(acc==null){
		   return 0;
		}else{
			return accountService.deleteAccount(acc);
		}
	}
	
	@PatchMapping(value="/updateName/{id}", produces={"application/xml","application/json"},consumes={"application/xml","application/json"})
	public int updateName(@RequestBody Account acc,@PathVariable ("id") Integer id){

		System.out.println("In dfdffvgfv");
		return accountService.updateByName(acc, id);
	}
	
	
	
	
}
