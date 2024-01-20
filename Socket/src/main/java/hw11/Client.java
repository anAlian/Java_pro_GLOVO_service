package hw11;

import java.io.*;

import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8081);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str, str2;
        do {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says:" + str2);
        }
        while (!str.equals("stop") && !str2.equals("Connection is lost"));
        dout.close();
        din.close();
        s.close();
    }

}
