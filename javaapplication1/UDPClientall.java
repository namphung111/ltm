// import java.net.DatagramPacket;
// import java.net.DatagramSocket;
// import java.net.InetAddress;

// public class UDPClient {

//     public static void main(String[] args) {
//         String host = "36.50.135.242";
//         int port = 2207;

//         String studentCode = "B23DCCN588";
//         String qCode = "NnVUBoHq";

//         try (DatagramSocket socket = new DatagramSocket()) {

//             InetAddress serverAddress = InetAddress.getByName(host);

//             String message = ";" + studentCode + ";" + qCode;

//             DatagramPacket sendPacket = new DatagramPacket(
//                     message.getBytes(),
//                     message.length(),
//                     serverAddress,
//                     port
//             );

//             socket.send(sendPacket);

//             byte[] buffer = new byte[4096];
//             DatagramPacket receivePacket =
//                     new DatagramPacket(buffer, buffer.length);

//             socket.receive(receivePacket);

//             String response = new String(
//                     receivePacket.getData(),
//                     0,
//                     receivePacket.getLength()
//             );

//             System.out.println("Server: " + response);

//             String[] parts = response.split(";");

//             String requestId = parts[0];
//             int n = Integer.parseInt(parts[1]);

//             boolean[] exists = new boolean[n + 1];

//             if (parts.length > 2 && !parts[2].isEmpty()) {
//                 String[] numbers = parts[2].split(",");

//                 for (String number : numbers) {
//                     int value = Integer.parseInt(number);

//                     if (value >= 1 && value <= n) {
//                         exists[value] = true;
//                     }
//                 }
//             }

//             StringBuilder missing = new StringBuilder();

//             for (int i = 1; i <= n; i++) {
//                 if (!exists[i]) {
//                     if (missing.length() > 0) {
//                         missing.append(",");
//                     }
//                     missing.append(i);
//                 }
//             }

//             String result = requestId + ";" + missing;

//             System.out.println("Client: " + result);

//             sendPacket = new DatagramPacket(
//                     result.getBytes(),
//                     result.length(),
//                     serverAddress,
//                     port
//             );

//             socket.send(sendPacket);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }




// // package javaapplication1;

// // import java.net.DatagramPacket;
// // import java.net.DatagramSocket;
// // import java.net.InetAddress;
// // import java.nio.charset.StandardCharsets;
// // import java.util.LinkedHashMap;
// // import java.util.Map;

// // public class UDPClientall {
// //     public static void main(String[] args) {
// //         String studentCode = "B23DCCN588";
// //         String qCode = "5IsY5Xtx";

// //         try (DatagramSocket socket = new DatagramSocket()) {
// //             socket.setSoTimeout(5000);

// //             InetAddress address = InetAddress.getByName("36.50.135.242");
// //             int port = 2208;

// //             String message = ";" + studentCode + ";" + qCode;
// //             byte[] sendData = message.getBytes(StandardCharsets.UTF_8);

// //             DatagramPacket sendPacket = new DatagramPacket(
// //                     sendData, sendData.length, address, port);
// //             socket.send(sendPacket);

// //             byte[] receiveData = new byte[4096];
// //             DatagramPacket receivePacket = new DatagramPacket(
// //                     receiveData, receiveData.length);

// //             socket.receive(receivePacket);

// //             String response = new String(
// //                     receivePacket.getData(),
// //                     0,
// //                     receivePacket.getLength(),
// //                     StandardCharsets.UTF_8);

// //             String[] parts = response.split(";", 2);

// //             if (parts.length < 2 || parts[1].isEmpty()) {
// //                 throw new IllegalArgumentException("Du lieu nhan khong hop le");
// //             }

// //             String requestId = parts[0];
// //             String data = parts[1];

// //             Map<Character, Integer> frequency = new LinkedHashMap<>();

// //             for (int i = 0; i < data.length(); i++) {
// //                 char c = data.charAt(i);
// //                 frequency.put(c, frequency.getOrDefault(c, 0) + 1);
// //             }

// //             char maxChar = data.charAt(0);
// //             int maxCount = 0;

// //             for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
// //                 if (entry.getValue() > maxCount) {
// //                     maxCount = entry.getValue();
// //                     maxChar = entry.getKey();
// //                 }
// //             }

// //             StringBuilder positions = new StringBuilder();

// //             for (int i = 0; i < data.length(); i++) {
// //                 if (data.charAt(i) == maxChar) {
// //                     positions.append(i + 1).append(",");
// //                 }
// //             }

