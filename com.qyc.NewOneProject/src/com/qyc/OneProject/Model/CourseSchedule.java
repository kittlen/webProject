package com.qyc.OneProject.Model;

public class CourseSchedule {
	private int ID;
	private  Student student;
	private Schedule schedule;
	private double ScoreOne;
	private double ScoreTwo;
	private double ScoreThree;
	private double TotalScore;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public double getScoreOne() {
		return ScoreOne;
	}
	public void setScoreOne(double scoreOne) {
		ScoreOne = scoreOne;
	}
	public double getScoreTwo() {
		return ScoreTwo;
	}
	public void setScoreTwo(double scoreTwo) {
		ScoreTwo = scoreTwo;
	}
	public double getScoreThree() {
		return ScoreThree;
	}
	public void setScoreThree(double scoreThree) {
		ScoreThree = scoreThree;
	}
	public double getTotalScore() {
		return TotalScore;
	}
	public void setTotalScore(double totalScore) {
		TotalScore = totalScore;
	}
	

}
