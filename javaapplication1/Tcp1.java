
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Tcp1 {

    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2207;

        String studentCode = "B23DCCN588";
        String qCode = "rGO93CyE";

        try (Socket socket = new Socket(host, port)) {
         
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // String request = studentCode + ";" + qCode;
            out.writeUTF(studentCode + ";" + qCode);
            out.flush();

            int a = in.readInt();
            int b = in.readInt();

            int sum = a + b;
            int product = a * b;

            out.writeInt(sum);
            out.writeInt(product);
            out.flush();

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("Tong = " + sum);
            System.out.println("Tich = " + product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
