pragma solidity >=0.4.22 <0.7.0;

contract Supplier {

  /* Events */
  event ItemAdded(uint idItem);
  event ProcessAnOrder(uint idOfCustomer, uint idOrder, bool status);

  struct Item {
    uint idItem;
    bytes32 itemName;
    uint price;
  }

  struct Orderlog {
    uint idOfCustomer;
    uint idOrder; 
    bool status;
  }

  // STATE Variables.
  uint numberOfItemsAvailableForSale;
  uint numberOfOrdersProcessed;

  // Mappings 
  mapping (uint => Item) items;
  mapping (uint => Orderlog) orderLogs;


  /* TRANSACTIONS */
  function addItem(bytes32 itemName, uint price) public {
    uint idItem = numberOfItemsAvailableForSale++;
    items[idItem] = Item(idItem, itemName, price);
    emit ItemAdded(idItem);
  }

  function processOrder(uint idOrder, uint idCustomer) public {
    orderLogs[idOrder] = Orderlog(idCustomer, idOrder, true);
    numberOfOrdersProcessed ++;
    emit ProcessAnOrder(idCustomer, idOrder, true);
  }

  /* GETTERS */
  function getItem(uint idItem) public view  returns (bytes32, uint){
    /*returns itemName and its price*/
    return (items[idItem].itemName, items[idItem].price);
  }

  function getStatus(uint idOrder) public view returns (bool) {
    /*returns completion status*/
    return (orderLogs[idOrder].status);
  }

  function getTotalNumberOfAvailableItems() public view returns (uint) {
    return numberOfItemsAvailableForSale;
  }

  function getTotalNumberOfOrdersProcessed() public view returns (uint){
    return numberOfOrdersProcessed;
  }

}