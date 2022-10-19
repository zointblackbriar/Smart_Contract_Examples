
var globalConfigurationRoles = {
    PROXYAddressRoleApplication: "sample",
};

//proxy object
var globalConfigurationRolesProxy = new Proxy(globalConfigurationRoles, {
    get(globalConfigurationRoles, prop) {
        console.log('getter our object', globalConfigurationRoles, 'getting', prop);
        return globalConfigurationRoles[prop];    
    },

    set(globalConfigurationRoles, prop, newVal){
        console.log('setter our object', globalConfigurationRoles, 'setting', prop, 'to', newVal);
        return globalConfigurationRoles[prop] = newVal;
    
    },
});


var globalConfigurationTest = {
    PROXYAddressTest : "sample",
}; 

//proxy object
var globalConfigurationTestProxy = new Proxy(globalConfigurationTest, {
    get(globalConfigurationTest, prop) {
        console.log('getter our object', globalConfigurationTest, 'getting', prop);
        return globalConfigurationTest[prop];    
    },

    set(globalConfigurationTest, prop, newVal){
        console.log('setter our object', globalConfigurationTest, 'setting', prop, 'to', newVal);
        return globalConfigurationTest[prop] = newVal;
    
    },
});

module.exports = {globalConfigurationRolesProxy, globalConfigurationTestProxy};