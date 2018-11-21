package InitTamagotch;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCliente implements Serializable{
    public JSONObject cliente (JSONObject jsonTamagotch) {
        // arguments supply message and hostname
        Socket s = null;
        try{
            System.out.println("TCP Client init");
            int serverPort = 4444;
            s = new Socket("localhost", serverPort);
//            DataInputStream in = new DataInputStream( s.getInputStream());
//            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            System.out.println("1");
//            System.out.println(jsonTamagotch.toString());
            try {
                out.writeObject(jsonTamagotch);
                out.flush();

                JSONObject tmg = (JSONObject) in.readObject();

                System.out.println(tmg.toString());
                return tmg;
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage()); e.printStackTrace();
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
        return null;
    }
}
