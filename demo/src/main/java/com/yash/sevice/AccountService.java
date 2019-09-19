package com.yash.sevice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pojo.Account;
import com.yash.repo.AccountDao;


@Service
public class AccountService {

	@Autowired
	private AccountDao accDao;
   
	

	public AccountDao getAccDao() {
		return accDao;
	}

	public void setAccDao(AccountDao accDao) {
		System.out.println("In Setter *****************************************************");
		this.accDao = accDao;
	}

	public int save(Account acc){
		return accDao.save(acc);
		
	}
	
	public List<Account> getAll(){
		
		return accDao.getAllCategry();
		
	}
	
    public Account getAcountById(int acc_no){
		
		return accDao.getAccountById(acc_no);
		
	}	
	
  @Transactional  
 public int updateBalById(Account acc){
		
		return accDao.updateAccountBal(acc);
	}

public int deleteAccount(Account acc) {
	
	return accDao.deleteAccount(acc);
}	

@Transactional
public int updateByName(Account acc,Integer id){
	
	return accDao.updateAccName(acc,id);
}
}
