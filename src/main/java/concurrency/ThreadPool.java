package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
  int capacity = 10;
  private BlockingQueue<Thread> queue = new LinkedBlockingQueue<>(capacity);

  public synchronized void settask(Task e) {
    try {
      queue.put(e);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
  }

  public synchronized Task gettask() {
    Task e = null;
    try {
      e = (Task) queue.take();
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    return e;
  }

}

class Task extends Thread {

  @Override
  public void run() {
    System.out.println("in task");
  }
}
