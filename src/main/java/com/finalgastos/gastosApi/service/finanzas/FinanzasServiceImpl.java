package com.finalgastos.gastosApi.service.finanzas;

import com.finalgastos.gastosApi.model.Gasto;
import com.finalgastos.gastosApi.model.Ingreso;
import com.finalgastos.gastosApi.repository.GastoRepository;
import com.finalgastos.gastosApi.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanzasServiceImpl implements FinanzasService {

    @Autowired
    private GastoRepository gastoRepositorio;

    @Autowired
    private IngresoRepository ingresoRepositorio;

    @Override
    public Gasto createGasto(Gasto gasto) {
        return gastoRepositorio.save(gasto);
    }

    @Override
    public List<Gasto> getAllGastos() {
        return gastoRepositorio.findAll();
    }

    @Override
    public Gasto getGastoById(String id) {
        return gastoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Gasto no encontrado"));
    }

    @Override
    public Gasto updateGasto(String id, Gasto gasto) {
        gasto.setId(id);
        return gastoRepositorio.save(gasto);
    }

    @Override
    public void deleteGasto(String id) {
        gastoRepositorio.deleteById(id);
    }

    @Override
    public Ingreso createIngreso(Ingreso ingreso) {
        return ingresoRepositorio.save(ingreso);
    }

    @Override
    public List<Ingreso> getAllIngresos() {
        return ingresoRepositorio.findAll();
    }

    @Override
    public Ingreso getIngresoById(String id) {
        return ingresoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
    }

    @Override
    public Ingreso updateIngreso(String id, Ingreso ingreso) {
        ingreso.setId(id);
        return ingresoRepositorio.save(ingreso);
    }

    @Override
    public void deleteIngreso(String id) {
        ingresoRepositorio.deleteById(id);
    }
}