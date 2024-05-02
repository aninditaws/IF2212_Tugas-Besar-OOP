public class Stopwatch {
      // ATRIBUT
      private long startTime = 0;
      private long stopTime = 0;
      private boolean running = false;
      
      /*METHOD*/
      public void start_watch() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
      }
      
      
      public void stop_watch() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
      }
      
      
      /*GETTER */ 
      public long getElapsedTime() {
        long elapsed;
        if (running) {
          elapsed = (System.currentTimeMillis() - startTime);
        } else {
          elapsed = (stopTime - startTime);
        }
        return elapsed;
      }
      
      
      //pake yang ini aja
      public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
          elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
          elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
      }
    }

    
    


    /* NOTES */
    //Elapsed itu selisih waktu, jadi kalo:
    //1.lagi running = elapsed nya itu selisih antara waktu sekarang sama waktu mulai
    //2.lagi stop = elapsed nya itu selisih antara waktu stop sama waktu mulai
    // ada kemungkinan currenttime millis bisa error, karena gabisa diubah ke second 