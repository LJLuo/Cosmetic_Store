package ui;

import javax.swing.SwingUtilities;

// Main class for OnlineStore application where the online store is
// constructed and available for user to interact with
public class Main {
    public static void main(String[] args) throws Exception {
        // OnlineStore luluStore = new OnlineStore();

        // luluStore.runStore();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StoreGUI mainGUI = new StoreGUI();
                mainGUI.show();
            }
        });
    }
}
