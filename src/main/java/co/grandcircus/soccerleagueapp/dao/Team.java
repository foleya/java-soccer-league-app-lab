package co.grandcircus.soccerleagueapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String name;

	public Team() {
	}

	public Team(int teamId, String name) {
		this.teamId = teamId;
		this.name = name;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + "]";
	}
	
}
