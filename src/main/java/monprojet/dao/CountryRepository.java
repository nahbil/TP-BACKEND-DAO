package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT SUM(population) "
    + "FROM City c "
    + "WHERE c.country.id = :countryId")
    public int calculDePopulationByCountryId(int countryId);

    @Query("SELECT country.name, city.population " +
    "FROM Country country JOIN country.cities city " +
    "GROUP BY country.id")
    List<CountryPopulationProjection> getCountryPopulationList();
}
