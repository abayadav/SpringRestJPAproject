package com.yash.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pojo.Account;
import com.yash.repo.AccountDao;


@Service
public class AccountService {

	@Autowired
	private AccountDao accDao;
   
	public int save(Account acc){
		return accDao.save(acc);
		
	}
	
	public List<Account> getAll(){
		
		return accDao.getAllCategry();
		
	}
	
    public Account getAcountById(int acc_no){
		
		return accDao.getAccountById(acc_no);
		
	}	
	
    
 public int updateBalById(Account acc){
		
		return accDao.updateAccountBal(acc);
	}

public int deleteAccount(Account acc) {
	
	return accDao.deleteAccount(acc);
}	
}
