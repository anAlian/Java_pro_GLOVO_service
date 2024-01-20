package hw11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String clSpeech;
        boolean isConnectionClosed = false;

        clSpeech = din.readUTF();
        System.out.println("Client says:" + clSpeech);
        if (!isForbiddenSymbol(clSpeech)) {
            if (!checkReply(din, dout)) {
                isConnectionClosed = true;
            }
        } else {
            dout.writeUTF("Hello");
            System.out.println("Server says: hello");
        }
        if (!isConnectionClosed) {

            while (true) {
                clSpeech = din.readUTF();
                System.out.println("Client says:" + clSpeech);
                if (clSpeech.equals("stop")) {
                    dout.writeUTF("Good bye!");
                    break;
                }
                String serSpeech;
                serSpeech = br.readLine();
                dout.writeUTF(serSpeech);
                dout.flush();
            }
        }

        System.out.println("Closing connection...");
        din.close();
        socket.close();
        serverSocket.close();
    }

    public static boolean isForbiddenSymbol(String str) {
        return (!str.contains("ъ") && !str.contains("ы") && !str.contains("э") && !str.contains("ё"));
    }


    public static boolean checkReply(DataInputStream din, DataOutputStream dout) throws IOException {
        boolean result = true;

        dout.writeUTF("що таке паляниця?");
        System.out.println("hw11.Server says: що таке паляниця?");
        String str = din.readUTF();
        if (str.equals("хліб")) {
            dout.writeUTF("гарного дня! " + LocalDateTime.now());
            System.out.println("hw11.Server says: гарного дня! " + LocalDateTime.now());
        } else {
            System.out.println("hw11.Client says:" + str);
            dout.writeUTF("Connection is lost");
            result = false;
        }
        return result;

    }
}
