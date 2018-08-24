package co.grandcircus.soccerleagueapp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int playerId;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private int teamId;

	public Player() {
	}

	public Player(int playerId, String name, int teamId) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.teamId = teamId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", teamId=" + teamId + "]";
	}

}
