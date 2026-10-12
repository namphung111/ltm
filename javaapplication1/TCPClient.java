import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPClient {

    public static void main(String[] args) {

        String host = "36.50.135.242";
        int port = 2208;

        String studentCode = "B23DCCN588"; // Thay bằng mã sinh viên của bạn
        String qCode = "mteKBo0g"; // Thay bằng mã câu hỏi của bạn

        try (
                Socket socket = new Socket(host, port);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()))
        ) {

            socket.setSoTimeout(5000);

            // Gửi mã sinh viên và mã câu hỏi
            out.write(studentCode + ";" + qCode);
            out.newLine();
            out.flush();

            // Nhận danh sách tên miền từ server
            String receivedData = in.readLine();

            System.out.println("Dữ liệu nhận được:");
            System.out.println(receivedData);

            // Tách danh sách tên miền
            String[] domains = receivedData.split(",");

            List<String> eduDomains = new ArrayList<>();

            // Lọc các tên miền .edu
            for (String domain : domains) {

                domain = domain.trim();

                if (domain.endsWith(".edu")) {
                    eduDomains.add(domain);
                }
            }

            // Ghép kết quả
            String result = String.join(", ", eduDomains);

            System.out.println("Kết quả gửi lên server:");
            System.out.println(result);

            // Gửi kết quả lên server
            out.write(result);
            out.newLine();
            out.flush();

            System.out.println("Hoàn thành.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}