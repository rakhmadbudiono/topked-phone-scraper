class Scraper {
    public Scraper() {}

    public MobilePhone[] ScrapMobilePhones() {
        return new MobilePhone[]{
            new MobilePhone(
                "Mobile Phone 1",
                "Mobile Phone 1 Series A",
                "https://img.freepik.com/free-photo/mobile-smart-phone-white-background-technology_10541-3965.jpg?w=1380",
                6900000.0,
                4.2,
                "Store 1"
            ),
            new MobilePhone(
                "Mobile Phone 2",
                "Mobile Phone 2 Series B",
                "https://img.freepik.com/free-photo/mobile-smart-phone-white-background-technology_10541-3965.jpg?w=1380",
                4200000.0,
                1.3,
                "Store 2"
            )
        };
    }
}