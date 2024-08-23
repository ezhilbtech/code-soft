package codsoft_task_1;
class Bank {
	    private double balance;
	    public Bank(double IB) {
	        balance = IB;
	    }
	 public double getBalance() {
	        return balance;
	    }
	    public void deposit(double amount) {
	        balance = balance + amount;
	    }
	public boolean withdraw(double amount) {
	        if (amount <= balance) {
	               balance -= amount;
	            return true;
	        } else {
	             return false;
	        }
	    }
	}
	