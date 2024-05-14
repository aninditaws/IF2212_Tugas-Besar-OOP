import Plant.Sunflower;


public class Main {



    public static void main(String[] args) {
        // Contoh penggunaan, subscribe ke channel untuk semua entitas yang butuh update
        // Subscribe dilakukan di setiap kelas yang butuh update (cek kelas Sunflower untuk contoh)
        // Subscrive dilakukan dengan memanggil subscrive ke singleton instance dari eventchannel
        Sunflower sunflower = new Sunflower();
        GameManager.startTimer();
    }




}
