import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient1 {

    public static void main(String[] args) {

        String host = "36.50.135.242";
        int port = 2207;

        String studentCode = "B23DCCN588";
        String qCode = "rGO93CyE";

        try (Socket socket = new Socket(host, port)) {

            socket.setSoTimeout(5000);

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // 1. Gửi mã sinh viên và mã câu hỏi
            String request = studentCode + ";" + qCode;

            output.write(request.getBytes(StandardCharsets.UTF_8));
            output.flush();

            System.out.println("Đã gửi: " + request);

            // 2. Nhận chuỗi số từ server
            byte[] buffer = new byte[1024];

            int length = input.read(buffer);

            if (length == -1) {
                System.out.println("Server đã đóng kết nối.");
                return;
            }

            String data = new String(
                    buffer,
                    0,
                    length,
                    StandardCharsets.UTF_8
            ).trim();

            System.out.println("Server gửi: " + data);

            // 3. Tìm giá trị lớn thứ 2 và vị trí
            String[] parts = data.split(",");

            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;

            int pos1 = -1;
            int pos2 = -1;

            for (int i = 0; i < parts.length; i++) {

                int value = Integer.parseInt(parts[i].trim());

                if (value > max1) {

                    max2 = max1;
                    pos2 = pos1;

                    max1 = value;
                    pos1 = i;

                } else if (value > max2 && value < max1) {

                    max2 = value;
                    pos2 = i;
                }
            }

            System.out.println("Giá trị lớn thứ 2: " + max2);
            System.out.println("Vị trí: " + pos2);

            // 4. Gửi kết quả
            String result = max2 + "," + pos2;

            output.write(result.getBytes(StandardCharsets.UTF_8));
            output.flush();

            System.out.println("Đã gửi: " + result);

            // 5. Đóng kết nối

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}