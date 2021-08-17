pragma solidity ^0.5.12; 

library StringOperations {
        //concatenation operation in Strings
        function concatenation(string memory _base, string memory _value) pure internal returns (string memory) {
            //bytes memory _baseBytes
            //bytes memory _valueBytes
            bytes memory _baseBytes = bytes(_base); 
            bytes memory _valueBytes = bytes(_value);



            //string memory _tempValue = _baseBytes.length + _valueBytes.length -- create a new string
            string memory _tempValue = new string(_baseBytes.length + _valueBytes.length);
            //copy the string -- bytes memory _newValue = bytes(string temp value)
            bytes memory _newValue = bytes(_tempValue);

            int i = 0; 
            int j = 0;

            //first loop for the first string
            //_newValue[index1++] = _baseBytes[index2++]  -- first string as bytes
            for(i=0; i < _baseBytes.length; i++) {
                _newValue[j++] = baseBytes[i];
            }

            //second loop for the second string
            //_newValue[index1++] = _valueBytes[index2++] -- second string as bytes
            for(i = 0; i < _valueBytes.length; i++) {
                _newValue[j++] = _valueBytes[i]; 
            }

            return string(_newValue);

        }
}