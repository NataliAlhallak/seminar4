package saleProcess.main.se.kth.iv1350.model;

public class ItemDTO {
    private final String nameOfTheItem;
    private final double itemPrice;
    private final double itemVAT;

    /**
     * Creates an instance to desripe an item.
     * @param name the name of the item.
     * @param price the price of the item.
     * @param itemVAT the item VAT rate.
     */
    public ItemDTO (String name, double price, double itemVAT){
        this.nameOfTheItem = name;
        this.itemPrice = price;
        this.itemVAT = itemVAT;
    }


    /**
     * gets the name of the item.
     * @return the name of the item.
     */
    public String getItemsName(){
        return nameOfTheItem;
    }

    /**
     * gets the price of the item.
     * @return items price.
     */
    public double getItemPrice(){
        return itemPrice;
    }

    /**
     * get the VAT rate for the item.
     * @return the item vat rate.
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





