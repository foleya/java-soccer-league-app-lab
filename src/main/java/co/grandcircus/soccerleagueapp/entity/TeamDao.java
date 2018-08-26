package co.grandcircus.soccerleagueapp.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.soccerleagueapp.dao.Team;

@Transactional  
@Repository
public class TeamDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Team> findAll() {
		return em.createQuery("FROM Team ORDER BY name", Team.class).getResultList();

	}
	
	public List<Team> findByKeyword(String keyword) {
		return em.createQuery("FROM Team WHERE LOWER(name) LIKE :regex", Team.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	public Team findById(int teamId) {
		return em.find(Team.class, teamId);
	}

	public void create(Team team) {
		em.persist(team);
	}
	
	public void update(Team team) {
		em.merge(team);
	}

	public void delete(int teamId) {
		Team team = em.getReference(Team.class, teamId);
		em.remove(team);
	}

}
