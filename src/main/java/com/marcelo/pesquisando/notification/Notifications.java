package com.marcelo.pesquisando.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.marcelo.pesquisando.entities.RootNotification;

@FeignClient(name= "notificacao", url="https://fcm.googleapis.com/fcm/")
public interface Notifications {
	
    @RequestMapping(method = RequestMethod.POST, value = "send")
    public void sendNotification(@RequestBody RootNotification params, @RequestHeader("Authorization") String key);

}
