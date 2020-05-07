pragma solidity >=0.4.21 <0.6.0;

contract Roles {
    //hello Roles
    //sample Role Oriented Pet Shop

    //Adoptint a pet -- Adopt role

    //Define a role type
    //Role type can be a struct datatype
    // We need to write test methods as well

    struct Place{
        string identifier; // identifier is Place
        uint lower; // attributes
        uint upper; // attributes
    }

    // a mapping is referrind a hash table, which consists of key types and value type pairs.

    mapping (address => Place) places; // A mapping is equivalent to a hash table or hash map. 
    // a state variable like places is the equivalent of a member variable.

    address[] public placeActs;  

    function setPlace(address _address, uint _lower, uint _upper, string _identifier) public {
        var place_setter = places[_address]; 

        place_setter.identifier = _identifier;
        place_setter.lower = _lower;
        place_setter.upper = _upper;

        placeAccts.push(_address) -1;
    } 

    function getPlace() view public returns (address[]) {
        return placeActs; // return the address of the function
    }

    function getPlace(address _address) view public returns (uint, string, string) {
        return (places[_address].identifier, places[_address].lower, places[_address].upper);
    }

    function countPlaces() view public returns (uint) {
        return placeActs.length;
    }

    // Wie kann ich die folgende Datenstrukturen von Modelierung definieren? 
    // On relationships
    // RoleConstraint
    // RoleInheritance
    // IntraRelationshipContraint
    // InterRelationship
    // IntraRelationship
    // Role Group
    // Compartment Inheritance


}

