package Thread

import android.util.Log

//Thread 클래스를 상속받고 run 메서드 오버라이드
class WorkThread : Thread() {
    override fun run() {
        var i = 0
        while (i < 10) {
            i += 1
            Log.d("WorkerThread", "$i")
        }
    }
}
//Runnable 인터페이스를 구현하고 run 메서드 구현
class WorkThreadRunnable:Runnable{
   override fun run(){
       var i = 0
       while (i < 10) {
           i += 1
           Log.d("WorkerThread", "$i")
       }
   }
}