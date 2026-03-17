package com.chanzo.hoodSquare.market.repo;

import com.chanzo.hoodSquare.market.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
}
