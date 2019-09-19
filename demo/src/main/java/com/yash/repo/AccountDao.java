package com.yash.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.pojo.Account;


@Repository
public class AccountDao {
	
	


	@PersistenceContext
	private EntityManager entityManager;

	public int save(Account acc) {

		Account a = new Account();

		a.setAccNo(acc.getAccNo());
		a.setAccName(acc.getAccName());
		a.setMobNo(acc.getMobNo());
		a.setBalance(acc.getBalance());
		a.setBranch(acc.getBranch());

		System.out.println(a);

		entityManager.persist(a);

		return 1;

	}

	public List<Account> getAllCategry() {

		Query q = entityManager.createQuery("Select a from Account a");

		List<Account> accList = (List<Account>) q.getResultList();

		return accList;
	}

	public Account getAccountById(int acc_no) {

		Account acc = entityManager.find(Account.class, acc_no);
		/*
		 * Query q =
		 * entityManager.createQuery("Select a from Account a where a.accNo=:id"
		 * ); q.setParameter("id", acc_no);
		 * 
		 * Account acc=new Account();
		 * 
		 * acc=(Account) q.getSingleResult();
		 */
		return acc;

	}

	public int updateAccountBal(Account acc) {

		entityManager.merge(acc);

		return 1;

	}

	public int deleteAccount(Account acc) {

		 entityManager.remove(acc);
		 
		 return 1;

		
	}
	
	public int updateAccName(Account acc,Integer id){
		
	    System.out.println(acc.getAccName());
		
		entityManager.merge(acc);
		
		return 1;
	}

}
