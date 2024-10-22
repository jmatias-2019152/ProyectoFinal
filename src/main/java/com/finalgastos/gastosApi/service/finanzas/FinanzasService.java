package com.finalgastos.gastosApi.service.finanzas;


import com.finalgastos.gastosApi.model.Ingreso;
import com.finalgastos.gastosApi.model.Gasto;

import java.util.List;

public interface FinanzasService {
    Gasto createGasto(Gasto gasto);
    List<Gasto> getAllGastos();
    Gasto getGastoById(String id);
    Gasto updateGasto(String id, Gasto gasto);
    void deleteGasto(String id);

    Ingreso createIngreso(Ingreso ingreso);
    List<Ingreso> getAllIngresos();
    Ingreso getIngresoById(String id);
    Ingreso updateIngreso(String id, Ingreso ingreso);
    void deleteIngreso(String id);
}