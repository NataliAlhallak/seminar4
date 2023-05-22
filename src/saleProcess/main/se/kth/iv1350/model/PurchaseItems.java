package saleProcess.main.se.kth.iv1350.model;


public class PurchaseItems {
    private int itemID;
    private ItemDTO itemInfo;

    /**
     * creats an instance of purchased items with the item identifire and item information.
     * @param identifier is the nummer the identify the item.
     * @param itemsInfo the informations of the item.
     */
    public  PurchaseItems(int identifier, ItemDTO itemsInfo){
        this.itemID = identifier;
        this.itemInfo = itemsInfo;
    }


    /**
     * Gets the items identfier.
     * @return item identifier.
     */
    public int getItemIdenitifier(){
        return itemID;
    }

    /**
     * Its represents the items information
     * @return items informaiton.
     */
    public ItemDTO getItemInfo(){
        return itemInfo;
    }

}
