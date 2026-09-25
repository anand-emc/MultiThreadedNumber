import java.util.Random;

class NumberGenerator extends Thread
{
    SharedData data;

    NumberGenerator(SharedData data)
    {
        this.data = data;
    }

    public void run()
    {
        Random r = new Random();

        while (true)
        {
            int n = r.nextInt(100);
            data.setNumber(n);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }
}

class SquareThread extends Thread
{
    SharedData data;

    SquareThread(SharedData data)
    {
        this.data = data;
    }

    public void run()
    {
        while (true)
        {
            int n = data.getEvenNumber();

            if (n != -1)
                System.out.println("Square of " + n + " = " + (n * n));
        }
    }
}

class CubeThread extends Thread
{
    SharedData data;

    CubeThread(SharedData data)
    {
        this.data = data;
    }

    public void run()
    {
        while (true)
        {
            int n = data.getOddNumber();

            if (n != -1)
                System.out.println("Cube of " + n + " = " + (n * n * n));
        }
    }
}

class SharedData
{
    int number;

    synchronized void setNumber(int n)
    {
        number = n;
        System.out.println("Generated Number: " + n);
        notifyAll();
    }

    synchronized int getEvenNumber()
    {
        if (number % 2 == 0)
            return number;
        return -1;
    }

    synchronized int getOddNumber()
    {
        if (number % 2 != 0)
            return number;
        return -1;
    }
}

public class MultiThreadedNumber
{
    public static void main(String[] args)
    {
        SharedData data = new SharedData();

        NumberGenerator t1 = new NumberGenerator(data);
        SquareThread t2 = new SquareThread(data);
        CubeThread t3 = new CubeThread(data);

        t1.start();
        t2.start();
        t3.start();
    }
}
