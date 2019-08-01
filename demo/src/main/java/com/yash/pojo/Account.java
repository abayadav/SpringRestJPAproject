package com.yash.pojo;


import java.io.Serializable; import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name="account")
@XmlRootElement
public class Account implements Serializable{
	


	private static final long serialVersionUID = 1L;

		@Id
		/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
		@Column(name="acc_no")
		@NotNull(message="Id shoul not be null")
		int accNo;
		
	
		@Column(name="acc_name")
		@Size(max=10,min=5,message="name should be greater than 5 and less than 10")
		String accName;
		
		
		@Column(name="mob")
		int mobNo;
		
 	    @Column(name="bal")
		int balance;
 	    
 	   @Column(name="branch")
	    String branch;
 	    
 	    public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}


 	    
 	    public int getAccNo() {
 			return accNo;
 		}

 		public void setAccNo(int accNo) {
 			this.accNo = accNo;
 		}

 		public String getAccName() {
 			return accName;
 		}

 		public void setAccName(String accName) {
 			this.accName = accName;
 		}

 		public int getMobNo() {
 			return mobNo;
 		}

 		public void setMobNo(int mobNo) {
 			this.mobNo = mobNo;
 		}

 		public int getBalance() {
 			return balance;
 		}

 		public void setBalance(int balance) {
 			this.balance = balance;
 		}

		@Override
		public String toString() {
			return "Account [accNo=" + accNo + ", accName=" + accName + ", mobNo=" + mobNo + ", balance=" + balance
					+ ", branch=" + branch + "]";
		}
 		

	
	}
