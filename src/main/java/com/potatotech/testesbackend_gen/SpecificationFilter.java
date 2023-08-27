package com.potatotech.testesbackend_gen;

import com.potatotech.authorization.exception.ServiceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class SpecificationFilter<T> {

    public Specification<T> customFilter(String filter){
        Specification<T> spec = Specification.where(null);
        if(filter == null || filter.isEmpty()){
            return spec;
        }

        return (root, query, cb) -> {
            try{
                if (filter == null || filter.isEmpty()) {
                    return null;
                }

                Predicate predicateAnd = cb.conjunction();
                Predicate predicateOr = cb.disjunction();
                String[] and = null ;
                String[] or = null ;

                if(filter.contains("and")){
                    and = filter.split("and");
                    for(var i : and){
                        predicateAnd = cb.and(predicateAnd,setEq(cb, i, root));
                    }
                }
                else if(filter.contains("or")){
                    or = filter.split("or");
                    for(var i : or){
                        predicateOr = cb.or(predicateOr,setEq(cb, i, root));
                    }
                } else {
                    predicateAnd = cb.and(predicateAnd, setEq(cb, filter, root));
                }

                return cb.or(predicateAnd,predicateOr);
            } catch (Exception ex){
                throw new ServiceException(HttpStatus.BAD_REQUEST,"Invalid filter: " + filter);
            }
        };
    }

    private Predicate setEq(CriteriaBuilder cb, String item, Root<T> root) {

        var criteria = item.split("eq");
        if(criteria.length == 2){
            return cb.like(cb.lower(root.get(criteria[0].trim())), "%".concat(criteria[1].trim()).concat("%").toLowerCase());
        }
        return null;
    }

}
