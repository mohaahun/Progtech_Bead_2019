package modell;

import jpa.GenericJpaDao;

public class PlayerDao extends GenericJpaDao<Player> {
    public PlayerDao(){
        super(Player.class);
    }
}
