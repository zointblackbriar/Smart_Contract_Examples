package scrollRoles

import scroll.internal.Compartment

class UserCompartment extends Compartment {

  class CustomerRole() {
    def roleDescription: String = "customer"
  }

  class OwnerRole() {
    def roleDescription: String = "owner"
  }
}
