package assignment5;

/**
   A stopwatch accumulates time when it is running. You can
   repeatedly start and stop the stopwatch. You can use a
   stopwatch to measure the running time of a program.
*/
public class StopWatch {
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    public static final double NANOS_PER_SEC = 1000000000;

    /**
       Constructs a stopwatch that is in the stopped state
       and has no time accumulated.
    */
    public StopWatch() {
        reset();
    }

    /**
       Starts the stopwatch. Time starts accumulating now.
    */
    public void start() {
        if (isRunning) return;
        isRunning = true;
        startTime = System.nanoTime();
    }

    /**
       Stops the stopwatch. Time stops accumulating and is
       is added to the elapsed time.
    */
    public void stop() {
        if (!isRunning) return;
        isRunning = false;
        long endTime = System.nanoTime();
        elapsedTime = elapsedTime + endTime - startTime;
    }

    /**
       Returns the total elapsed time.
       @return the total elapsed time
    */
    public long getElapsedNanoseconds() {
        if (isRunning) {
            long endTime = System.nanoTime ();
            elapsedTime = elapsedTime + endTime - startTime;
            startTime = endTime;
        }
        return elapsedTime;
    }

    public double getElapsedSeconds() {
        return getElapsedNanoseconds() / NANOS_PER_SEC;
    }

    /**
       Stops the watch and resets the elapsed time to 0.
    */
    public void reset() {
        elapsedTime = 0;
        isRunning = false;
    }
}

//public class DemoStopWatch
//{  /* here is a test driver program for the Stopwatch so that you can see
//          how it is supposed to work  */
//  public static void main(String[] args)
//  {
//     StopWatch s = new StopWatch();
//     int i;
//     long mytime;
//     s.start( );
//     int a[ ]=new int [1000000];
//     for (i=0; i < 1000000; i++)
//       a[i] = i;
//     s.stop();
//     mytime=s.getElapsedTime();
//     System.out.println("Time elapsed in nanoseconds is: "+ mytime);
//     System.out.println("Time elapsed in seconds is: "+ mytime/ NANOS_PER_SEC);
//
//  }
//}
