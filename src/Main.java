import Game.GameFrame;
import Game.GameManager;
import Plant.Sunflower;
import Subscriber.EventChannel;
import Sun.Sun;

import java.awt.*;

public class Main {

    public static Thread timerThread;
    private static final EventChannel channel = EventChannel.getInstance();

    public static void main(String[] args) {
        // Contoh penggunaan, subscribe ke channel untuk semua entitas yang butuh update
        // Subscribe dilakukan di setiap kelas yang butuh update (cek kelas Sunflower
        // untuk contoh)
        // Subscrive dilakukan dengan memanggil subscrive ke singleton instance dari
        // eventchannel
        Sunflower sunflower = new Sunflower();
        Sun sun = Sun.getInstance();
        GameManager gameManager = new GameManager();
        gameManager.startTimer();
        EventQueue.invokeLater(() -> {
            GameFrame frame = new GameFrame(gameManager);
            frame.setVisible(true);
        });
    }

}
