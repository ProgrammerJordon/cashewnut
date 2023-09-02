package biz.cashewnut.member.service;

import biz.cashewnut.member.domain.Member;
import biz.cashewnut.member.repository.MemberRepository;
import biz.cashewnut.member.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test//(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("name");
        Member member2 = new Member();
        member2.setName("name");
        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
        }catch (IllegalStateException e) {
            return ;
        }
        //then
        fail("예외에러 발생");
    }
}