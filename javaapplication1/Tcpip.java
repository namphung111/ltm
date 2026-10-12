import java.io.*;
import java.util.Arrays;
import java.net.Socket;
import java.util.List;
import java.util.LinkedHashMap;
public class Tcpip {

   
    public static void main(String args[]) {
        // TODO code application logic here
        String studentCode ="B23DCCn588";
        String host = "36.50.135.242";
        int port = 2208;
        String qCode = " t1k22cQW";
        try{
            Socket socket= new Socket(host,port);
            BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()) );
         
            out.write(studentCode+ ";" + qCode);
            out.newLine();
            out.flush();
            String data =in.readLine();
            System.out.println(data);
            int[] count= new int[256];
            for(char c :data.toCharArray()){
                if(Character.isLetterOrDigit(c)){
                    count[c]++;
                }
            }
            StringBuilder result = new StringBuilder();
             for (char c : data.toCharArray()){
                 if(Character.isLetterOrDigit(c) && count[c] > 1){
                     boolean ams = false;
                     for(int i=0;i<result.length();i++){
                         if(result.charAt(i)==c){
                             ams= true;
                             break;
                         }
                     }
                     if(!ams){
                         result.append(c).append(":").append(count[c]).append(",");

                     }
                 }
                 
             }
            
             out.write(result.toString());
             out.newLine();
             out.flush();
             System.out.println("gui sv");
             System.out.append(result);
             socket.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
            
        
}
}