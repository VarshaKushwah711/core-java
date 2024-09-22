package Multithreading;

class MyThread extends Thread 
{
    public void run()
    {
        System.out.println("Thread running: " + Thread.currentThread().getName());
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}
public class MyThreadByClass 
{
    public static void main(String[] args) 
    {
        //create multiple instance pf MyThread
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        //start the threads
        thread1.start();
        thread2.start();

        //Main thread continues to run parallel to the created threads
        System.out.println("Main thread finished.");

    }
}

