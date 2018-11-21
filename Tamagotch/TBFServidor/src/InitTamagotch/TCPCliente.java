package InitTamagotch;

import org.json.simple.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCliente {
    public JSONObject cliente (JSONObject jsonTamagotch) {
        // arguments supply message and hostname
        Socket s = null;
        try{
            int serverPort = 4444;
            s = new Socket("localhost", serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            out.writeUTF(jsonTamagotch);      	// UTF is a string encoding see Sn. 4.4
            return in.readUTF();	        // read a line of data from the stream
        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage());
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
        return "Null";
    }
}
