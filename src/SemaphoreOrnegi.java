
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreOrnegi {
    
    private Semaphore sem = new Semaphore(3);
    //Semaphore classından yeni bir semaphore oluşturuyorum
    //permits aynı anda kaç thread çalıştırmak istediğimi belirtiyor
    
    public void threadFonksiyonu(int id) {
        
        try {
            sem.acquire();
            //permits 0dan büyük ise döngüye girip semaphoreun permit değerini bir azaltıp 0 olanaka kadar devam edecek
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Thread Başlıyor... ID : " + id );
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Çıkıyor.... ID : " + id);
        
        sem.release();
        //semaphore değeri 0 ise başka threadler girebilsin diye o değeri 1 arttırıyor
        
    }
    
}
