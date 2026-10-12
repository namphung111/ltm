import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {
        String host = "36.50.135.242";
        int port = 2207;

        String studentCode = "B23DCCN588";
        String qCode = "NnVUBoHq";

        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress serverAddress = InetAddress.getByName(host);

            String message = ";" + studentCode + ";" + qCode;

            DatagramPacket sendPacket = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    serverAddress,
                    port
            );

            socket.send(sendPacket);

            byte[] buffer = new byte[4096];
            DatagramPacket receivePacket =
                    new DatagramPacket(buffer, buffer.length);

            socket.receive(receivePacket);

            String response = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength()
            );

            System.out.println("Server: " + response);

            String[] parts = response.split(";");

            String requestId = parts[0];
            int n = Integer.parseInt(parts[1]);

            boolean[] exists = new boolean[n + 1];

            if (parts.length > 2 && !parts[2].isEmpty()) {
                String[] numbers = parts[2].split(",");

                for (String number : numbers) {
                    int value = Integer.parseInt(number);

                    if (value >= 1 && value <= n) {
                        exists[value] = true;
                    }
                }
            }

            StringBuilder missing = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (!exists[i]) {
                    if (missing.length() > 0) {
                        missing.append(",");
                    }
                    missing.append(i);
                }
            }

            String result = requestId + ";" + missing;

            System.out.println("Client: " + result);

            sendPacket = new DatagramPacket(
                    result.getBytes(),
                    result.length(),
                    serverAddress,
                    port
            );

            socket.send(sendPacket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}