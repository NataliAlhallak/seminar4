package saleProcess.main.se.kth.iv1350.model;

public class Item {
    private ItemDTO items;
    private int itemQuantity;
    private PurchaseItems itemId;

    /**
     * Creates a new instance of the Item class with the specified item and item quantity.
     *
     * @param item          The item information.
     * @param itemQuantity  The quantity of the item.
     */
    public Item(ItemDTO item, int itemQuantity){
        this.items = item;
        this.itemQuantity = itemQuantity;

    }

    /**
     * Gets the quantity of the item.
     *
     * @return The item quantity.
     */
    public int getItemQuantity (){
        return itemQuantity;
    }

    /**
     * Gets the information of the item.
     *
     * @return The chosen item's information.
     */
    public ItemDTO getItems(){
        return items;
    }

    /**
     * Increases the quantity of the item.
     *
     * @param quantity The quantity to be added to the item.
     * @return The increased item quantity.
     */
    public int increaseItemQuantity(int quantity){
        return itemQuantity + quantity;
    }

    /**
     * Represents the identifier of the item that the customer chose to purchase.
     *
     * @return The item identifier.
     */
    public PurchaseItems getID(){
        return itemId;
    }
}

