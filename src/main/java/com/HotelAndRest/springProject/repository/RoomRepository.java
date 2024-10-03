package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Room objects
    private static final RowMapper<Room> roomRowMapper = new RowMapper<Room>() {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            Room room = new Room();
            room.setRoomNo(rs.getInt("Room_No"));
            room.setType(rs.getString("Type"));
            room.setStatus(rs.getString("Status"));
            room.setHotelId(rs.getInt("Hotel_ID"));
            return room;
        }
    };

    // Save a new room
    public void save(Room room) {
        String query = "INSERT INTO Room (Type, Status, Hotel_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(query,
                room.getType(),
                room.getStatus(),
                room.getHotelId());
    }

    // Get all rooms
    public List<Room> findAll() {
        String query = "SELECT * FROM Room";
        return jdbcTemplate.query(query, roomRowMapper);
    }

    // Find a room by room number
    public Room findById(int roomNo) {
        String query = "SELECT * FROM Room WHERE Room_No = ?";
        return jdbcTemplate.queryForObject(query, roomRowMapper, roomNo);
    }

    // Update a room
    public void update(Room room) {
        String query = "UPDATE Room SET Type = ?, Status = ?, Hotel_ID = ? WHERE Room_No = ?";
        jdbcTemplate.update(query,
                room.getType(),
                room.getStatus(),
                room.getHotelId(),
                room.getRoomNo());
    }

    // Delete a room by room number
    public void delete(int roomNo) {
        String query = "DELETE FROM Room WHERE Room_No = ?";
        jdbcTemplate.update(query, roomNo);
    }
}
