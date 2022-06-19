// pragma solidity >=0.4.21 <0.6.0;

// //how to add first class relationship into this smart contract
// //think about it
// contract MultiAgents {

//   // This application expresses a workflow between a person sending a request and a person responding to the
//   // request and a person responding to the request.

//   // Application Roles
//   // Name        Description
//   // Requestor   The party that initiates the "Hello Ethereum!" request
//   // Responder   The party that responds to the Requestor

//   // States
//   // Name        Description
//   // Request     The state that occurs when a request has been made
//   // Respond     The state that occurs after a response has been made to the request.

//   //Set of States
//   enum StateType { Request, Respond}

//   //List of properties
//   StateType public State;
//   address public Requestor;
//   address public Responder;

//   //Messages
//   string public RequestMessage;
//   string public ResponseMessage;

//   // constructor function
//   constructor(string memory message) public
//   {
//       Requestor = msg.sender; //message sender
//       RequestMessage = message;
//       State = StateType.Request;
//   }

//   // call this function to send a request
//   function SendRequest(string memory requestMessage) public
//   {
//       if(Requestor != msg.sender)
//       {
//           revert();
//       }

//       RequestMessage = requestMessage;
//       State = StateType.Request;
//   }

//   // call this function to send a response
//   function SendResponse(string memory responseMessage) public
//   {
//       Responder = msg.sender;

//       // call ContractUpdated() to record this action
//       ResponseMessage = responseMessage;
//       State = StateType.Respond; // State Type
//   }

// }

