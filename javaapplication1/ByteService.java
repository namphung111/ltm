package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ByteService extends Remote {
    byte[] requestData(String studentCode, String qCode) throws RemoteException;

    void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
// import RMI.ByteService;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
// import java.util.LinkedHashMap;
// import java.util.Map;
// public class Client {
//     public static void main(String[] args) {
//         String host = "36.50.135.242";   // Exam Server
//         int port = 1099;                 // đổi nếu đề ghi cổng khác
//         String studentCode = "B23DCCN588";
//         String qCode = "kdwy6ozS";

//         try {
//             // a. Kết nối registry, lấy remote object và gọi requestData
//             Registry registry = LocateRegistry.getRegistry(host, port);
//             ByteService service = (ByteService) registry.lookup("RMIByteService");

//             byte[] data = service.requestData(studentCode, qCode);

//             // b. Tìm phần tử có số lần xuất hiện ít nhất
//             //    LinkedHashMap giữ thứ tự xuất hiện đầu tiên của từng phần tử
//             Map<Byte, Integer> count = new LinkedHashMap<>();
//             for (byte b : data) {
//                 count.put(b, count.getOrDefault(b, 0) + 1);
//             }

//             byte minElem = 0;
//             int minCount = Integer.MAX_VALUE;
//             for (Map.Entry<Byte, Integer> e : count.entrySet()) {
//                 // dùng "<" chặt để khi bằng nhau vẫn giữ phần tử xuất hiện trước
//                 if (e.getValue() < minCount) {
//                     minCount = e.getValue();
//                     minElem = e.getKey();
//                 }
//             }

//             // c. Gửi mảng kết quả [phần tử, số lần xuất hiện] lên server
//             byte[] result = new byte[]{minElem, (byte) minCount};
//             service.submitData(studentCode, qCode, result);

//             // d. Kết thúc
//             System.out.println("Phan tu it xuat hien nhat: " + minElem + " (" + minCount + " lan)");

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

// package RMI;

// import java.rmi.Remote;
// import java.rmi.RemoteException;

// public interface DataService extends Remote {
//     Object requestData(String studentCode, String qCode) throws RemoteException;

//     void submitData(String studentCode, String qCode, Object data) throws RemoteException;
// }

// import RMI.DataService;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
// import java.util.Arrays;
// import java.util.Locale;

// public class Client {
//     public static void main(String[] args) {
//         String host = "36.50.135.242";   // sửa theo Exam Server của đề này
//         int port = 1099;
//         String studentCode = "B23DCCN588";
//         String qCode = "LhJYvraW";       // sửa theo mã câu hỏi của đề này

//         try {
//             // a, b. Kết nối registry và gọi requestData
//             Registry registry = LocateRegistry.getRegistry(host, port);
//             DataService service = (DataService) registry.lookup("RMIDataService");

//             Object obj = service.requestData(studentCode, qCode);
//             String csv = obj.toString().trim();

//             // Tách chuỗi CSV thành mảng số thực
//             String[] parts = csv.split(",");
//             int n = parts.length;
//             double[] arr = new double[n];
//             for (int i = 0; i < n; i++) {
//                 arr[i] = Double.parseDouble(parts[i].trim());
//             }

//             // c. Trung bình
//             double sum = 0;
//             for (double v : arr) sum += v;
//             double avg = sum / n;

//             // Độ lệch chuẩn (tổng thể: chia cho n)
//             double sq = 0;
//             for (double v : arr) sq += (v - avg) * (v - avg);
//             double stddev = Math.sqrt(sq / n);

//             // Phân vị 95: sắp xếp tăng dần, lấy vị trí ceil(n * 0.95) - 1
//             double[] sorted = arr.clone();
//             Arrays.sort(sorted);
//             int idx = (int) Math.ceil(n * 0.95) - 1;
//             double p95 = sorted[idx];

//             // d. Tạo chuỗi kết quả, làm tròn 2 chữ số thập phân
//             String result = String.format(Locale.US,
//                     "average=%.2f;stddev=%.2f;p95=%.2f", avg, stddev, p95);
//             service.submitData(studentCode, qCode, result);

//             // e. Kết thúc
//             System.out.println(result);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }