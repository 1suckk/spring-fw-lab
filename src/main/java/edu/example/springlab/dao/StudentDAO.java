package edu.example.springlab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.example.springlab.domain.StudentDTO;

@Mapper
public interface StudentDAO {
	public List<StudentDTO> listAll();
	
	public List<StudentDTO> listOrderByScoreDesc();
	
	public List<StudentDTO> listByScoreGreaterEqualThan(int score);
	
	public List<StudentDTO> listByContainName(String Keyword);
	
	public Integer getScore(String name);
	
	public float getScoreAvg();
}
