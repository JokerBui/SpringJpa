package com.example.bai2.controler;


import com.example.bai2.sach.Sach;
import com.example.bai2.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private SachService service;


    @GetMapping("/")
    public ResponseEntity<List<Sach>> showSachList() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Sach> SachNewForm(@RequestBody Sach sach) {
        return ResponseEntity.ok(service.save(sach));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sach> SachUpdate(@PathVariable Integer id,@RequestBody Sach sach) throws Exception {
        return ResponseEntity.ok(service.update(id, sach));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sach> SachDelete(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Sach>> SachUpdate(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.listAllById(id));
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Sach>> search(@PathVariable String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }
    @GetMapping("/searchNative/{keyword}")
    public ResponseEntity<List<Sach>> searchNative(@PathVariable String keyword) {
        return ResponseEntity.ok(service.searchNative(keyword));
    }
}
