package com.example.turistguideapi.repository;

import com.example.turistguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    TouristAttraction touristAttraction1 = new TouristAttraction("Havfrue", "Den lille Havfrue. En sej lille dame, på en sej lille sten");
    TouristAttraction touristAttraction2 = new TouristAttraction("Runde", "Runde tårn. Ret højt tårn, som er ret rundt");
    TouristAttraction touristAttraction3 = new TouristAttraction("Amalienborg","Nydeligt hus til en nydelig familie");

    List<TouristAttraction> attractions = new ArrayList<>(List.of(touristAttraction1, touristAttraction2, touristAttraction3));

    public List<TouristAttraction> getListOfAttractions(){
        return attractions;
    }

    public TouristAttraction getTouristAttractionByName(String name){
        for (TouristAttraction ta : attractions){
            if (ta.getName().toLowerCase().contains(name.toLowerCase())){
                return ta;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        attractions.add(touristAttraction);
        return touristAttraction;
    }

    public void deleteTouristAttraction(String name){
        TouristAttraction found = new TouristAttraction("", "");

        for (TouristAttraction ta : attractions){
            if (ta.getName().toLowerCase().contains(name.toLowerCase())){
                found = ta;
                break;
            }
        }
        attractions.remove(found);

    }


    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction){
        int i = 0;

        while (i < attractions.size()){
            if (touristAttraction.getName().toLowerCase().contains(touristAttraction.getName())){
                attractions.set(i, touristAttraction);
                break;
            }
            i++;
        }

        return null;
    }
}
