package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.Advance;
import com.shohab.SpringBootProject.repository.AdvanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvanceService {
    @Autowired
    private AdvanceRepo advanceRepo;
    public void saveAdvance(Advance advance){
        advanceRepo.save(advance);
    }
    public List<Advance> getAllAdvance(){
        return advanceRepo.findAll();
    }
    public void deleteById(int id ){
        advanceRepo.deleteById(id);
    }
    public Advance editById(int id){
        return advanceRepo.findById(id).get();
    }
}
