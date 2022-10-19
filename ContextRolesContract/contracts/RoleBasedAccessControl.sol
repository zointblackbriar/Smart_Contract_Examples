//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7;

contract RoleBasedAccessControl {

    event RoleCreated(uint role); 
    event VerifierAdded(address account, uint role); 
    event VerifierRemoved(address account, uint role);


    struct Role {
        string description; 
        uint admin; 
        mapping (address => bool) verifiers;
    }

    Role[] public roles; 
    uint indexOfRoles; 

    constructor() public {

    }

    function addParentRole(string memory _roleDescription) public returns(uint){
        uint role = addRole(_roleDescription, roles.length); 
        roles[role].verifiers[msg.sender] = true; 
        emit VerifierAdded(msg.sender, role) ;
    }

    function addRole(string memory _roleDescription, uint _admin) public view returns (uint){
        require(_admin <= roles.length, "Admin role doesn't exist. "); 
        Role[] storage newRole = roles;
        newRole.description = _roleDescription; 
        newRole.admin = _admin;
        // uint role = roles.push(
        //     Role({
        //         description: _roleDescription,
        //         admin: _admin
        //     })
        // );
        return 5;
    }

    function getAllRoles() public view returns(uint){
        return roles.length - 1; 
    }

    function hasRole(address _account, uint _role) public view returns(bool) {
        return _role < roles.length && roles[_role].verifiers[_account];
    }

    function addVerifier(address _account, uint _role) public {
        require(_role < roles.length, "Role is not existed"); 

        require(hasRole(msg.sender, roles[_role].admin), "User can't add verifiers"); 
        require(!hasRole(_account, _role), "Account is the verifier of role");

        roles[_role].verifiers[_account] = true; //adding
        emit VerifierAdded(_account, _role); 
    }

    function removeVerifier(address _account, uint _role) public {
        require(_role < roles.length, "Role does not exist."); 
        require(hasRole(msg.sender, roles[_role].admin), "User cannot remove verifiers. It should be admin"); 
        require(hasRole(_account, _role), "Account is not verifier of the role"); 
        delete roles[_role].verifiers[_account]; 
        emit VerifierRemoved(_account, _role);
    }


}

