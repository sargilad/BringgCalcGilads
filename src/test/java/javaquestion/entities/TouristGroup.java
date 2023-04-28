package javaquestion.entities;

public class TouristGroup {
    String from;
    int howMany;
    Site site;

    public TouristGroup(String from, int howMany, Site site) {
        this.from = from;
        this.howMany = howMany;
        this.site = site;
    }

    public int getHowMany() {
        return howMany;
    }

    public Site getSite() {
        return site;
    }

    public String toString() {
        return String.format("Group from %s, contains: %s members, destination: %s", from, howMany, site.getSiteName());
    }

    public boolean canCloseDeal() {
        return site.getMaxCapacity() >= getHowMany() &&
                site.getMaxCapacity() * 0.9 <= getHowMany();
    }
}
