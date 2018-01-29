package com.spring.basics.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.basics.database.databasedemo.beans.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Custom Row Mapper
	 * @author vyniciuspontes
	 *
	 */
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Person person = new Person();
			
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			person.setLocation(rs.getString("location"));
			
			return person;
		}
	}
	

	public List<Person> findAll() {

		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(Integer id) {

		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int insert(Person person) {

		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )" + 
				" VALUES(?, ?, ?, ?);", new Object[] {person.getId(), person.getName(), 
						person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });
	}
	
	public int update(Person person) {
		
		return jdbcTemplate.update("update PERSON set name=?, location=?, birth_date=? where id=?;", new Object[] {person.getName(), 
						person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId() });
	}
	
	/**
	 * 
	 * @param id
	 * @return Number of rows affected
	 */
	public int delete(Integer id) {

		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}

}
