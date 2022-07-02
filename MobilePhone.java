class MobilePhone {
    String Name;
    String Descripton;
    String ImageLink;
    double Price;
    double Rating;
    String StoreName;

    public MobilePhone(
        String name,
        String desc,
        String imgLink,
        double price,
        double rating,
        String store
    ) {
        this.Name = name;
        this.Descripton = desc;
        this.ImageLink = imgLink;
        this.Price = price;
        this.Rating = rating;
        this.StoreName = store;
    }

    @Override
    public String toString()
    {
        return this.Name + ","
            + this.Descripton + ","
            + this.ImageLink + ","
            + this.Price + ","
            + this.Rating + ","
            + this.StoreName;
    }
}