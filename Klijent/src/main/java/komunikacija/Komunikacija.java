/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author kompic
 */
public class Komunikacija {
    
    private static Komunikacija instance;
    
    private static Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    
    private Komunikacija(){    
    }
    
    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public Socket getSocket() {
        return socket;
    }
    
    public void setSocket(Socket socket) throws IOException {
        Komunikacija.socket = socket;
        out = new ObjectOutputStream(Komunikacija.socket.getOutputStream());
        in = new ObjectInputStream(Komunikacija.socket.getInputStream());
//        System.out.println("Podeseni streamovi.");
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        out.writeUnshared(kz);
    }

    public ServerskiOdgovor procitajOdgovor() throws IOException, ClassNotFoundException {
        return (ServerskiOdgovor) in.readUnshared();
    }
}
