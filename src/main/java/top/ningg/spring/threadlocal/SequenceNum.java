package top.ningg.spring.threadlocal;

/**
 * Created by guoning on 15/9/20.
 */
public class SequenceNum {

    // 1. 定义线程本地变量
    ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        // 2. ThreadLocal本质就是变量,调用 get\set方法即可
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNum sequenceNum = new SequenceNum();

        TestClient client1 = new TestClient(sequenceNum);
        TestClient client2 = new TestClient(sequenceNum);
        TestClient client3 = new TestClient(sequenceNum);

        Thread thread1 = new Thread(client1);
        Thread thread2 = new Thread(client2);
        Thread thread3 = new Thread(client3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TestClient implements Runnable {

    // 3. 在ThreadLocal之上,封装定制的类
    private SequenceNum sequenceNum;

    public TestClient(SequenceNum sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public void run() {
        for (int index = 0; index < 5; index++) {
            System.out.println(Thread.currentThread().getName() + " , seqNum is: " + sequenceNum.getNextNum());
        }
    }
}