// //             String result = requestId + ";" + maxChar + ":" + positions;
// //             byte[] resultData = result.getBytes(StandardCharsets.UTF_8);

// //             DatagramPacket resultPacket = new DatagramPacket(
// //                     resultData,
// //                     resultData.length,
// //                     receivePacket.getAddress(),
// //                     receivePacket.getPort());

// //             socket.send(resultPacket);

// //             System.out.println("Du lieu nhan: " + data);
// //             System.out.println("Ky tu xuat hien nhieu nhat: " + maxChar);
// //             System.out.println("Cac vi tri: " + positions);
// //             System.out.println("Da gui: " + result);

// //         } catch (Exception e) {
// //             e.printStackTrace();
// //         }
// //     }
// // }





// package javaapplication1;

// import java.net.DatagramPacket;
// import java.net.DatagramSocket;
// import java.net.InetAddress;
// import java.nio.charset.StandardCharsets;

// public class UDPClientall {
//     public static void main(String[] args) {
//         String studentCode = "B23DCCN588";
//         String qCode = "ctzvJFVX";

//         try (DatagramSocket socket = new DatagramSocket()) {
//             socket.setSoTimeout(5000);

//             InetAddress address = InetAddress.getByName("36.50.135.242");
//             int port = 2207;

//             String message = ";" + studentCode + ";" + qCode;
//             byte[] sendData = message.getBytes(StandardCharsets.UTF_8);

//             DatagramPacket sendPacket = new DatagramPacket(
//                     sendData, sendData.length, address, port);
//             socket.send(sendPacket);

//             byte[] receiveData = new byte[4096];
//             DatagramPacket receivePacket = new DatagramPacket(
//                     receiveData, receiveData.length);

//             socket.receive(receivePacket);

//             String response = new String(
//                     receivePacket.getData(),
//                     0,
//                     receivePacket.getLength(),
//                     StandardCharsets.UTF_8);

//             String[] parts = response.split(";", 2);
//             String requestId = parts[0];
//             String[] numbers = parts[1].split(",");

//             int max = Integer.MIN_VALUE;
//             int min = Integer.MAX_VALUE;

//             for (String number : numbers) {
//                 int value = Integer.parseInt(number.trim());

//                 if (value > max) {
//                     max = value;
//                 }

//                 if (value < min) {
//                     min = value;
//                 }
//             }

//             String result = requestId + ";" + max + "," + min;
//             byte[] resultData = result.getBytes(StandardCharsets.UTF_8);

//             DatagramPacket resultPacket = new DatagramPacket(
//                     resultData,
//                     resultData.length,
//                     receivePacket.getAddress(),
//                     receivePacket.getPort());

//             socket.send(resultPacket);

//             System.out.println("Du lieu nhan: " + response);
//             System.out.println("Gia tri lon nhat: " + max);
//             System.out.println("Gia tri nho nhat: " + min);
//             System.out.println("Da gui: " + result);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }





package javaapplication1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPClientall {
    public static void main(String[] args) {
        String studentCode = "B23DCCN588";
        String qCode = "YKvrcqOV";

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);

            InetAddress address = InetAddress.getByName("36.50.135.242");
            int port = 2208;

            String message = ";" + studentCode + ";" + qCode;
            byte[] sendData = message.getBytes(StandardCharsets.UTF_8);

            DatagramPacket sendPacket = new DatagramPacket(
                    sendData, sendData.length, address, port);
            socket.send(sendPacket);

            byte[] receiveData = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveData, receiveData.length);

            socket.receive(receivePacket);

            String response = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength(),
                    StandardCharsets.UTF_8);

            String[] parts = response.split(";", 2);
            String requestId = parts[0];
            String data = parts[1];

            StringBuilder normalized = new StringBuilder();
            boolean newWord = true;

            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);

                if (Character.isLetter(c)) {
                    if (newWord) {
                        normalized.append(Character.toUpperCase(c));
                    } else {
                        normalized.append(Character.toLowerCase(c));
                    }
                    newWord = false;
                } else {
                    normalized.append(c);
                    newWord = true;
                }
            }

            String result = requestId + ";" + normalized;
            byte[] resultData = result.getBytes(StandardCharsets.UTF_8);

            DatagramPacket resultPacket = new DatagramPacket(
                    resultData,
                    resultData.length,
                    receivePacket.getAddress(),
                    receivePacket.getPort());

            socket.send(resultPacket);

            System.out.println("Du lieu nhan: " + data);
            System.out.println("Chuoi chuan hoa: " + normalized);
            System.out.println("Da gui: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
