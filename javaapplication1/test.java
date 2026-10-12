import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
public class test {

    public static void main(String[] args) {

        String host = "36.50.135.242";
        int port = 2208;

        String studentCode = "B23DCCN588"; // Thay bằng mã sinh viên của bạn
        String qCode = "t1k22cQW";
        try{
            Socket socket= new Socket(host,port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
            
            
        
        out.write(studentCode + ";" + qCode);
        out.newLine();
        out.flush();
        
        String data = in.readLine();

            System.out.println("Received: " + data);

            Map<Character, Integer> count = new LinkedHashMap<>();

            for (char c : data.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    count.put(c, count.getOrDefault(c, 0) + 1);
                }
            }

            StringBuilder result = new StringBuilder();

            for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                if (entry.getValue() > 1) {
                    result.append(entry.getKey())
                          .append(":")
                          .append(entry.getValue())
                          .append(",");
                }
            }

        out.write(result.toString());
        out.newLine();
        out.flush();
        
        System.out.println("sent to sv");
        System.out.println(result);
        socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
    }
    }
}