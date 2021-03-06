package Chapter14;

class WithdrawThread extends Thread {
	Account account;
	int money;
	boolean flag = true;

	public WithdrawThread(String name, Account account, int money) {
		super(name);
		this.account = account;
		this.money = money;
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 6 || flag; i++) {
			int balance = account.withdraw(money);
			if (balance <= money) {
				flag = false;
			}
		}
	}

}

public class Account {
	protected int balance;

	public Account(int balance) {
		this.balance = balance;
	}

	public int withdraw(int money) {
		String threadName = Thread.currentThread().getName();
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
			System.out.println(threadName + "��� : �ܾ�: " + balance);
		} else {
			System.out.println(threadName + ": �ܾ׺��� ��ݺҰ�");
		}
		return balance;
	}

	public int deposit(int money) {
		return balance += money;
	}

	public static void main(String[] args) {
		Account account = new Account(5000);
		WithdrawThread iBanking = new WithdrawThread("���ͳݹ�ŷ", account, 1000);
		WithdrawThread mBanking = new WithdrawThread("����Ϲ�ŷ", account, 1000);
		iBanking.start();
		mBanking.start();
	}

}
