package modell;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setName(String name) {
        Name = name;
    }

    private String Name;
    private int Steps;


    public int getSteps() {
        return Steps;
    }

    public void sendscore(Player player) {
    Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
    PlayerDao playerDao = injector.getInstance(PlayerDao.class);

    player = Player.builder()
            .Name(player.Name)
            .Steps(player.Steps)
            .build();

    playerDao.persist(player);
}


}
