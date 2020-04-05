/**
 * 
 */
package com.rameshj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rameshj.model.UserInformation;

/**
 * @author Ramesh
 *
 */
@Repository
public interface UserInformationRepository extends CrudRepository<UserInformation, Integer> {

	UserInformation findByFirstName(String firstName);
}
