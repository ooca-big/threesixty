package za.co.yellowfire.threesixty.domain.rating;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AssessmentRepository extends MongoRepository<Assessment, String>, AssessmentRepositoryCustom {
	@Query("{employee.id: {$eq: ?0}}")
	List<Assessment> findByEmployeeId(final String userName);
	
	@Query("{$and: [{id: {$ne: ?1}}, {employee.id: {$eq: ?0}}]}")
	List<Assessment> findByEmployeeExcludingAssessment(final String userName, final String assessmentId);
	
	@Query(value = "{period.id: {$eq: ?0}}", count = true)
	long countByPeriod(final String periodId);

	@Query(value = "{$and:  [ {period.id: {$eq: ?0}}, {status: {$eq: ?1}} ]  }", count = true)
	long countByPeriod(final String periodId, final String status);

	@Query(value = "{active: {$eq: true}}", count = true)
	int countActive();
	
	@Query(value = "{$and: [{status: {$nin: ['Creating','Reviewed']}} ,{$or: [{employee.id: {$eq : ?0} }, {manager.id: {$eq : ?0}} ]}]}", count = true)
	int countActiveDue(final String userName);
}
