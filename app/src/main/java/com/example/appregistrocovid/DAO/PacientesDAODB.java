package com.example.appregistrocovid.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appregistrocovid.DTO.Paciente;
import com.example.appregistrocovid.helpers.PacientesDBOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class PacientesDAODB implements PacientesDAO{

    private PacientesDBOpenHelper db;

    public PacientesDAODB(Context context){
        this.db = new PacientesDBOpenHelper(context,
                "DBPacientes",
                null,
                1);
    }

    //modulo insercion  %d entero decimal,%s texto, %f

    @Override
    public Paciente guardar(Paciente p) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        String sql = String.format("INSTER INTO pacientes(" +
                "nombre,apellido,rut,estado,fecha,sintomas,tos,presion,area) " +
                        "VALUES('%s','%s','%s','%s','%s',%f,%f,%d,'%s')",
                p.getNombre(),p.getApellido(),
                p.getRut(),p.getEstado(),
                p.getFechaExamen(),p.getSintomas(),p.getTos(),
                p.getPresion(),p.getArea());
        writer.execSQL(sql);
        writer.close();
        return p;
    }

    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try {
            if (reader != null){
                Cursor c = reader.rawQuery("SELECT id,nombre,apellido,rut,estado," +
                        "fecha,sintomas,tos,presion,area FROM pacientes"
                        ,null);

                if(c.moveToFirst()){
                    do{
                        Paciente p = new Paciente();
                        p.setId(c.getInt(0));
                        p.setNombre(c.getString(2));
                        p.setApellido(c.getString(3));
                        p.setRut(c.getString(4));
                        p.setEstado(c.getInt(5));
                        p.setFechaExamen(c.getString(6));
                        p.setSintomas(c.getInt(7));
                        p.setTos(c.getInt(8));
                        p.setPresion(c.getInt(9));
                        p.setArea(c.getString(10));
                        pacientes.add(p);
                    }while (c.moveToNext());

                }
                reader.close();
            }

        }catch (Exception ex){
            pacientes = null;
        }
        return pacientes;
    }
}
