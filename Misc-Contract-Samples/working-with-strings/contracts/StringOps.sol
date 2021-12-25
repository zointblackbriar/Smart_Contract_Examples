pragma solidity ^0.4.0; 

contract StringOps {
    using strings for *;

    function doSomeStringOperation() {
        //convert string to slice
        var slice = "xyz abc".toSlice(); 

        //length of string
        var length = slice.len(); 

        //split a string 
        //subslice = xyz 
        //slice = abc
        var subslice = slice.split(" ".toSlice()); 

        //split a string into an array
        var splittedString = "www.sozcu.com".toSlice(); 
        var delimiter = ".".toSlice(); 
        var parts = new string[](splittedString.count(delim));

    }
}