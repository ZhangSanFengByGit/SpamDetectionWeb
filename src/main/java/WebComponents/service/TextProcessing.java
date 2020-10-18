package WebComponents.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import WebComponents.domain.TextMessage;
import org.springframework.stereotype.Service;

@Service
public class TextProcessing {
    static Process mProcess;

    public static String runScript(TextMessage message){
        Process process;
        try{
            process = Runtime.getRuntime().exec(new String[]{"script_python",message.text});
            mProcess = process;
        }catch(Exception e) {
            System.out.println("Exception Raised" + e.toString());
        }
        InputStream stdout = mProcess.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
        String line = "";
        try{
            while((line = reader.readLine()) != null){
                System.out.println("stdout: "+ line);
            }
        }catch(IOException e){
            System.out.println("Exception in reading output"+ e.toString());
        }
        return line;
    }
}
