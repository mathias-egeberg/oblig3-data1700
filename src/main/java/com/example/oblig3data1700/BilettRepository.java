package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilettRepository {

    @Autowired
    private JdbcTemplate db;


    public void lagreBilett(Bilett innBilett){
        String sql = "INSERT INTO Bilett (film, antall, navn, telefon, epost) VALUES(?,?,?,?,?)";
        db.update(sql,innBilett.getFilm(), innBilett.getAntall(), innBilett.getNavn(), innBilett.getTelefon(), innBilett.getEpost());
    }

    public List<Bilett> hentAlle(){
        String sql = "Select * From Bilett";
        List<Bilett> alleBiletter = db.query(sql,new BeanPropertyRowMapper<>(Bilett.class));
        return alleBiletter;
    }

}
