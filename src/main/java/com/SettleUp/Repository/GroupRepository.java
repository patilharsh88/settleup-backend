package com.SettleUp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.SettleUp.Entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
