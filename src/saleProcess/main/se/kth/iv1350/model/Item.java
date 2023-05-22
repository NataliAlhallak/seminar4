package saleProcess.main.se.kth.iv1350.model;

public class Item {
    private ItemDTO items;
    private int itemQuantity;
    private PurchaseItems itemId;


    /**
     * creat a new instanse to get the itemsDTO and items quantity.
     * @param item is used to get items information
     * @param itemQuantity is used to get items quantity.
     */
    public Item(ItemDTO item, int itemQuantity){
        this.items = item;
        this.itemQuantity = itemQuantity;

    }

    /**
     * A method to get the items quantity.
     * @return items quantity.
     */
    public int getItemQuantity (){
        return itemQuantity;
    }

    /**
     * Gets  items information.
     * @return the chosens items information.
     */
    public ItemDTO getItems(){
        return items;
    }

    /**
     * Increase the items quantity value.
     * @param quantity represent the chosen item quantity.
     * @return the increased item quantity.
     */
    public int increaseItemQuantity(int quantity){
        return itemQuantity + quantity;
    }

    /**
     * represnts the items identifier that the customer chose to purchase.
     * @return items identifier.
     */
    public PurchaseItems getID(){
        return itemId;
    }
}

