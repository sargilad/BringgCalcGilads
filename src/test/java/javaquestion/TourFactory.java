package javaquestion;

import javaquestion.entities.Site;
import javaquestion.entities.TouristGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TourFactory {
    private final LinkedList<Site> sitesOfInterestList = new LinkedList<>();
    private List<Site> canCloseDealSiteList = new ArrayList<>();

    //    Section A
    public TourFactory filterSitesOfInterest(LinkedList<TouristGroup> touristGroupLinkedList) {
        List<Site> collect = touristGroupLinkedList.stream().map(TouristGroup::getSite).distinct().collect(Collectors.toList());
        sitesOfInterestList.addAll(collect);

        return this;
    }

    //Section B
    public TourFactory filterCanCloseDealSites(LinkedList<TouristGroup> touristGroupLinkedList) {

        List<TouristGroup> canCloseDealGroups = touristGroupLinkedList.stream()
                .filter(group -> sitesOfInterestList.contains(group.getSite()))
                .filter(TouristGroup::canCloseDeal)
                .collect(Collectors.toList());

        canCloseDealSiteList = canCloseDealGroups.stream().map(TouristGroup::getSite).distinct().collect(Collectors.toList());

        return this;
    }


    //Section C
    public void printLargestGroupPerSite(LinkedList<TouristGroup> touristGroupLinkedList) {
        touristGroupLinkedList.stream()
                .filter(group -> canCloseDealSiteList.contains(group.getSite()))
                .filter(TouristGroup::canCloseDeal)
                .collect(
                        Collectors.toMap(TouristGroup::getSite, Function.identity(),
                                (TouristGroup tg1, TouristGroup tg2) -> tg1.getHowMany() > tg2.getHowMany() ? tg1 : tg2)).
                forEach((site, touristGroup) -> System.out.println(touristGroup.toString()));
    }

    //    Section D
    public Map<Site, List<TouristGroup>> mapGroupsPerSite(LinkedList<TouristGroup> touristGroupLinkedList) {
        return touristGroupLinkedList.stream()
                .collect(groupingBy(TouristGroup::getSite));
    }

}






