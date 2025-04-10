package SBI;

public class Employee {
	private int account;
	private String name;
	private long phno;
	private float balance;
	public Employee(int account, String name, long phno, float balance) {
		super();
		this.account = account;
		this.name = name;
		this.phno = phno;
		this.balance = balance;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Employee [account=" + account + ", name=" + name + ", phno=" + phno + ", balance=" + balance + "]";
	}
	

}
