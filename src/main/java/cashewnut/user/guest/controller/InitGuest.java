package cashewnut.user.guest.controller;

import cashewnut.user.guest.domain.Guest;
import cashewnut.user.membership.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitGuest {

    private final InitGuestService initGuestService;
    @PostConstruct
    public void init() {
        initGuestService.init();
    }

    @Component
    static class InitGuestService {
        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init() {
            Team teamA = new Team("teamA");
            Team teamB = new Team("teamB");
            em.persist(teamA);
            em.persist(teamB);

            for(int i = 0; i < 100; i++) {
                Team selectTeam = i % 2 == 0 ? teamA : teamB;
                em.persist(new Guest("guest"+i, i, selectTeam));
            }

        }
    }
}
