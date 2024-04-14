package me.jason.badddos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;




public class Home_Controller {


    public static boolean validateIpAddress(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address instanceof Inet4Address || address instanceof Inet6Address;
        } catch (UnknownHostException e) {
            return false;
        }
    }




    @FXML
    private Label feedback;
    @FXML
    private TextField ipInp;
    @FXML
    private TextField portInp;
    @FXML
    private TextField threadInp;


    @FXML
    // Initialization Function
    protected void initialize() {

    }


    @FXML
    public void ddos_btn_click() {
        // user Input
        String ipAddress;
        String portStr;
        String threadStr;
        int port;
        int threads;


        if (ipInp.getText().isEmpty() || portInp.getText().isEmpty() || threadInp.getText().isEmpty()) {
            // Make Sure User Input is not Empty
            feedback.setOpacity(100);
            feedback.setText("Please fill out all fields");
            return;
        }
        else {
            // Get User Input
            ipAddress = ipInp.getText();
            portStr = portInp.getText();
            threadStr = threadInp.getText();
        }


        // -------- Validate stuff - error checking --------
        try {
            port = Integer.parseInt(portStr);
            threads = Integer.parseInt(threadStr);
        }
        catch (NumberFormatException e) {
            feedback.setText("Lookup what an integer is");
            feedback.setOpacity(100);
            return;
        }
        if (!validateIpAddress(ipAddress)) {
            feedback.setText("Lookup what an ip is");
            feedback.setOpacity(100);
            return;
        }
        else if (port < 0 || port > 65536) {
            feedback.setText("The range of a port is between 0 and 65536");
            feedback.setOpacity(100);
            return;
        }


        // User Feedback
        feedback.setText("Beginning DDOS...");

        // Begin the terrorism
        new DDOS(ipAddress, port, threads);
    }




}