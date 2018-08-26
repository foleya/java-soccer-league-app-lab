package co.grandcircus.soccerleagueapp.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.soccerleagueapp.dao.Player;

@Transactional  
@Repository
public class PlayerDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Player> findAll() {
		return em.createQuery("FROM Player ORDER BY name", Player.class).getResultList();

	}
	
	public List<Player> findByKeyword(String keyword) {
		return em.createQuery("FROM Player WHERE LOWER(name) LIKE :regex", Player.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	public Player findById(int playerId) {
		return em.find(Player.class, playerId);
	}

	public void create(Player player) {
		em.persist(player);
	}
	
	public void update(Player player) {
		em.merge(player);
	}

	public void delete(int playerId) {
		Player player = em.getReference(Player.class, playerId);
		em.remove(player);
	}

	public Object findByTeam(String team) {
		// TODO Auto-generated method stub
		return null;
	}
	  
	  
}
