package javaquestion.entities;

public class Site {

    SiteName siteName;
    int maxCapacity;

    public Site(SiteName siteName, int maxCapacity) {
        this.siteName = siteName;
        this.maxCapacity = maxCapacity;
    }

    public SiteName getSiteName() {
        return siteName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
