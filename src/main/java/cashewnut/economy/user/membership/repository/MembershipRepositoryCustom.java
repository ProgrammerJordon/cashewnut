package cashewnut.economy.user.membership.repository;

import cashewnut.economy.user.membership.entity.Membership;

import java.util.List;

public interface MembershipRepositoryCustom {
    List<Membership> findMembershipCustom();
}
