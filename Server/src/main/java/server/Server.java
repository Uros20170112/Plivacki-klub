/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import niti.ObradaKlijentskihZahteva;
import java.io.IOException;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kompic
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
    public static int brojPorta = 9000;
    static List<ObradaKlijentskihZahteva> klijenti = new ArrayList<>();
    private static boolean radi = false;

    public Server() {
        try {
            serverSocket = new ServerSocket(brojPorta);
            System.out.println("Kreiran server socket na portu " + brojPorta);
        } catch (Exception ex) {
            System.out.println("Doslo je do greske. Server socket nije kreiran.");
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Cekam klijente...");
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                ObradaKlijentskihZahteva kn = new ObradaKlijentskihZahteva(socket, klijenti);
                kn.start();
                klijenti.add(kn);
                System.out.println("Novi klijent se povezao!");
            }
        } catch (SocketException ex) {
            System.out.println("Server se gasi...");
        } catch (IOException e) {
            System.out.println("Greska kod povezivanja klijenta!");
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static boolean isRadi() {
        return radi;
    }

    public static void setRadi(boolean radi) {
        Server.radi = radi;
    }

    public void zaustaviNiti() {
        try {
            serverSocket.close();
            for (ObradaKlijentskihZahteva klijentNit : klijenti) {
                klijentNit.getSocket().close();
            }
        } catch (IOException ioe) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

}
