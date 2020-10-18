package WebComponents.controller;

import WebComponents.domain.TextMessage;
import WebComponents.service.TextProcessing;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

//    @RequestMapping(value = "/")
//    public ResponseEntity<?> mainPageResponse(){
//        String stringResponse = "Hello, please use correct source path to get corresponding services.";
//        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN)
//                .body(stringResponse);
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> mainPageResponse(@RequestBody final TextMessage message){
        System.out.println("received message:  "+ message.toString());
        String ret = TextProcessing.runScript(message);
        String retJson = new JSONObject().put("Detection Result", ret).toString();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(retJson);
    }

}
