package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.mysema.query.types.expr.BooleanExpression;

import demo.Tester;

public interface QTesterRepository extends JpaRepository<Tester, Long>, QueryDslPredicateExecutor<Tester> {
	
}
