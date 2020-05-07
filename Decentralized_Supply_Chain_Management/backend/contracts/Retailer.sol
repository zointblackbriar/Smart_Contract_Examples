pragma solidity >=0.4.22 <0.7.0;

contract Retailer {

  /* Events */
  event OrderRaisedOrUpdated(uint idOrder);

  struct AvailableCustomer {
    uint idCustomer;
    bytes32 customerName;
  }

  struct Orderlog {
    uint idOrder;
    uint idCustomer;
    bytes32 itemName;
    uint quantity;
    bool status;
  }

  // STATE Variables.
  uint numberOfItemsPurchased;
  uint numberOfItemsReceived;

  // Mappings 
  mapping (uint => AvailableCustomer) customers;
  mapping (uint => Orderlog) orderLogs;

  /* Constructor */
  constructor() public {
      /* For the case of demo, adding a customer in constructor. You can take this idea and extend the contract to contain addCustomer section and hence maintain customerDB in the Blockchain! */
      customers[0] = AvailableCustomer(1, "Orcun Oruc");
  }

  /* TRANSACTIONS */
  function purchaseItem(bytes32 itemName, uint quantity) public {
    uint idOrder = numberOfItemsPurchased++;
    orderLogs[idOrder] = Orderlog(idOrder, 0, itemName, quantity, false);
    emit OrderRaisedOrUpdated(idOrder);
  }

  function recieveItem(uint idOrder) public {
      numberOfItemsReceived++;
      orderLogs[idOrder].status = true;
      emit OrderRaisedOrUpdated(idOrder);
  }

  /* GETTERS */
  function getOrderDetails(uint idOrder) public view  returns (bytes32, uint, bool){
    /*returns itemName, quantity & completionStatus*/
    return (orderLogs[idOrder].itemName, orderLogs[idOrder].quantity, orderLogs[idOrder].status);
  }

  function getNumberOfItemsPurchased() public view returns (uint) {
    return numberOfItemsPurchased;
  }

  function getNumberOfItemsReceived() public view returns (uint) {
    return numberOfItemsReceived;
  }

}