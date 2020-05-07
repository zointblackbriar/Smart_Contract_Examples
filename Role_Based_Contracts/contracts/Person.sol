pragma solidity >=0.4.21 <0.7.0;

contract Person {
    string _title;
    string _firstName;
    string _lastName;
    string _personAddress;

    mapping(string => Person) persons; // for one-to-many relationship

    function getTitle() public returns(string memory) {
        return _title;
    }

    function setTitle() public returns(string memory title) {
        _title = title;
    }

    function getFirstName() public returns(string memory) {
        return _firstName;
    }

    function setFirstName() public returns(string memory firstName) {
        _firstName = firstName;
    }
    
    function getLastName() public returns(string memory) {
        return _lastName;
    }

    function setLastName() public returns(string memory lastName) {
        _lastName = lastName;
    }

    function setPersonAddress() public returns(string memory personAddress){
        personAddress = personAddress;
    }

    function getPersonAddress() public returns(string memory) {
        return _personAddress;
    }

    //string concatenation
    function strConcat(string memory _a, string memory _b, string memory _c, string memory _d) internal returns (string memory) {
        bytes memory _ba = bytes(_a);
        bytes memory _bb = bytes(_b);
        bytes memory _bc = bytes(_c);
        bytes memory _bd = bytes(_d);
        string memory abcde = new string(_ba.length + _bb.length + _bc.length + _bd.length);
        bytes memory babcde = bytes(abcde);
        uint k = 0;
        uint i = 0;
        for (i = 0; i < _ba.length; i++) babcde[k++] = _ba[i];
        for (i = 0; i < _bb.length; i++) babcde[k++] = _bb[i];
        for (i = 0; i < _bc.length; i++) babcde[k++] = _bc[i];
        for (i = 0; i < _bd.length; i++) babcde[k++] = _bd[i];
        return string(babcde);
    }

        function toString() public returns (string memory) {
        return strConcat(_title, _firstName, _lastName, _personAddress);
    }
}
 
// Storage: The persistent memory that every account has is called storage. Storage is a key-value store where keys and values are both 32 bytes.
// Memory: Memory is a byte-array, which hold the data in it until the execution of the function. Memory starts with zero-size and can be expanded in 32-byte chunks
// by simply accessing or storing memory at indices greater than its current size.