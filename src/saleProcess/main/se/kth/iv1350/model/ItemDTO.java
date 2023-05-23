package saleProcess.main.se.kth.iv1350.model;

public class ItemDTO {
    private final String nameOfTheItem;
    private final double itemPrice;
    private final double itemVAT;

    /**
     * Creates an instance of the ItemDTO class to describe an item.
     *
     * @param name      The name of the item.
     * @param price     The price of the item.
     * @param itemVAT   The item VAT rate.
     */
    public ItemDTO (String name, double price, double itemVAT){
        this.nameOfTheItem = name;
        this.itemPrice = price;
        this.itemVAT = itemVAT;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemsName(){
        return nameOfTheItem;
    }

    /**
     * Gets the price of the item.
     *
     * @return The item's price.
     */

    public double getItemPrice(){
        return itemPrice;
    }

    /**
     * Gets the VAT rate for the item.
     *
     * @return The item's VAT rate.
     */
    public double getVATRate (){
        return itemVAT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ItemDTO otherItem = (ItemDTO) obj;

        return nameOfTheItem.equals(otherItem.nameOfTheItem) && itemPrice == otherItem.itemPrice && itemVAT == otherItem.itemVAT;
    }

    @Override
    public String toString(){
            return "ItemDTO {name=" + nameOfTheItem + ", price=" + itemPrice + ", taxRate=" + itemVAT+ "}";
        }
    }





