package com.example.appregistrocovid.DAO;

import com.example.appregistrocovid.DTO.Paciente;

import java.util.List;

public interface PacientesDAO {
    Paciente guardar (Paciente p);
    List<Paciente> getAll();

}
