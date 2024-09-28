
package sumserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SumServer {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Started server");
        Socket s = ss.accept();
        System.out.println("Connection established at port:"+s.getLocalPort());
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        String data=in.readLine();
        String[] num = data.split(" ");
        String output = String.valueOf(Integer.parseInt(num[0]) + Integer.parseInt(num[1])); 
         out.println(output);
         
        
    }
    
}
