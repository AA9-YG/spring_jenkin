package com.hrsmvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrsmvc.model.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

}
