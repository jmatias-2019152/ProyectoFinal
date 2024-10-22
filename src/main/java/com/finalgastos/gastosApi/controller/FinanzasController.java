package com.finalgastos.gastosApi.controller;

import com.finalgastos.gastosApi.model.Gasto;
import com.finalgastos.gastosApi.model.Ingreso;
import com.finalgastos.gastosApi.service.finanzas.FinanzasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finanzas")
public class FinanzasController {

    @Autowired
    private FinanzasService finanzasService;

    @PostMapping("/gastos")
    public ResponseEntity<Gasto> createGasto(@RequestBody Gasto gasto) {
        return new ResponseEntity<>(finanzasService.createGasto(gasto), HttpStatus.CREATED);
    }

    @GetMapping("/gastos")
    public List<Gasto> getAllGastos() {
        return finanzasService.getAllGastos();
    }

    @GetMapping("/gastos/{id}")
    public ResponseEntity<Gasto> getGastoById(@PathVariable String id) {
        return new ResponseEntity<>(finanzasService.getGastoById(id), HttpStatus.OK);
    }

    @PutMapping("/gastos/{id}")
    public ResponseEntity<Gasto> updateGasto(@PathVariable String id, @RequestBody Gasto gasto) {
        return new ResponseEntity<>(finanzasService.updateGasto(id, gasto), HttpStatus.OK);
    }

    @DeleteMapping("/gastos/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable String id) {
        finanzasService.deleteGasto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/ingresos")
    public ResponseEntity<Ingreso> createIngreso(@RequestBody Ingreso ingreso) {
        return new ResponseEntity<>(finanzasService.createIngreso(ingreso), HttpStatus.CREATED);
    }

    @GetMapping("/ingresos")
    public List<Ingreso> getAllIngresos() {
        return finanzasService.getAllIngresos();
    }

    @GetMapping("/ingresos/{id}")
    public ResponseEntity<Ingreso> getIngresoById(@PathVariable String id) {
        return new ResponseEntity<>(finanzasService.getIngresoById(id), HttpStatus.OK);
    }

    @PutMapping("/ingresos/{id}")
    public ResponseEntity<Ingreso> updateIngreso(@PathVariable String id, @RequestBody Ingreso ingreso) {
        return new ResponseEntity<>(finanzasService.updateIngreso(id, ingreso), HttpStatus.OK);
    }

    @DeleteMapping("/ingresos/{id}")
    public ResponseEntity<Void> deleteIngreso(@PathVariable String id) {
        finanzasService.deleteIngreso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}