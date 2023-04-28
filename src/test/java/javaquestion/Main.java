package javaquestion;

import javaquestion.entities.Site;
import javaquestion.entities.SiteName;
import javaquestion.entities.TouristGroup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Site kotel = new Site(SiteName.KOTEL, 100);
        Site eilat = new Site(SiteName.EILAT, 300);
        Site haifa = new Site(SiteName.HAIFA, 400);

        TouristGroup[] groups = {new TouristGroup("Japan", 90, kotel),
                new TouristGroup("China", 95, kotel),
                new TouristGroup("USA", 96, kotel),
                new TouristGroup("USA", 96, eilat),
                new TouristGroup("China", 360, haifa),
                new TouristGroup("China", 370, haifa),
                new TouristGroup("China", 300, eilat)
        };

        LinkedList<TouristGroup> touristGroupLinkedList = new LinkedList<>(Arrays.asList(groups));

        //Section a->c
        TourFactory tourFactory = new TourFactory();
        tourFactory.filterSitesOfInterest(touristGroupLinkedList).
                filterCanCloseDealSites(touristGroupLinkedList).
                printLargestGroupPerSite(touristGroupLinkedList);

//        Section d
        Map<Site, List<TouristGroup>> groupsPerSite = tourFactory.mapGroupsPerSite(touristGroupLinkedList);


    }
}
