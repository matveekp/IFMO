package multithreading.synchronize.bank;

public class Transaction implements Runnable {

    private Account src;
    private Account dst;
    private int money;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // перевод с src на dst
        if (src.getId() < dst.getId()) {

            synchronized (src) {
                synchronized (dst) {

                    src.setMoney(src.getMoney() - money);
                    dst.setMoney(dst.getMoney() + money);


                }
            }


        } else {
            synchronized (dst) {
                synchronized (src) {
                    src.setMoney(src.getMoney() - money);
                    dst.setMoney(dst.getMoney() + money);
                }
            }
        }
    }
}
