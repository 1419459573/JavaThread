class Processor implements Runnable{
    Account act;
    Processor(Account act){
        this.act=act;
    }
    @Override
    public void run() {
        act.withdraw(100);
    }

}