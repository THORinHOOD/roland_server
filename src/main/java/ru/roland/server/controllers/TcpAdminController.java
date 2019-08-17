package ru.roland.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.roland.server.services.TcpServerService;

@RestController
public class TcpAdminController {

    @Autowired
    private TcpServerService tcpServerService;

    @GetMapping(value = "/apiv1/tcp/start")
    public ResponseEntity startTcp() {
        try {
            tcpServerService.startTcpServer();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
